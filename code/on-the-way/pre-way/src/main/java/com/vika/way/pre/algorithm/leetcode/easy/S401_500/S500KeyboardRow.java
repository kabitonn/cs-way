package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import java.util.ArrayList;
import java.util.List;

public class S500KeyboardRow {

    char[][] chars = {
        {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'},
        {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'},
        {'Z', 'X', 'C', 'V', 'B', 'N', 'M'}};

    public String[] findWords(String[] words) {
        int[] map = new int[26];
        for (int i = 0; i < 3; i++) {
            for (char ch : chars[i]) {
                map[ch - 'A'] = i;
            }
        }
        List<String> list = new ArrayList<>();
        for (String word : words) {
            boolean flag = true;
            char[] chs = word.toUpperCase().toCharArray();
            for (int i = 1; i < chs.length; i++) {
                if (map[chs[i] - 'A'] != map[chs[0] - 'A']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }
}
