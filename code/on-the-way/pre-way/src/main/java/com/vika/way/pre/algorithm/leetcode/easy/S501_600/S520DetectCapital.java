package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

public class S520DetectCapital {

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() < 2) {
            return true;
        }
        boolean first = isUpperCase(word.charAt(0));
        boolean prev = isUpperCase(word.charAt(1));
        if (!first && prev) {
            return false;
        }
        for (int i = 2; i < word.length(); i++) {
            if (isUpperCase(word.charAt(i)) != prev) {
                return false;
            }
        }
        return true;
    }

    public boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
