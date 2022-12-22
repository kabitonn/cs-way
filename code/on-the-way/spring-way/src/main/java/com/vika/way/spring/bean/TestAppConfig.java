package com.vika.way.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;

/**
 * @author chenwei.tjw
 * @date 2022/5/13
 **/
@Configuration
@DependsOn({"myPostProcessor"})
public class TestAppConfig {

    @Bean(initMethod = "init", destroyMethod = "destroyMethod")
    public LifecycleBean lifecycleBean() {
        return new LifecycleBean();
    }
}
