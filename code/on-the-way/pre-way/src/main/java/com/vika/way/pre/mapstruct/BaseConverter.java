package com.vika.way.pre.mapstruct;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.deploy.util.StringUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.mapstruct.Named;

import java.util.*;

/**
 * @author chenwei.tjw
 * @date 2023/1/3
 **/
public interface BaseConverter {


    /**
     * json转Map
     *
     * @param json
     * @return
     */
    @Named("json2Map")
    default Map<String, String> json2Map(String json) {
        return Optional.ofNullable(json)
                .map(p -> JSON.parseObject(p, new TypeReference<Map<String, String>>() {
                }))
                .orElseGet(Maps::newHashMap);
    }

    /**
     * 对象转换成JSON
     *
     * @param obj
     * @return
     */
    @Named("toJson")
    default String toJson(Object obj) {
        return JSON.toJSONString(Objects.isNull(obj) ? Maps.newHashMap() : obj);
    }


    /**
     * json转List
     *
     * @param json json
     * @return {@link List}<{@link String}>
     */
    @Named("json2List")
    default List<String> json2List(String json) {
        return Optional.ofNullable(json)
                .map(p -> JSON.parseObject(p, new TypeReference<List<String>>() {
                }))
                .orElseGet(Lists::newArrayList);
    }

    /**
     * list转换成JSON
     *
     * @param obj obj
     * @return {@link String}
     */
    @Named("list2Json")
    default String list2Json(Object obj) {
        return JSON.toJSONString(Objects.isNull(obj) ? Collections.emptyList() : obj);
    }


    @Named("str2List")
    default List<String> str2List(String arr) {
        String[] strings = arr.split(",");
        return Arrays.asList(strings);
    }

    /**
     * list 转 string
     *
     * @param list
     * @return
     */
    @Named("list2String")
    default String list2String(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return "";
        }
        return StringUtils.join(list, ",");
    }
}
