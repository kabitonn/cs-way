package com.vika.way.spring.strategy;

import com.vika.way.common.lang.strategy.IStrategy;

/**
 * @author chenwei.tjw
 * @date 2023/2/2
 **/

public interface ExampleStrategy extends IStrategy {

    /**
     * 策略名称
     *
     * @return
     */
    String getStrategyName();
}
