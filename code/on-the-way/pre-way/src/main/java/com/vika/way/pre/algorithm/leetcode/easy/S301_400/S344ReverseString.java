package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

public class S344ReverseString {

    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            swap(s, i, s.length - 1 - i);
        }
    }

    public void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public void reverseString1(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }

    public void reverseString2(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
            i++;j--;
        }
    }

}
