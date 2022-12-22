package com.vika.way.pre.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author chenwei.tjw
 * @date 2022/12/13
 **/
public class IteratorSample {

    public static void main(String[] args) {
        List<String> array = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Iterator<String> iterator = array.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            Iterator<String> iterator1 = array.iterator();
            //while (iterator1.hasNext()) {
            //    String s1 = iterator1.next();
            //    iterator1.remove();
            //}
            iterator.remove();
        }
        System.out.println(array);
    }
}
