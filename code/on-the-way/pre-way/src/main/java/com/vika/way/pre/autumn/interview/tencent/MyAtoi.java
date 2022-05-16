package com.vika.way.pre.autumn.interview.tencent;

/**
 * @Author tangjiawei
 * @Date 2020/8/29
 */
public class MyAtoi {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int start = 0;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        boolean minus = false;
        if (str.charAt(start) == '-') {
            minus = true;
            start++;
        } else if (str.charAt(start) == '+') {
            minus = false;
            start++;
        } else if (!(str.charAt(start) >= '0' && str.charAt(start) <= '9')) {
            return 0;
        }
        int i = start;
        int num = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (minus) {
                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && str.charAt(i) >= '8')) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && str.charAt(i) >= '7')) {
                    return Integer.MAX_VALUE;
                }
            }
            num = num * 10 + str.charAt(i++) - '0';
        }
        if (minus) {
            num = -num;
        }
        return num;
    }
}
