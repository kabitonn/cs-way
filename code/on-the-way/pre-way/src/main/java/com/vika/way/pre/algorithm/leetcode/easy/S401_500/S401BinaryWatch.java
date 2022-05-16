package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import java.util.*;

public class S401BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + countOne(j) == num) {
                    String str = i + ":" + (j < 10 ? "0" + j : j);
                    list.add(str);
                }
            }
        }
        return list;
    }

    public int countOne(int n) {
        int count = 0;
        while (n != 0) {
            n = n & n - 1;
            count++;
        }
        return count;
    }

    public List<String> readBinaryWatch1(int num) {
        Map<Integer, List<Integer>> hourMap = bitMap(12);
        Map<Integer, List<Integer>> minuteMap = bitMap(60);
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            if (!hourMap.containsKey(i) || !minuteMap.containsKey(num - i)) {
                continue;
            }
            for (int hour : hourMap.get(i)) {
                for (int minute : minuteMap.get(num - i)) {
                    list.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return list;
    }

    public Map<Integer, List<Integer>> bitMap(int num) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            int count = Integer.bitCount(i);
            if (!map.containsKey(count)) {
                map.put(count, new ArrayList<>());
            }
            map.get(count).add(i);
        }
        return map;
    }

    int[] value = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch2(int num) {
        int[] pos = new int[value.length];
        List<String> list = new ArrayList<>();
        backtrack(num, pos, 0, list);
        Collections.sort(list);
        return list;
    }

    public void backtrack(int num, int[] pos, int index, List<String> list) {
        if (num == 0) {
            int hour = 0, minute = 0;
            for (int i = 0; i < 4; i++) {
                hour += value[i] * pos[i];
            }
            if (hour >= 12) {
                return;
            }
            for (int i = 4; i < 10; i++) {
                minute += value[i] * pos[i];
            }
            if (minute >= 60) {
                return;
            }
            list.add(String.format("%d:%02d", hour, minute));
            return;
        }
        for (int i = index; i <= pos.length - num; i++) {
            pos[i]++;
            backtrack(num - 1, pos, i + 1, list);
            pos[i]--;
        }
    }
}
