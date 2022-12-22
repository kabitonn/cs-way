package com.vika.way.spring.weaver.expression;

import lombok.extern.slf4j.Slf4j;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Map;

/**
 * Groovy脚本执行器
 * Groovy脚本，语法：http://groovy-lang.org/documentation.html#languagespecification
 *
 * @param <T>
 */
@Slf4j
public class GroovyExecutor<T> extends ExpressionExecutor {

    /**
     * Groovy Script Engine
     */
    private static ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("groovy");

    @Override
    public T eval(String expressionText, Map paramsMap) {
        Bindings bindings = scriptEngine.createBindings();
        if (paramsMap != null) {
            //bindings.put(WeaverCommonConstant.BUILT_IN_EXPRESSION_MAIN_MODEL, paramsMap);
            bindings.putAll(paramsMap);
        }
        try {
            return (T) scriptEngine.eval(expressionText, bindings);
        } catch (Throwable e) {
            // 记录出错的表达式具体信息
            log.error("Throwable! expressionText={};variables={} ", expressionText, paramsMap);
            throw new ExpressionExecutionException(e, expressionText, paramsMap);
        }
    }
}
