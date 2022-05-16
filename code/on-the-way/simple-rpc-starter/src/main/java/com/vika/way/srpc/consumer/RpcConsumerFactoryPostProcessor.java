package com.vika.way.srpc.consumer;

import com.vika.way.srpc.annotation.RPCConsumer;
import com.vika.way.srpc.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Slf4j
public class RpcConsumerFactoryPostProcessor implements BeanFactoryPostProcessor, BeanClassLoaderAware, ApplicationContextAware {

    private ClassLoader classLoader;

    private ApplicationContext context;

    /**
     * linkedHashMap保证有序
     */
    private Map<String, BeanDefinition> beanDefinitions = new LinkedHashMap<>();

    /**
     * 动态修改被RPCConsumer注解的bean，改为代理类
     * @param field
     */
    private void parseElement(Field field) {
        RPCConsumer annotation = AnnotationUtils.getAnnotation(field, RPCConsumer.class);
        if (annotation == null) {
            return;
        }
        //构造工厂bean的参数
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(RpcSpringConsumerBean.class);
        builder.setInitMethodName(Constants.INIT_METHOD);
        builder.addPropertyValue("serviceVersion", annotation.serviceVersion());
        builder.addPropertyValue("interfaceClass", field.getType());
        builder.addPropertyValue("registryType", annotation.registryType());
        builder.addPropertyValue("registryAddress", annotation.registryAddress());

        BeanDefinition beanDefinition = builder.getBeanDefinition();
        beanDefinitions.put(field.getName(), beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //遍历容器里的所有bean
        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            BeanDefinition definition = beanFactory.getBeanDefinition(beanName);
            String beanClassName = definition.getBeanClassName();
            // 当用 @Bean 返回的类型是Object时，beanClassName是 null
            if(beanClassName != null) {
                //使用反射获取bean的class对象，注意classloader是容器加载bean的classloader
                Class<?> clazz = ClassUtils.resolveClassName(definition.getBeanClassName(), this.classLoader);
                ReflectionUtils.doWithFields(clazz, this::parseElement);
            }
        }

        //重新注入到容器中
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry)beanFactory;
        this.beanDefinitions.forEach((beanName, beanDefinition) -> {
            if (context.containsBean(beanName)) {
                throw new IllegalArgumentException("[RPC Starter] Spring context already has a bean named " + beanName
                        + ", please change @RPCConsumer field name.");
            }
            registry.registerBeanDefinition(beanName, beanDefinitions.get(beanName));
            log.info("registered RPCConsumerBean \"{}\" in spring context.", beanName);
        });
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
        log.debug("classloader: {}", this.classLoader.toString());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
