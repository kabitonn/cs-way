package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class LeftRotateString {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() < 1) {
            return str;
        }
        int len = str.length();
        n %= len;
        if (n == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        int count = 0;
        for (int start = 0; count < len; start++) {
            char prev = chars[start];
            int current = start;
            do {
                current = (current - n + len) % len;
                char temp = chars[current];
                chars[current] = prev;
                prev = temp;
                count++;
            } while (start != current);
        }
        return String.valueOf(chars);
    }

    public String LeftRotateString1(String str, int n) {
        if (str == null || str.length() < 1) {
            return str;
        }
        n %= str.length();
        if (n == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverseChars(chars, 0, n - 1);
        reverseChars(chars, n, str.length() - 1);
        reverseChars(chars, 0, str.length() - 1);
        return String.valueOf(chars);
    }

    public void reverseChars(char[] chars, int l, int r) {
        while (l < r) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }
    }

    public String LeftRotateString2(String str, int n) {
        if (str == null || str.length() < 1) {
            return str;
        }
        n %= str.length();
        return str.substring(n) + str.substring(0, n);
    }
}
