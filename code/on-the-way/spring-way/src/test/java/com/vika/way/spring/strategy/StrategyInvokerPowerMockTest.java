package com.vika.way.spring.strategy;

import com.vika.way.common.lang.strategy.StrategyInvokeService;
import com.vika.way.common.lang.strategy.impl.StrategyInvokeServiceImpl;
import com.vika.way.spring.integration.base.TestCaseBase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;

/**
 * @author chenwei.tjw
 * @date 2023/2/9
 **/
public class StrategyInvokerPowerMockTest extends TestCaseBase {

    @Resource
    StrategyInvoker strategyInvoker;

    @Spy
    private StrategyInvokeServiceImpl strategyInvokeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        // Spring反射
        ReflectionTestUtils.setField(strategyInvoker, "strategyInvokeService", strategyInvokeService);
        // PowerMock反射工具
        Whitebox.setInternalState(strategyInvoker, "strategyInvokeService", strategyInvokeService);
    }

    @Test
    public void testInvoke() {
        strategyInvoker.invoke();
    }
}
