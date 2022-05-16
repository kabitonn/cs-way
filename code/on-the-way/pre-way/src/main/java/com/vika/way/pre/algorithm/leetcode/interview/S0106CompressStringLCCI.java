package com.vika.way.pre.algorithm.leetcode.interview;

import org.junit.Test;

public class S0106CompressStringLCCI {

    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len=S.length();
        for (; i < len; ) {
            char c = S.charAt(i);
            sb.append(c);
            int j = i + 1;
            for (; j < len && S.charAt(j) == c; j++) {
            }
            sb.append(j - i);
            i = j;
        }
        if (sb.length() >= len) {
            return S;
        } else {
            return sb.toString();
        }
    }

    @Test
    public void test(){
        String s= compressString("aabcccccaa");
        System.out.println(s);
    }
}
