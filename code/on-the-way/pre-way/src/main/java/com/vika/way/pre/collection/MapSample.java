package com.vika.way.pre.collection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author chenwei.tjw
 * @date 2023/3/22
 **/
public class MapSample {

    @Test
    public void testMapSize() throws Exception {
        HashMap map = new HashMap();
        Class<?> mapType = map.getClass();

        Field threshold = mapType.getDeclaredField("threshold");
        threshold.setAccessible(true);

        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);

        System.out.println("capacity:" + capacity.invoke(map) + "threshold:" + threshold.get(map) + "size:" + map.size());
        for (int i = 0; i < 17; i++) {
            map.put(i, i);
            System.out.println("capacity:" + capacity.invoke(map) + "threshold:" + threshold.get(map) + "size:" + map.size());
        }
    }


    @Test
    public void testMapSize0() throws Exception {
        HashMap map = new HashMap(0);
        Class<?> mapType = map.getClass();
        System.out.println(map.getOrDefault("1", 1));

        Field threshold = mapType.getDeclaredField("threshold");
        threshold.setAccessible(true);

        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);

        System.out.println("capacity:" + capacity.invoke(map) + "threshold:" + threshold.get(map) + "size:" + map.size());
        for (int i = 0; i < 17; i++) {
            map.put(i, i);
            System.out.println("capacity:" + capacity.invoke(map) + "threshold:" + threshold.get(map) + "size:" + map.size());
        }
    }
}
