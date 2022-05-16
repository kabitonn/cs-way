package com.vika.way.spring.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author chenwei.tjw
 * @date 2022/5/13
 **/
public class LifecycleBean implements InitializingBean {


    public void init() {
        System.out.println("************************************************************");
        System.out.println("LifecycleBean@init-method is called");
    }

    public void destroy(){
        System.out.println("************************************************************");
        System.out.println("LifecycleBean@destroy-method is called");
    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("************************************************************");
        System.out.println("LifecycleBean@postConstruct is called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("************************************************************");
        System.out.println("LifecycleBean@preDestroy is called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("************************************************************");
        System.out.println("LifecycleBean@afterPropertiesSet is called");
    }
}
