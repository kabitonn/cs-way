package com.vika.way.srpc.consumer;

import com.vika.way.srpc.protocol.RpcRequest;
import com.vika.way.srpc.protocol.RpcResponse;
import com.vika.way.srpc.registry.ServiceRegistry;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * RPC客户端处理器
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Slf4j
public class RpcInvokeHandler<T> implements InvocationHandler {

    private String serviceVersion;

    private ServiceRegistry serviceRegistry;

    public RpcInvokeHandler(String serviceVersion, ServiceRegistry serviceRegistry) {
        this.serviceVersion = serviceVersion;
        this.serviceRegistry = serviceRegistry;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        RpcRequest request = new RpcRequest();
        request.setRequestId(UUID.randomUUID().toString());
        request.setClassName(method.getDeclaringClass().getName());
        request.setServiceVersion(this.serviceVersion);
        request.setMethodName(method.getName());
        request.setParameterTypes(method.getParameterTypes());
        request.setParameters(args);

        // Debug
        log.debug(method.getDeclaringClass().getName());
        log.debug(method.getName());
        for (int i = 0; i < method.getParameterTypes().length; ++i) {
            log.debug(method.getParameterTypes()[i].getName());
        }
        for (int i = 0; i < args.length; ++i) {
            log.debug(args[i].toString());
        }

        RpcConsumer rpcConsumer = new RpcConsumer(this.serviceRegistry);
        RpcResponse rpcResponse = rpcConsumer.sendRequest(request);
        if (rpcResponse != null) {
            log.debug("consumer receive provider rpc response: {}", rpcResponse.toString());
            return rpcResponse.getResult();
        } else {
            throw new RuntimeException("consumer rpc fail, response is null");
        }
    }
}
