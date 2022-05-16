package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

public class S557ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
                char c = chars[i];
                chars[i] = chars[j];
                chars[j] = c;
            }
            sb.append(chars);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String reverseWords1(String s) {
        char[] str = s.toCharArray();
        int n = s.length();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && str[j] != ' ') {
                j++;
            }
            for (int l = i, r = j - 1; l < r; l++, r--) {
                char c = str[l];
                str[l] = str[r];
                str[r] = c;
            }
            i = j + 1;
        }
        return new String(str);
    }

    public static void main(String[] args) {
        S557ReverseWordsInAStringIII solution = new S557ReverseWordsInAStringIII();
        System.out.println(solution.reverseWords1("sa sa ds"));
    }
}
