package com.vika.way.pre.autumn.interview.tencent;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author tangjiawei
 * @Date 2020/8/29
 */
public class MaxNumber {

    public String largestNumber(int[] nums) {

        List<String> list = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();

    }

    @Test
    public void test() {
        int[] nums = {3, 30, 34, 5, 9};
        String s = largestNumber(nums);
        System.out.println(s);
    }

}
