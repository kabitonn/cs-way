package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import org.junit.Test;

public class ReverseSentence {

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String[] strs = str.split("\\s+");
        if (strs.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = ReverseSentence1(" ");
        System.out.println(s);
    }

    public String ReverseSentence1(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        reverseChars(chars, 0, len - 1);
        int l = 0, r = 0;
        while (l < len) {
            if (chars[r] == ' ') {
                reverseChars(chars, l, r - 1);
                l = r + 1;
                r = l;
            }
            if (r == len - 1) {
                reverseChars(chars, l, r);
                break;
            }
            r++;
        }
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
}
