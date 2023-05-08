package com.vika.way.common.lang.strategy;

import com.google.common.base.Preconditions;
import com.vika.way.common.lang.strategy.annotation.Strategy;
import com.vika.way.common.lang.strategy.manager.StrategyManager;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Objects;

/**
 * 策略服务接口
 *
 * @author chenwei.tjw
 * @date 2023/2/2
 **/
public interface IStrategy {

    @PostConstruct
    default void register(){
        Strategy strategy = this.getClass().getAnnotation(Strategy.class);
        if (Objects.isNull(strategy)) {
            throw new RuntimeException(MessageFormat.format("miss @Strategy annotation on class {0}", this.getClass().getCanonicalName()));
        }
        Preconditions.checkArgument(Objects.nonNull(strategy.value()), MessageFormat.format("strategy is null on  @Strategy annotation of class {0}", this.getClass()));
        Arrays.stream(strategy.group())
                .forEach(group -> StrategyManager.register(strategy.tenant(), group, strategy.code(), strategy.value(), this));
    }
}
