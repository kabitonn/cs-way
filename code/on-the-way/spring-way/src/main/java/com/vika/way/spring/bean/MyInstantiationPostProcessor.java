package com.vika.way.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

/**
 * @author chenwei.tjw
 * @date 2022/8/1
 **/
@Component
public class MyInstantiationPostProcessor implements InstantiationAwareBeanPostProcessor {

    public MyInstantiationPostProcessor() {
        super();
        System.out.println(getClass().getSimpleName() + " constructor is called");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println(beanName + "@InstantiationAwareBeanPostProcessorAdapter#postProcessBeforeInstantiation is called");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "@InstantiationAwareBeanPostProcessorAdapter#postProcessAfterInstantiation is called");
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println(beanName + pvs + "@InstantiationAwareBeanPostProcessorAdapter#postProcessProperties is called");
        return null;
    }
}
