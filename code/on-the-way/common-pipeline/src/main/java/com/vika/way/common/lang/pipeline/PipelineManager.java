package com.vika.way.common.lang.pipeline;

import lombok.Data;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author chenwei.tjw
 * @date 2022/11/27
 **/
@Data
public class PipelineManager<T, R> {

    private List<? extends PipelineHandler<T, R>> pipelineHandlers;

    public void doPipes(PipelineContext<T> context, PipelineResult<R> result) {
        if (CollectionUtils.isEmpty(pipelineHandlers)) {
            return;
        }
        for (PipelineHandler<T, R> p : pipelineHandlers) {
            if (p == null) {
                continue;
            }
            p.process(context, result);
        }
    }
}
