package com.vika.way.spring.strategy;

import com.vika.way.common.lang.strategy.impl.StrategyInvokeServiceImpl;
import com.vika.way.spring.integration.base.TestCaseBase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;

/**
 * @author chenwei.tjw
 * @date 2023/2/9
 **/
public class StrategyInvokerIntegrationMockTest extends TestCaseBase {

    @InjectMocks
    StrategyInvoker strategyInvoker;

    @Spy
    private StrategyInvokeServiceImpl strategyInvokeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInvoke() {
        strategyInvoker.invoke();
    }
}
