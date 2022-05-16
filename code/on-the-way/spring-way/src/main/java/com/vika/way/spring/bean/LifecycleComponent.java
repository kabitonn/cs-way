package com.vika.way.spring.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author chenwei.tjw
 * @date 2022/5/13
 **/
@Component
public class LifecycleComponent implements InitializingBean {


    public void init() {
        System.out.println("************************************************************");
        System.out.println("init-method is called");
    }

    public void destroy(){
        System.out.println("************************************************************");
        System.out.println("destroy-method is called");
    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("************************************************************");
        System.out.println("LifecycleComponent@postConstruct is called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("************************************************************");
        System.out.println("LifecycleComponent@preDestroy is called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("************************************************************");
        System.out.println("LifecycleComponent@afterPropertiesSet is called");
    }
}
