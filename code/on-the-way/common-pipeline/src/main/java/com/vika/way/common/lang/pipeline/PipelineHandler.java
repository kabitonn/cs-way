package com.vika.way.common.lang.pipeline;

/**
 * @author chenwei.tjw
 * @date 2022/11/27
 **/
public interface PipelineHandler<T, R> {

    /**
     * 执行
     *
     * @param context
     * @param result
     */
    default void process(PipelineContext<T> context, PipelineResult<R> result) {
        if (isBreak(context, result) || ignore(context, result)) {
            return;
        }
        preDoHandle(context, result);
        doHandle(context, result);
        postDoHandle(context, result);
    }

    /**
     * 处理方法
     *
     * @param context
     * @param result
     */
    void doHandle(PipelineContext<T> context, PipelineResult<R> result);

    /**
     * 前置处理
     *
     * @param context
     * @param result
     */
    default void preDoHandle(PipelineContext<T> context, PipelineResult<R> result) {
    }

    /**
     * 后置处理
     *
     * @param context
     * @param result
     */
    default void postDoHandle(PipelineContext<T> context, PipelineResult<R> result) {
    }

    /**
     * 是否终止执行
     *
     * @param context
     * @param result
     * @return
     */
    default boolean isBreak(PipelineContext<T> context, PipelineResult<R> result) {
        return false;
    }

    /**
     * 忽略当前
     *
     * @param context
     * @param result
     * @return
     */
    default boolean ignore(PipelineContext<T> context, PipelineResult<R> result) {
        return false;
    }
}
