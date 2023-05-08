package com.vika.way.spring.utils;


import com.alibaba.fastjson.JSONPath;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author chenwei.tjw
 * @date 2023/4/25
 **/
public class JsonUtilsTest {

    @Test
    public void testIsJSONArray() {

    }

    @Test
    public void testJSONPathOperator() throws IOException {
        Map map = FileReadUtils.readObject("provision/provisionMap.json", Map.class);
        // 根节点
        Object result = JSONPath.eval(map, "$");
        System.out.println(result);
        // 过滤器 @ 当前节点
        // 过滤器 ?() 表达式
        // .子节点
        result = JSONPath.eval(map, "saleRebateProvision[?(@.provisionCode=='6500016')]");
        System.out.println(result);

        // ..递归搜索
        result = JSONPath.eval(map, "saleRebateProvision[?(@.brandId=='232268298')]");
        System.out.println(result);

        // 所有节点
        result = JSONPath.eval(map, "saleRebateProvision[*]");
        System.out.println(result);

        // 迭代器下标
        result = JSONPath.eval(map, "saleRebateProvision[1,3]");
        System.out.println(result);

        // 数组片段[start,end]
        result = JSONPath.eval(map, "saleRebateProvision[1:3]");
        System.out.println(result);

        // 数组片段[start,end)
        result = JSONPath.eval(map, "saleRebateProvision[1:3)");
        System.out.println(result);


    }


    @Test
    public void testJSONPathFunction() throws IOException {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 10);

        Object result = JSONPath.eval(list, "$");
        System.out.println(result);
        // 数组最小值
        result = JSONPath.eval(list, "$.min()");
        System.out.println(result);

        // 数组最大值
        result = JSONPath.eval(list, "$.max()");
        System.out.println(result);

        // 数组长度
        result = JSONPath.eval(list, "$.length()");
        System.out.println(result);

    }

    @Test
    public void testJSONPathFilter() throws IOException {
        Map map = FileReadUtils.readObject("provision/provisionMap.json", Map.class);

        Object result = JSONPath.eval(map, "$");
        System.out.println(result);

        // in
        result = JSONPath.eval(map, "$.saleRebateProvision[?(@.hasCondition in ('Y'))]");
        System.out.println(result);

        // nin
        result = JSONPath.eval(map, "$.saleRebateProvision[?(@.hasCondition nin ('Y'))]");
        System.out.println(result);

        result = JSONPath.eval(map, "$.saleRebateProvision[?(@.hasCondition nin ('Y'))][?(@.provisionCode in ('6500014'))].brandCategory");
        System.out.println(result);

        result = JSONPath.eval(map, "$.saleRebateProvision[?(@.hasCondition nin ('Y'))].size()");
        System.out.println(result);

    }
}

