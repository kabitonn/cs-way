package com.vika.way.spring.weaver.executor;

/**
 * 执行单元
 *
 * @param <Meta> 出参元数据
 */
public interface ExecutableUnit<Meta> {

    /**
     * 执行入口
     *
     * @param executionContext
     * @return
     */
    Meta execute(ExecutionContext executionContext);
}
