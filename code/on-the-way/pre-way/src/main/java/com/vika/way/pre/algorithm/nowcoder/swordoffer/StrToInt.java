package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import org.junit.Test;

public class StrToInt {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean isMinus = false;
        int i = 0;
        while (str.charAt(i) == ' ') {
            i++;
        }
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            i++;
            isMinus = true;
        } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {

        } else {
            return 0;
        }
        int num = 0;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                if (isMinus && (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && c > '8'))) {
                    return 0;
                } else if (!isMinus && (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && c >= '8'))) {
                    return 0;
                }
                num = num * 10 + c - '0';
            } else {
                return 0;
            }
        }
        if (isMinus) {
            return -num;
        }
        return num;
    }

    @Test
    public void test() {
        int num = StrToInt1("123");
        System.out.println(num);
    }

    public int StrToInt1(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int flag = 1;
        int i = 0;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            i++;
            flag = -1;
        }
        int num = 0;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                int d = c - '0';
                boolean over = (num * flag - Integer.MAX_VALUE / 10 + ((flag + 1) / 2 + d) > 8 ? 1 : 0) > 0;
                if (over) {
                    return 0;
                }
                num = num * 10 + flag * d;
            } else {
                return 0;
            }
        }
        return num;
    }

}
