package com.vika.way.spring.weaver.mapping;

import com.vika.way.spring.weaver.executor.ExecutionContext;
import lombok.Data;

/**
 * 模型映射
 */
@Data
public abstract class ModelMapping<S, T> {

    /**
     * 映射来源数据
     */
    protected S sourceObject;

    /**
     * 映射目标数据
     */
    protected T targetObject;

    public Boolean execute(ExecutionContext executionContext) {
        return mapping(sourceObject, targetObject, executionContext);
    }

    /**
     * 执行模型映射
     * @param sourceObject 数据来源对象
     * @param targetObject 目标填充对象
     * @return 返回数据映射后的来源对象
     */
    abstract Boolean mapping(S sourceObject, T targetObject, ExecutionContext executionContext);

}
