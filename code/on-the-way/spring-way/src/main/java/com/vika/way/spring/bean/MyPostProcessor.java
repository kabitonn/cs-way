package com.vika.way.spring.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

/**
 * @author chenwei.tjw
 * @date 2022/5/13
 **/
@Component
public class MyPostProcessor implements BeanPostProcessor, BeanFactoryPostProcessor, ApplicationContextAware {

    private ApplicationContext context;

    public MyPostProcessor() {
        super();
        System.out.println(getClass().getSimpleName() + " constructor is called");
    }

    /**
     * 针对所有Spring上下文中所有的bean
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.print("对象开始实例化");
        System.out.println(beanName + "@BeanPostProcessor#postProcessBeforeInitialization is called");

        return bean;
    }

    /**
     * 针对所有Spring上下文中所有的bean
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.print("对象实例化完成");
        System.out.println(beanName + "@BeanPostProcessor#postProcessAfterInitialization is called");

        return bean;
    }


    /**
     * 针对所有Spring上下文中所有bean的定义
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //遍历容器里的所有bean
        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            BeanDefinition definition = beanFactory.getBeanDefinition(beanName);
            String beanClassName = definition.getBeanClassName();
            System.out.println(beanName + "*****postProcessBeanFactory*****:" + definition.getBeanClassName());
            // 当用 @Bean 返回的类型是Object时，beanClassName是 null
            if (beanClassName != null) {
                //使用反射获取bean的class对象，注意classloader是容器加载bean的classloader
                Class<?> clazz = ClassUtils.resolveClassName(beanClassName, definition.getClass().getClassLoader());
                System.out.println(beanName + "*****postProcessBeanFactory*****beanClassName:" + beanClassName);
            }
        }
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("lifecycleBean");
        beanDefinition.getPropertyValues().addPropertyValue("name", "cycleBean");
        BeanDefinition cycleDefinition = beanFactory.getBeanDefinition("lifecycleComponent");
        cycleDefinition.getPropertyValues().addPropertyValue("name", "cycleComponent");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        System.out.println(getClass().getSimpleName() + "@ApplicationContextAware#setApplicationContext is called");
    }


}
