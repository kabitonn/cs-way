package com.vika.way.pre.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：chenwei.tjw
 * @date ：2020/7/9 9:12 下午
 */
public class ListSample {
    @Test
    public void testListSubList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> subList = list.subList(0, 0);
        subList.add(1);
        System.out.println(list);
    }

    @Test
    public void testNullList() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1));
        System.out.println(list);
    }
}
