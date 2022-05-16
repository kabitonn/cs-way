package com.vika.way.srpc.provider;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.vika.way.srpc.annotation.RPCProvider;
import com.vika.way.srpc.constants.Constants;
import com.vika.way.srpc.protocol.RpcDecoder;
import com.vika.way.srpc.protocol.RpcEncoder;
import com.vika.way.srpc.registry.ServiceMetadata;
import com.vika.way.srpc.registry.ServiceRegistry;
import com.vika.way.srpc.utils.ProviderUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Rpc提供者
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Slf4j
public class RpcProviderPostProcessor implements InitializingBean, BeanPostProcessor {

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("rpc-provider-pool-%d").build();
    private static ThreadPoolExecutor threadPoolExecutor;

    private String serverAddress;
    private ServiceRegistry serviceRegistry;
    private Map<String, Object> handlerMap = new HashMap<>(256);
    private EventLoopGroup bossGroup = null;
    private EventLoopGroup workerGroup = null;

    public RpcProviderPostProcessor(String serverAddress, ServiceRegistry serviceRegistry) {
        this.serverAddress = serverAddress;
        this.serviceRegistry = serviceRegistry;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public static void submit(Runnable task) {
        if (threadPoolExecutor == null) {
            synchronized (RpcProviderPostProcessor.class) {
                if (threadPoolExecutor == null) {
                    threadPoolExecutor = new ThreadPoolExecutor(Constants.PROVIDER_THREAD_POOL_NUM, Constants.PROVIDER_THREAD_POOL_NUM,
                            600L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(Constants.PROVIDER_THREAD_POOL_QUEUE_LEN),
                            threadFactory);
                }
            }
        }
        threadPoolExecutor.submit(task);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(() -> {
            try {
                start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 开启Netty服务监听，进行服务注册
     */
    public void start() throws InterruptedException {
        if (bossGroup == null || workerGroup == null) {
            bossGroup = new NioEventLoopGroup();
            workerGroup = new NioEventLoopGroup();
            ServerBootstrap bootstrap = new ServerBootstrap();
            //通用平台使用NioServerSocketChannel，Linux使用EpollServerSocketChannel
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline()
                                    .addLast(new LengthFieldBasedFrameDecoder(65536, 0, 4, 0, 0))
                                    .addLast(new RpcDecoder())
                                    .addLast(new RpcEncoder())
                                    .addLast(new RpcProviderHandler(handlerMap));
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            String[] array = serverAddress.split(":");
            String host = array[0];
            int port = Integer.parseInt(array[1]);

            //启动服务
            ChannelFuture future = bootstrap.bind(host, port).sync();
            log.info("Server started on port {}", port);

            future.channel().closeFuture().sync();
        }
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        RPCProvider rpcProvider = bean.getClass().getAnnotation(RPCProvider.class);
        if (rpcProvider == null) {
            return bean;
        }
        String serviceName = rpcProvider.serviceInterface().getName();
        String version = rpcProvider.serviceVersion();
        String providerKey = ProviderUtils.makeKey(serviceName, version);
        //缓存provider bean到本地缓存中
        handlerMap.put(providerKey, bean);

        // 注册服务到注册中心
        String[] array = serverAddress.split(":");
        String host = array[0];
        int port = Integer.parseInt(array[1]);
        ServiceMetadata metadata = ServiceMetadata.builder()
                .address(host)
                .serviceName(serviceName)
                .port(port)
                .serviceVersion(version).build();
        try {
            serviceRegistry.register(metadata);
            log.debug("register service: {}", metadata.toString());
        } catch (Exception e) {
            log.error("register service fail|{}|{}", metadata.toString(), e);
        }
        return bean;
    }

    /**
     * 手动注册一个服务，主要用于测试
     *
     * @param providerBean  服务提供方的bean
     * @param serverAddress 服务提供方地址
     */
    public void addService(Object providerBean, String serverAddress) {
        RPCProvider rpcProvider = providerBean.getClass().getAnnotation(RPCProvider.class);
        String serviceName = rpcProvider.serviceInterface().getName();
        String version = rpcProvider.serviceVersion();
        String providerKey = ProviderUtils.makeKey(serviceName, version);
        String[] array = serverAddress.split(":");
        String host = array[0];
        int port = Integer.parseInt(array[1]);
        ServiceMetadata metadata = ServiceMetadata.builder()
                .address(host)
                .serviceName(serviceName)
                .port(port)
                .serviceVersion(version)
                .build();
        try {
            serviceRegistry.register(metadata);
            log.debug("register service: {}", metadata.toString());
        } catch (Exception e) {
            log.error("register service fail|{}|{}", metadata.toString(), e);
        }

        if (!handlerMap.containsKey(providerKey)) {
            log.info("Loading service: {}", providerKey);
            handlerMap.put(providerKey, providerBean);
        }
    }
}
