package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberString {
    Pattern pattern = Pattern.compile("^[+|-]?\\d*(\\.\\d+)?([eE][+|-]?\\d+)?$");

    public boolean isNumeric(char[] str) {
        Matcher matcher = pattern.matcher(String.valueOf(str));
        return matcher.matches();
    }

    public boolean isNumeric1(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        boolean sign = false;
        boolean decimal = false;
        boolean hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '-') {
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                } else if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                sign = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1) {
                    return false;
                }
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '.') {
                if (decimal || hasE) {
                    return false;
                }
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
