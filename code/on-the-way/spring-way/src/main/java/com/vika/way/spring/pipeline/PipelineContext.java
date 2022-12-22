package com.vika.way.spring.pipeline;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author chenwei.tjw
 * @date 2022/11/27
 **/
@Data
public class PipelineContext<T> {
    private Map<String, Object> attribute = new HashMap<>();

    private T data;

    /**
     * 上下文中添加数据
     */
    public void set(String key, Object value) {
        attribute.put(key, value);
    }

    /**
     * 获取上下文中的数据
     */
    public Object get(String key) {
        return attribute.get(key);
    }

    /**
     * 删除指定的上下文数据
     */
    public void remove(String key) {
        attribute.remove(key);
    }

    /**
     * 获取所有的key集合
     */
    public Set<String> keySet() {
        return attribute.keySet();
    }

    /**
     * 清理数据
     */
    public void clear() {
        attribute.clear();
    }
}
