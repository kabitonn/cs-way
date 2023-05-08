package com.vika.way.common.lang.strategy.callback;

import com.vika.way.common.lang.strategy.IStrategy;

import java.util.function.Function;

/**
 * 策略服务回调
 *
 * @author chenwei.tjw
 * @date 2023/2/2
 **/
public interface StrategyCallBack<T extends IStrategy, R> extends Function<T, R> {
}
