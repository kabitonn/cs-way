package com.vika.way.spring.strategy;

import com.vika.way.spring.integration.base.TestCaseBase;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author chenwei.tjw
 * @date 2023/2/9
 **/
public class StrategyInvokerIntegrationTest extends TestCaseBase {

    @Resource
    StrategyInvoker strategyInvoker;


    @Test
    public void testInvoke() {
        strategyInvoker.invoke();
    }
}
