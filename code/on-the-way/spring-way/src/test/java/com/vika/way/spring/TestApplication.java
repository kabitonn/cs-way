package com.vika.way.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试启动类
 *
 * @author chenwei.tjw
 * @date 2023/2/9
 **/
@SpringBootApplication
@SpringBootTest(classes = {TestApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestApplication {
}
