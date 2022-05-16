package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S306AdditiveNumber {
    public static void main(String[] args) {
        S306AdditiveNumber solution = new S306AdditiveNumber();
        System.out.println(solution.isAdditiveNumber("11111111111011111111111"));
    }

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = i + 1; j + (j - i) <= n; j++) {
                if (isAdditiveNumber(num, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAdditiveNumber(String num, int s1, int s2, int s3) {
        if (s3 == num.length()) {
            return true;
        }
        if ((num.charAt(s1) == '0' && s2 - s1 > 1)) {
            return false;
        }
        if (num.charAt(s2) == '0' && s3 - s2 > 1) {
            return false;
        }
        long num1 = Long.valueOf(num.substring(s1, s2));
        long num2 = Long.valueOf(num.substring(s2, s3));
        String sum = String.valueOf(num1 + num2);
        if (num.indexOf(sum, s3) != s3) {
            return false;
        }
        return isAdditiveNumber(num, s2, s3, s3 + sum.length());
    }

    public boolean isAdditiveNumber1(String num, int s1, int s2, int s3) {
        while (s3 != num.length()) {
            if ((num.charAt(s1) == '0' && s2 - s1 > 1)) {
                return false;
            }
            if (num.charAt(s2) == '0' && s3 - s2 > 1) {
                return false;
            }
            long num1 = Long.valueOf(num.substring(s1, s2));
            long num2 = Long.valueOf(num.substring(s2, s3));
            String sum = String.valueOf(num1 + num2);
            if (num.indexOf(sum, s3) != s3) {
                return false;
            }
            int next = s3 + sum.length();
            s1 = s2;
            s2 = s3;
            s3 = next;
        }
        return true;
    }
}
