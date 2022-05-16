package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

public class S521LongestUncommonSubsequenceI {

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
