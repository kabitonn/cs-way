package com.vika.way.spring.weaver.expression;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.vika.way.spring.weaver.constans.WeaverExecuteCommonConstant;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * QLExpress执行器
 * QLExpress语法：https://github.com/alibaba/QLExpress#%E4%B8%89%E8%AF%AD%E6%B3%95%E4%BB%8B%E7%BB%8D
 * @param <T>
 */
@Slf4j
public class QLExpressionExecutor<T> extends ExpressionExecutor{

    private static ExpressRunner runner = new ExpressRunner();

    @Override
    public T eval(String expressionText, Map paramsMap) {
        DefaultContext<String, Object> context = new DefaultContext<>();
        if(paramsMap!=null){
            context.put(WeaverExecuteCommonConstant.BUILT_IN_DOLLAR_PREFIX_HASHTAG, paramsMap);
        }

        try {
            return (T) runner.execute(expressionText, context, null, true, false);
        }catch (Throwable e) {
            // 记录出错的表达式具体信息
            log.error("Throwable! expressionText={};variables={} ",expressionText, paramsMap);
            throw new ExpressionExecutionException(e, expressionText, paramsMap);
        }
    }
}
