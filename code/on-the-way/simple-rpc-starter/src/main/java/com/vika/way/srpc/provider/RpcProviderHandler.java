package com.vika.way.srpc.provider;

import com.vika.way.srpc.protocol.RpcRequest;
import com.vika.way.srpc.protocol.RpcResponse;
import com.vika.way.srpc.utils.ProviderUtils;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.reflect.FastClass;

import java.util.Map;

/**
 * RPC服务端处理器
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Slf4j
public class RpcProviderHandler extends SimpleChannelInboundHandler<RpcRequest> {
    private final Map<String, Object> handlerMap;

    public RpcProviderHandler(Map<String, Object> handlerMap) {
        this.handlerMap = handlerMap;
    }

    /**
     * RPC请求处理器
     *
     * @param channelHandlerContext
     * @param request
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcRequest request) throws Exception {
        RpcProviderPostProcessor.submit(() -> {
            log.debug("Receive request {}", request.getRequestId());
            RpcResponse response = new RpcResponse();
            response.setRequestId(request.getRequestId());
            try {
                Object result = handle(request);
                response.setResult(result);
            } catch (Throwable throwable) {
                response.setError(throwable.toString());
                log.error("RPC Server handle request error", throwable);
            }
            channelHandlerContext.writeAndFlush(response).addListener(
                    (ChannelFutureListener) channelFuture ->
                            log.debug("Send response for request " + request.getRequestId()));
        });
    }

    private Object handle(RpcRequest request) throws Throwable {
        String providerKey = ProviderUtils.makeKey(request.getClassName(), request.getServiceVersion());
        Object providerBean = handlerMap.get(providerKey);

        if (null == providerBean) {
            throw new RuntimeException(String.format("provider not exist: %s:%s", request.getClassName(),
                    request.getMethodName()));
        }

        Class<?> providerClass = providerBean.getClass();
        String methodName = request.getMethodName();
        Class<?>[] parameterTypes = request.getParameterTypes();
        Object[] parameters = request.getParameters();

        log.debug(providerClass.getName());
        log.debug(methodName);
        for (int i = 0; i < parameterTypes.length; ++i) {
            log.debug(parameterTypes[i].getName());
        }
        for (int i = 0; i < parameters.length; ++i) {
            log.debug(parameters[i].toString());
        }

        FastClass providerFastClass = FastClass.create(providerClass);
        int methodIndex = providerFastClass.getIndex(methodName, parameterTypes);
        return providerFastClass.invoke(methodIndex, providerBean, parameters);
    }
}
