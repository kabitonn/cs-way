package com.vika.way.pre.algorithm.leetcode.easy.S1001_2000;

public class S1160FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        int[] map = new int[26];
        for (char c : chars.toCharArray()) {
            map[c - 'a']++;
        }
        int lenSum = 0;
        for (String word : words) {
            int[] cost = new int[26];
            for (char c : word.toCharArray()) {
                cost[c - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (map[i] < cost[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                lenSum += word.length();
            }
        }
        return lenSum;
    }

    public int countCharacters1(String[] words, String chars) {
        int[] map = new int[26];
        for (char c : chars.toCharArray()) {
            map[c - 'a']++;
        }
        int lenSum = 0;
        for (String word : words) {
            boolean flag = true;
            int[] cost = new int[26];
            for (char c : word.toCharArray()) {
                cost[c - 'a']++;
                if (cost[c - 'a'] > map[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                lenSum += word.length();
            }
        }
        return lenSum;
    }

}
