package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

public class S151ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "  hello world!  ";
        S151ReverseWordsInAString solution = new S151ReverseWordsInAString();
        System.out.println(solution.reverseWords(s));
    }

    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        int i = 0, j = strs.length - 1;
        for (; i < j; i++, j--) {
            String tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < strs.length; k++) {
            sb.append(strs[k]);
            if (k != strs.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverseWords1(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int k = strs.length - 1; k >= 0; k--) {
            if (k == strs.length - 1) {
                sb.append(strs[k]);
            } else {
                sb.append(" " + strs[k]);
            }
        }
        return sb.toString();
    }
}
