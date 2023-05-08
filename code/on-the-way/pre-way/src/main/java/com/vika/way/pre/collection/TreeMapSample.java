package com.vika.way.pre.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ：chenwei.tjw
 * @date ：2020/8/1 3:54 下午
 */
public class TreeMapSample {

    @Test
    public void testDupKey() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("", "1");
        treeMap.put("", "2");
        System.out.println(treeMap);
    }

    @Test
    public void testHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("", "1");
        map.put("", "2");
        map.putAll(Collections.EMPTY_MAP);
    }
}
