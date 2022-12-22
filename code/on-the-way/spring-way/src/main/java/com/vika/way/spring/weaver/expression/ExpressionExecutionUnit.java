package com.vika.way.spring.weaver.expression;


import com.vika.way.spring.weaver.constans.WeaverExecuteLangEnum;
import com.vika.way.spring.weaver.executor.ExecutableUnit;
import com.vika.way.spring.weaver.executor.ExecutionContext;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 表达式可执行单元
 *
 * @param <T>
 */
@Data
@Slf4j
public class ExpressionExecutionUnit<T> implements ExecutableUnit<Object>, Serializable {
    private static final long serialVersionUID = -6168663160663017251L;

    /**
     * 表达式文本
     */
    private String expressionText;

    /**
     * 表达式语言
     */
    private WeaverExecuteLangEnum executeLangEnum = WeaverExecuteLangEnum.SpEL;

    /**
     * 不允许无参构造
     */
    private ExpressionExecutionUnit() {
    }

    public ExpressionExecutionUnit(String expressionText) {
        this.expressionText = expressionText;
    }

    public ExpressionExecutionUnit(String expressionText, WeaverExecuteLangEnum executeLangEnum) {
        this.expressionText = expressionText;
        this.executeLangEnum = executeLangEnum;
    }

    @Override
    public Object execute(ExecutionContext executionContext) {
        return eval(executionContext);
    }

    private Object eval(ExecutionContext executionContext) {

        return ExpressionExecutor.getExpressionExecutor(executeLangEnum).eval(expressionText, executionContext.getVariables());

    }
}
