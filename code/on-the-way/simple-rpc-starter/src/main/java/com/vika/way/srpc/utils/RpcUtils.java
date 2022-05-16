package com.vika.way.srpc.utils;

import com.vika.way.srpc.consumer.RpcInvokeHandler;
import com.vika.way.srpc.registry.ServiceRegistry;

import java.lang.reflect.Proxy;

/**
 * @author chenwei.tjw
 * @date 2022/5/13
 **/
public class RpcUtils {
    /**
     * 创建jdk动态代理类
     *
     * @param interfaceClass
     * @param serviceVersion
     * @param serviceRegistry
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T create(Class<T> interfaceClass, String serviceVersion, ServiceRegistry serviceRegistry) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new RpcInvokeHandler<>(serviceVersion, serviceRegistry));
    }
}
