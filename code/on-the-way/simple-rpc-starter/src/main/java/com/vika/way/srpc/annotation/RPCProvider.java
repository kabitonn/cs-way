package com.vika.way.srpc.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 提供者注解
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface RPCProvider {

    Class<?> serviceInterface() default Object.class;

    String serviceVersion() default "1.0.0";

}
