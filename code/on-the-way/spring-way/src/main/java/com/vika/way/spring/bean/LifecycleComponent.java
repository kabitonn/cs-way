package com.vika.way.spring.bean;

import org.springframework.beans.factory.*;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author chenwei.tjw
 * @date 2022/5/13
 **/
@Component
@DependsOn({"lifecycleBean"})
public class LifecycleComponent implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware {

    private String name;

    private String beanName;

    private BeanFactory beanFactory;

    public LifecycleComponent() {
        System.out.println(getClass().getSimpleName() + " constructor is called");
    }

    public void setName(String name) {
        this.name = name;
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
}
