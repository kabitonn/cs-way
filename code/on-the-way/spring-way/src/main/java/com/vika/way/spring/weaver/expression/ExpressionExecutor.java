package com.vika.way.spring.weaver.expression;


import com.vika.way.spring.weaver.constans.WeaverExecuteLangEnum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenwei.tjw
 * @date 2022/10/26
 * 表达式执行器
 */
public abstract class ExpressionExecutor<T> {

    private static ConcurrentHashMap<WeaverExecuteLangEnum, ExpressionExecutor> expressionExecutorMap = new ConcurrentHashMap<>();

    static {
        expressionExecutorMap.put(WeaverExecuteLangEnum.SpEL, new SpELExecutor());
        expressionExecutorMap.put(WeaverExecuteLangEnum.QL_EXPRESS, new QLExpressionExecutor());
        expressionExecutorMap.put(WeaverExecuteLangEnum.GROOVY, new GroovyExecutor());
    }

    public static ExpressionExecutor getExpressionExecutor(WeaverExecuteLangEnum executeLangEnum) {
        return expressionExecutorMap.get(executeLangEnum);
    }

    public abstract T eval(String expressionText, Map<String, Object> paramsMap);
}
