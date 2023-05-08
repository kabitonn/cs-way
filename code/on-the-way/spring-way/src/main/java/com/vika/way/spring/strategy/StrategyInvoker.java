package com.vika.way.spring.strategy;

import com.vika.way.common.lang.strategy.StrategyInvokeService;
import com.vika.way.common.lang.strategy.constants.StrategyGroup;
import com.vika.way.common.lang.strategy.constants.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenwei.tjw
 * @date 2023/2/2
 **/
@Component
public class StrategyInvoker {

    @Autowired
    private StrategyInvokeService strategyInvokeService;

    public void invoke() {
        strategyInvokeService.execute(Tenant.ALL_TENANT, "example", "ExampleStrategy1", null,
                ExampleStrategy.class, ExampleStrategy::getStrategyName, false);
        strategyInvokeService.execute(Tenant.ALL_TENANT, "ExampleStrategy2",
                ExampleStrategy.class, ExampleStrategy::getStrategyName, false);

        strategyInvokeService.executeGroup(Tenant.ALL_TENANT, "example",
                ExampleStrategy.class, strategy -> strategy.getStrategyName(), false);

        strategyInvokeService.executeGroup(Tenant.ALL_TENANT, "", "default",
                ExampleStrategy.class, strategy -> strategy.getStrategyName(), false);

    }
}
