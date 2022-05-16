package com.vika.way.srpc.provider;

import com.vika.way.srpc.common.RpcProperties;
import com.vika.way.srpc.registry.ServiceRegistry;
import com.vika.way.srpc.registry.ServiceRegistryFactory;
import com.vika.way.srpc.registry.ServiceRegistryType;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Configuration
@EnableConfigurationProperties(RpcProperties.class)
public class RpcProviderAutoConfiguration {

    @Resource
    private RpcProperties rpcProperties;

    @Bean
    public RpcProviderPostProcessor initRpcProviderPostProcessor() throws Exception {
        ServiceRegistryType type = ServiceRegistryType.valueOf(rpcProperties.getServiceRegistryType());
        ServiceRegistry serviceRegistry = ServiceRegistryFactory.getInstance(type, rpcProperties.getServiceRegistryAddress());
        return new RpcProviderPostProcessor(rpcProperties.getServiceAddress(), serviceRegistry);
    }
}
