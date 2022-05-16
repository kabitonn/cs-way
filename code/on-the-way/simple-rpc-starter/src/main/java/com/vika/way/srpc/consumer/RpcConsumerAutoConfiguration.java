package com.vika.way.srpc.consumer;

import com.vika.way.srpc.common.RpcProperties;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Configuration
@EnableConfigurationProperties(RpcProperties.class)
public class RpcConsumerAutoConfiguration {
    @Bean
    public static BeanFactoryPostProcessor rpcConsumerPostProcess() {
        return new RpcConsumerFactoryPostProcessor();
    }
}
