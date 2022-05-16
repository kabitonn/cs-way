package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

public class S409LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] map = new int[52];
        for (char c : s.toCharArray()) {
            if (c >= 'a') {
                map[c - 'a' + 26]++;
            } else {
                map[c - 'A']++;
            }
        }
        int len = 0;
        for (int n : map) {
            len += n / 2 * 2;
        }
        return len += len < s.length() ? 1 : 0;
    }

}
