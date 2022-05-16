package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 */
public class AppearOnceChar {

    Map<Character, Integer> map = new HashMap<>();
    int index = 0;

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, -1);
        } else {
            map.put(ch, index++);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char first = '#';
        int firstIndex = index;
        for (char ch : map.keySet()) {
            int pos = map.get(ch);
            if (pos != -1 && pos < firstIndex) {
                firstIndex = pos;
                first = ch;
            }
        }
        return first;
    }
}
