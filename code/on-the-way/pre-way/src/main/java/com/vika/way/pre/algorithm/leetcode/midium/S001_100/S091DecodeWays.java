package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S091DecodeWays {
    public static void main(String[] args) {
        S091DecodeWays solution = new S091DecodeWays();
        System.out.println(solution.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
    }

    private char[] code = new char[26];

    public int numDecodings(String s) {
        Set<String> set = new HashSet<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            code[c - 'A'] = c;
        }
        numDecoding(s, 0, set, "");
        return set.size();
    }

    private void numDecoding(String s, int index, Set<String> set, String decode) {
        if (index >= s.length()) {
            set.add(decode);
            return;
        }
        int n1 = Integer.valueOf(s.substring(index, index + 1));
        if (n1 == 0) {
            return;
        }
        numDecoding(s, index + 1, set, decode + code[n1 - 1]);
        if (index + 2 > s.length()) {
            return;
        }
        int n2 = Integer.valueOf(s.substring(index, index + 2));
        if (n2 <= 26) {
            return;
        }
        numDecoding(s, index + 2, set, decode + code[n2 - 1]);
    }

    public int numDecodings1(String s) {
        return numDecoding(s, 0);
    }

    private int numDecoding(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        int sum1 = numDecoding(s, index + 1);
        int sum2 = 0;
        if (index < s.length() - 1) {
            int n2 = (s.charAt(index) - '0') * 10 + s.charAt(index + 1) - '0';
            if (n2 <= 26) {
                sum2 = numDecoding(s, index + 2);
            }
        }
        return sum1 + sum2;
    }

    public int numDecodings1_1(String s) {
        Map<Integer, Integer> memoization = new HashMap<>();
        return numDecodings1_1(s, 0, memoization);
    }

    private int numDecodings1_1(String s, int index, Map<Integer, Integer> memoization) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        //判断之前是否计算过
        int m = memoization.getOrDefault(index, -1);
        if (m != -1) {
            return m;
        }
        int sum1 = numDecodings1_1(s, index + 1, memoization);
        int sum2 = 0;
        if (index < s.length() - 1) {
            int n2 = (s.charAt(index) - '0') * 10 + s.charAt(index + 1) - '0';
            if (n2 <= 26) {
                sum2 = numDecodings1_1(s, index + 2, memoization);
            }
        }
        //将结果保存
        memoization.put(index, sum1 + sum2);
        return sum1 + sum2;
    }

    public int numDecodings2(String s) {
        int len = s.length();
        int[] numDecoding = new int[len + 1];
        numDecoding[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                numDecoding[i] = 0;
                continue;
            }
            if (i == len - 1) {
                numDecoding[i] = 1;
            } else {
                int n = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';
                if (n <= 26) {
                    numDecoding[i] += numDecoding[i + 2];
                }
                numDecoding[i] += numDecoding[i + 1];
            }
        }
        return numDecoding[0];
    }

    public int numDecodings3(String s) {
        int len = s.length();
        int last = 1, cur = 0;
        if (s.charAt(len - 1) != '0') {
            cur = 1;
        } else {
            cur = 0;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                last = cur;
                cur = 0;
                continue;
            }
            int n = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';
            int tmp = cur;
            if (n <= 26) {
                cur += last;
            }
            last = tmp;
        }
        return cur;
    }
}
