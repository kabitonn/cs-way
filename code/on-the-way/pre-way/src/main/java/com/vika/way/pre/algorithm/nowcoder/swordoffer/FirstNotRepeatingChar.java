package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        int firstIndex = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            int first = str.indexOf(c);
            int last = str.lastIndexOf(c);
            if (first == -1 || first != last) {
                continue;
            }
            if (firstIndex == -1 || first < firstIndex) {
                firstIndex = first;
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            int first = str.indexOf(c);
            int last = str.lastIndexOf(c);
            if (first == -1 || first != last) {
                continue;
            }
            if (firstIndex == -1 || first < firstIndex) {
                firstIndex = first;
            }
        }
        return firstIndex;
    }

    public int FirstNotRepeatingChar1(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            } else {
                map.put(c, -1);
            }
        }
        int first = -1;
        for (char c : map.keySet()) {
            if (map.get(c) != -1) {
                if (first == -1 || first > map.get(c)) {
                    first = map.get(c);
                }
            }
        }
        return first;
    }
}
