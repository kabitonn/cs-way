package com.vika.way.common.lang.strategy.configuration;


import com.vika.way.common.lang.strategy.StrategyInvokeService;
import com.vika.way.common.lang.strategy.impl.StrategyInvokeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenwei.tjw
 * @date 2023/2/2
 **/
@Configuration
public class ServiceAutoConfiguration {

    @Bean
    public StrategyInvokeService strategyInvokeService() {
        return new StrategyInvokeServiceImpl();
    }
}
