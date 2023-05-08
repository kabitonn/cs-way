package com.vika.way.spring.strategy.impl;

import com.vika.way.common.lang.strategy.annotation.Strategy;
import com.vika.way.common.lang.strategy.constants.Tenant;
import com.vika.way.spring.strategy.ExampleStrategy;
import org.springframework.stereotype.Service;

/**
 * @author chenwei.tjw
 * @date 2023/2/2
 **/
@Service
@Strategy(tenant = Tenant.ALL_TENANT,
        group = {"example", "default"},
        code = "ExampleStrategy1", name = "测试策略1",
        value = ExampleStrategy.class)
public class ExampleStrategy1 implements ExampleStrategy {

    @Override
    public String getStrategyName() {
        return "ExampleStrategy1";
    }
}
