package com.vika.way.spring.strategy;

import com.vika.way.common.lang.strategy.StrategyInvokeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


/**
 * @author chenwei.tjw
 * @date 2023/2/9
 **/
public class StrategyInvokerMockTest {

    @InjectMocks
    StrategyInvoker strategyInvoker;

    @Mock
    private StrategyInvokeService strategyInvokeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInvoke() {
        strategyInvoker.invoke();
    }
}
