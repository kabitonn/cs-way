package com.vika.way.spring.weaver.expression;

import lombok.Data;

/**
 * 表达式执行异常
 */
@Data
public class ExpressionExecutionException extends RuntimeException {
    /**
     * 执行的具体表达式
     */
    private String expression;

    /**
     * 执行表达式时的上下文
     */
    private Object context;

    /**
     * 不允许无参构造
     */
    private ExpressionExecutionException(){}

    /**
     * 强制传入cause，防止误用构造器丢失stackTrace信息
     * @param cause
     * @param expression
     * @param context
     */
    public ExpressionExecutionException(Throwable cause, String expression, Object context) {
        super(cause);
        this.expression = expression;
        this.context = context;
    }

}
