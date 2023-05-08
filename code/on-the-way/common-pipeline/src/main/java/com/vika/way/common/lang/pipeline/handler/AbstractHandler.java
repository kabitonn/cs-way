package com.vika.way.common.lang.pipeline.handler;

import com.vika.way.common.lang.pipeline.PipelineHandler;

/**
 * @author chenwei.tjw
 * @date 2022/11/27
 **/
public abstract class AbstractHandler implements PipelineHandler<Void, Void> {

    abstract String getHandlerGroup();

    abstract String getHandlerType();
}
