package com.vika.way.spring.weaver.expression;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelNode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SpEL执行器
 * SpEL语法：https://docs.spring.io/spring-framework/docs/4.3.25.RELEASE/spring-framework-reference/html/expressions.html
 *
 * @param <T>
 */
@Slf4j
public class SpELExecutor<T> extends ExpressionExecutor {
    /**
     * IMMEDIATE模型提升性能，但必须处理编译后类型变化后的异常
     */
    public static SpelParserConfiguration SPEL_CONFIG = new SpelParserConfiguration(SpelCompilerMode.OFF,
            SpELExecutor.class.getClassLoader(), true, true, Integer.MAX_VALUE);


    /**
     * Expression缓存器，提升性能
     */
    private static Map<String, SpelExpression> cacheExpression = new ConcurrentHashMap<>(10000);

    /**
     * 获取SpelNode
     *
     * @param expression
     * @return
     */
    public static SpelNode getSpELNode(String expression) {
        if (cacheExpression.containsKey(expression)) {
            return cacheExpression.get(expression).getAST();
        } else {
            SpelExpression spelExpression = compileExpression(expression);
            if (null == spelExpression) {
                return null;
            }
            return spelExpression.getAST();
        }
    }

    /**
     * 加锁初始化解析结果
     *
     * @param expressionText
     * @return
     */
    private synchronized static SpelExpression initSpelNode(String expressionText) {
        if (cacheExpression.containsKey(expressionText)) {
            return cacheExpression.get(expressionText);
        }
        SpelExpressionParser parser = new SpelExpressionParser(SPEL_CONFIG);
        SpelExpression exp = (SpelExpression) parser.parseExpression(expressionText);

        cacheExpression.put(expressionText, exp);
        return exp;

    }

    /**
     * 表达式预解析，用于预热提升性能
     * 特别注意***：如果表达式本身类型改动，需要修改表达式本身使同一表达式类型保持不变；否则频繁在编译影响性能
     *
     * @param expressionText
     * @return
     */
    public static SpelExpression compileExpression(String expressionText) {
        if (StringUtils.isNotBlank(expressionText)) {
            SpelExpression spelExpression = cacheExpression.get(expressionText);
            if (null == spelExpression) {
                return initSpelNode(expressionText);
            }

            return spelExpression;
        }
        return null;
    }

    @Override
    public Object eval(String expressionText, Map paramsMap) {
        return eval(expressionText, paramsMap, null);
    }

    public Object eval(String expressionText, Map paramsMap, StandardEvaluationContext evaluationContext) {
        if (null == evaluationContext) {
            // for security
            //SimpleEvaluationContext evaluationContext =SimpleEvaluationContext.forPropertyAccessors().build();
            evaluationContext = new StandardEvaluationContext();
            initFunction(evaluationContext);
        }
        // 初始化上下文
        evaluationContext.setVariables(paramsMap);

        if (StringUtils.isNotBlank(expressionText)) {

            // 返回最后一次执行结果
            Object result = null;

            try {
                // 多行表达式分开调用
                /**
                 * 使用IMMEDIATE模型已编译过的表达式，如果表达式类型发生变化，此时会抛EvaluationException
                 * 系统需要再次解析和编译
                 */
                try {
                    SpelExpression spelExpression = cacheExpression.get(expressionText);
                    if (null == spelExpression) {
                        spelExpression = compileExpression(expressionText);
                    }
                    result = (T) spelExpression.getValue(evaluationContext);
                } catch (EvaluationException e) {
                    log.error("EvaluationException! Throwable e. expressionText =" + expressionText + "variables="
                            + paramsMap, e);
                    SpelExpression spelExpression = compileExpression(expressionText);
                    result = (T) spelExpression.getValue(evaluationContext);
                }
            } catch (Throwable e) {
                // 记录出错的表达式具体信息
                log.error("Throwable! expressionText={};variables={} ", expressionText, paramsMap);
                throw new ExpressionExecutionException(e, expressionText, paramsMap);
            }
            return result;
        }
        return null;
    }

    /**
     * EvaluationContext初始化内置方法
     *
     * @param context
     */
    private void initFunction(StandardEvaluationContext context) {
        try {
            context.registerFunction("add", SpELExecutor.class.getMethod("add", List.class));
        } catch (NoSuchMethodException e) {
            log.error("SpELExecutorImpl add function failed! e = {} ", e);
        }
    }

    public static BigDecimal add(List<BigDecimal> a) {
        return a.stream().filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

