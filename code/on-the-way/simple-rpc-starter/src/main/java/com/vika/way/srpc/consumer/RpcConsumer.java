package com.vika.way.srpc.consumer;

import com.vika.way.srpc.protocol.RpcDecoder;
import com.vika.way.srpc.protocol.RpcEncoder;
import com.vika.way.srpc.protocol.RpcRequest;
import com.vika.way.srpc.protocol.RpcResponse;
import com.vika.way.srpc.registry.ServiceMetadata;
import com.vika.way.srpc.registry.ServiceRegistry;
import com.vika.way.srpc.utils.ProviderUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

/**
 * RPC消费者
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Slf4j
public class RpcConsumer extends SimpleChannelInboundHandler<RpcResponse> {

    private final Object obj = new Object();
    private ServiceRegistry serviceRegistry;
    private EventLoopGroup eventLoopGroup = new NioEventLoopGroup(4);
    private Channel channel;
    private RpcResponse rpcResponse;

    public RpcConsumer(ServiceRegistry serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
    }

    public RpcResponse sendRequest(RpcRequest rpcRequest) throws Exception {
        try {
            Bootstrap b = new Bootstrap();
            b.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            log.debug("init consumer request...");
                            socketChannel.pipeline()
                                    .addLast(new RpcEncoder())
                                    .addLast(new RpcDecoder())
                                    .addLast(RpcConsumer.this);
                        }
                    });
            String targetService = ProviderUtils.makeKey(rpcRequest.getClassName(), rpcRequest.getServiceVersion());
            ServiceMetadata serviceMetadata = serviceRegistry.discovery(targetService);
            if (serviceMetadata == null) {
                //没有获取到服务提供方
                throw new RuntimeException("no available service provider for " + targetService);
            }
            log.debug("discovery provider for {} -- {}", targetService, serviceMetadata.toString());
            final ChannelFuture future = b.connect(serviceMetadata.getAddress(), serviceMetadata.getPort()).sync();

            future.addListener((ChannelFutureListener) arg0 -> {
                if (future.isSuccess()) {
                    log.debug("connect rpc provider success");
                } else {
                    log.error("connect rpc provider fail");
                    future.cause().printStackTrace();
                    eventLoopGroup.shutdownGracefully(); //关闭线程组
                }
            });

            this.channel = future.channel();
            this.channel.writeAndFlush(rpcRequest).sync();

            synchronized (this.obj) {
                this.obj.wait();
            }

            return this.rpcResponse;
        } finally {
            close();
        }
    }

    /**
     * 客户端关闭
     */
    private void close() {
        //关闭客户端套接字
        if (this.channel != null) {
            this.channel.close();
        }
        //关闭客户端线程组
        if (this.eventLoopGroup != null) {
            this.eventLoopGroup.shutdownGracefully();
        }
        log.debug("shutdown consumer...");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcResponse rpcResponse) throws Exception {
        this.rpcResponse = rpcResponse;

        synchronized (obj) {
            obj.notifyAll(); // 收到响应，唤醒线程
        }
    }
}
