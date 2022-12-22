package com.vika.way.spring.weaver.expression;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

/**
 * @author chenwei.tjw
 * @date 2022/10/27
 **/
@Configuration
@ComponentScan
public class BeanReferencesTest {

    @Component("myBean")
    static class MyBean {

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanReferencesTest.class);
        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new BeanFactoryResolver(applicationContext));

        MyBean myBean = parser.parseExpression("@myBean").getValue(context, MyBean.class);
        System.out.println(myBean);
        System.out.println(myBean == applicationContext.getBean("myBean"));
    }

}
