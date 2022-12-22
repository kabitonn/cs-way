package com.vika.way.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author chenwei.tjw
 * @date 2022/5/13
 **/
public class LifecycleBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, EnvironmentAware, ApplicationContextAware {

    private String name;

    private String beanName;

    private BeanFactory beanFactory;

    public LifecycleBean() {
        System.out.println(getClass().getSimpleName() + " constructor is called");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(getClass().getSimpleName() + "属性注入#setName is called");
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println(getClass().getSimpleName() + "@BeanNameAware#setBeanName is called");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        System.out.println(getClass().getSimpleName() + "@BeanFactoryAware#setBeanFactory is called");
    }

    public void init() {
        System.out.println("************************************************************");
        System.out.println(getClass().getSimpleName() + "@init-method is called");
    }


    public void destroyMethod() {
        System.out.println("************************************************************");
        System.out.println(getClass().getSimpleName() + "@destroy-method is called");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("************************************************************");
        System.out.println(getClass().getSimpleName() + "@postConstruct is called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("************************************************************");
        System.out.println(getClass().getSimpleName() + "@preDestroy is called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("************************************************************");
        System.out.println(getClass().getSimpleName() + "@InitializingBean#afterPropertiesSet is called");
    }


    @Override
    public void destroy() {
        System.out.println("************************************************************");
        System.out.println(getClass().getSimpleName() + "@DisposableBean#destroy is called");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(getClass().getSimpleName() + "@ApplicationContextAware#setApplicationContext is called");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println(getClass().getSimpleName() + "@EnvironmentAware#EnvironmentAware is called" + environment);
    }
}
