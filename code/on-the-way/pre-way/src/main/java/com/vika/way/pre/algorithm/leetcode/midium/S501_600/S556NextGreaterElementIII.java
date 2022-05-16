package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

public class S556NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        String str = n + "";
        char[] chars = str.toCharArray();
        int len = chars.length;
        int i = len - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = i + 1;
        while (j < len && chars[j] > chars[i]) {
            j++;
        }
        j--;
        swap(chars, i, j);
        reverse(chars, i + 1);
        return valueOf(chars);
    }

    public int valueOf(char[] chars) {
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (num >= Integer.MAX_VALUE / 10) {
                return -1;
            }
            num = num * 10 + chars[i] - '0';
        }
        return num;
    }

    public void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public void reverse(char[] chars, int i) {
        int j = chars.length - 1;
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    public static void main(String[] args) {
        S556NextGreaterElementIII solution = new S556NextGreaterElementIII();
        System.out.println(solution.nextGreaterElement(1999999999));
    }
}
