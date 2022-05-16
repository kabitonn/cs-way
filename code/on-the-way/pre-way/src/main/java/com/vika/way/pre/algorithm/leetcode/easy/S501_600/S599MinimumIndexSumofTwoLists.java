package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S599MinimumIndexSumofTwoLists {
    //超时
    public String[] findRestaurant(String[] list1, String[] list2) {
        int m = list1.length, n = list2.length;
        List<String> list = new ArrayList<>();
        for (int k = 0; k < m + n; k++) {
            for (int i = 0; i < k && i < m; i++) {
                for (int j = 0; i + j < k && j < n; j++) {
                    if (list1[i].equals(list2[j])) {
                        list.add(list1[i]);
                    }
                }
            }
            if (list.size() != 0) {
                break;
            }
        }
        return list.toArray(new String[0]);
    }

    public String[] findRestaurant1(String[] list1, String[] list2) {
        int m = list1.length, n = list2.length;
        List<String> list = new ArrayList<>();
        int min = m + n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n && i + j <= min; j++) {
                if (list1[i].equals(list2[j])) {
                    if (i + j < min) {
                        list = new ArrayList<>();
                        min = i + j;
                    }
                    list.add(list1[i]);
                }
            }
        }
        return list.toArray(new String[0]);
    }

    public String[] findRestaurant2(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        int m = list1.length, n = list2.length;
        List<String> list = new ArrayList<>();
        int min = m + n;
        for (int i = 0; i < m; i++) {
            map.put(list1[i], i);
        }
        for (int j = 0; j < n && j <= min; j++) {
            if (map.containsKey(list2[j])) {
                int i = map.get(list2[j]);
                if (i + j == min) {
                    list.add(list1[i]);
                }
                if (i + j < min) {
                    list = new ArrayList<>();
                    min = i + j;
                    list.add(list1[i]);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
