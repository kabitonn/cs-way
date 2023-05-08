package com.vika.way.common.lang.strategy.annotation;

import com.vika.way.common.lang.strategy.constants.StrategyGroup;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 策略注解
 *
 * @author chenwei.tjw
 * @date 2023/2/2
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Strategy {

    /**
     * 租户
     *
     * @return
     */
    String tenant();

    /**
     * 策略组
     *
     * @return
     */
    String[] group() default {StrategyGroup.DEFAULT_GROUP};

    /**
     * 策略编码
     *
     * @return
     */
    String code();

    /**
     * 策略名称
     *
     * @return
     */
    String name();

    /**
     * 策略接口
     */
    Class value();
}
