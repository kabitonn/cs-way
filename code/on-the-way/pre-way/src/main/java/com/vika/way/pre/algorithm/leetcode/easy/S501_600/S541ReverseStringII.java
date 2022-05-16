package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

public class S541ReverseStringII {

    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i += k * 2) {
            int l = i;
            int r = i + k - 1;
            r = r < n ? r : n - 1;
            char c;
            while (l < r) {
                c = str[l];
                str[l++] = str[r];
                str[r--] = c;
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        S541ReverseStringII solution = new S541ReverseStringII();
        System.out.println(solution.reverseStr("a", 2));
    }
}
