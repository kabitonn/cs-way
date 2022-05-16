package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

import java.util.*;

public class S187RepeatedDNASequences {

    public static void main(String[] args) {
        S187RepeatedDNASequences solution = new S187RepeatedDNASequences();
        System.out.println(solution.findRepeatedDnaSequences1("AAAAAAAAAAA"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                continue;
            }
            boolean repeat = false;
            for (int j = i + 1; j <= s.length() - 10; j++) {
                if (sub.equals(s.substring(j, j + 10))) {
                    repeat = true;
                    break;
                }
            }
            if (repeat && !set.contains(sub)) {
                list.add(sub);
                set.add(sub);
            }
        }
        return list;
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!map.containsKey(sub)) {
                map.put(sub, false);
            } else if (map.containsKey(sub) && !map.get(sub)) {
                map.put(sub, true);
                list.add(sub);
            }
        }
        return list;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (set1.contains(sub)) {
                set2.add(sub);
            } else {
                set1.add(sub);
            }
        }
        return new ArrayList<>(set2);
    }

    //位运算 数组标记
    public List<String> findRepeatedDnaSequences3(String s) {
        List<String> list = new ArrayList<>();
        int[] nums = new int[1 << 20];
        int mask = (1 << 18) - 1;
        int key = 0;
        for (int i = 0; i < s.length(); i++) {
            key <<= 2;
            key += getValue(s.charAt(i));
            if (i >= 9) {
                if (nums[key] == 1) {
                    list.add(s.substring(i - 9, i + 1));
                }
                nums[key]++;
                key &= mask;
            }
        }
        return list;
    }

    private int getValue(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                throw new IllegalArgumentException("Illegal character");
        }
    }
}
