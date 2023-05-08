package com.vika.way.spring.integration.base;

import com.alibaba.film.component.speedup.core.speed.Remote;
import com.alibaba.film.component.speedup.core.speed.junit.DelegateTestRunner;
import com.taobao.pandora.boot.test.junit4.DelegateTo;
import com.taobao.pandora.boot.test.junit4.PandoraBootRunner;
import com.vika.way.spring.TestApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenwei.tjw
 * @date 2023/2/9
 **/

@RunWith(DelegateTestRunner.class)//使用代理runner
@Remote(testRunner = PandoraBootRunner.class)//实际运行的测试runner
@DelegateTo(SpringJUnit4ClassRunner.class)//pandoraBootRunner使用的代理runner 实际就是springboot提供的测试runner
@SpringBootTest(classes = TestApplication.class)
public abstract class TestCaseBase {
}
