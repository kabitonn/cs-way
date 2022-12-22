package com.vika.way.spring.weaver.executor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 执行节点上下文
 */

public class ExecutionContext {

    /**
     * 运行期变量
     */
    private Map<String, Object> runtimeVariables = new ConcurrentHashMap<>();

    public ExecutionContext() {
    }

    public ExecutionContext(ConcurrentHashMap<String, Object> runtimeVariables) {
        this.runtimeVariables.putAll(runtimeVariables);
    }

    public void setVariable(String name, Object value) {
        this.runtimeVariables.put(name, value);
    }

    public void setVariables(Map<String,Object> variables) {
        this.runtimeVariables.putAll(variables);
    }

    public Object getVariable(String name) {
        return this.runtimeVariables.get(name);
    }

    public Map<String,Object> getVariables() {
        return this.runtimeVariables;
    }
}
