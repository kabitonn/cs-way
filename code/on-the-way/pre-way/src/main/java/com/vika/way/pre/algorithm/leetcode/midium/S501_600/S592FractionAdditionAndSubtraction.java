package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.Arrays;

public class S592FractionAdditionAndSubtraction {

    public String fractionAddition(String expression) {
        int[] frac1 = {0, 1};
        char[] s = (expression).toCharArray();
        int n = s.length;
        int j = 0;
        while (j < n) {
            boolean negative = false;
            if (s[j] == '-') {
                negative = true;
                j++;
            } else if (s[j] == '+') {
                j++;
            }
            int num1 = 0;
            while (s[j] != '/') {
                num1 = num1 * 10 + s[j++] - '0';
            }
            if (negative) {
                num1 = -num1;
            }
            j++;
            int num2 = 0;
            while (j < n && (s[j] != '+' && s[j] != '-')) {
                num2 = num2 * 10 + s[j++] - '0';
            }
            int[] frac2 = {num1, num2};
            frac1 = addition(frac1, frac2);
        }
        return frac1[0] + "/" + frac1[1];
    }

    public int[] addition(int[] frac1, int[] frac2) {
        int n = frac1[1] * frac2[1];
        int m = frac1[0] * frac2[1] + frac2[0] * frac1[1];
        if (m == 0) {
            return new int[]{0, 1};
        }
        int gcd = greatestCommonDivisor(Math.abs(m), n);
        return new int[]{m / gcd, n / gcd};
    }

    public int greatestCommonDivisor(int a, int b) {
        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public int lowestCommonMulti(int a, int b) {
        return a * b / greatestCommonDivisor(a, b);
    }

    public String fractionAddition1(String expression) {
        String[] substrs = expression.split("\\+|-");
        if (substrs[0].length() == 0) {
            substrs = Arrays.copyOfRange(substrs, 1, substrs.length);
        }
        boolean[] sign = new boolean[substrs.length];
        char[] s = expression.toCharArray();
        if (s[0] != '-') {
            sign[0] = true;
        }
        int count = 1;
        for (int i = 1; i < s.length; i++) {
            if (s[i] == '+') {
                sign[count++] = true;
            } else if (s[i] == '-') {
                sign[count++] = false;
            }
        }
        count = 0;
        int[] num = new int[sign.length];
        int[] den = new int[sign.length];
        for (String str : substrs) {
            String[] frac = str.split("/");
            num[count] = Integer.valueOf(frac[0]);
            den[count] = Integer.valueOf(frac[1]);
            count++;
        }
        int n = 1;
        for (int d : den) {
            n = lowestCommonMulti(n, d);
        }
        int m = 0;
        for (int i = 0; i < sign.length; i++) {
            if (sign[i]) {
                m += num[i] * n / den[i];
            } else {
                m -= num[i] * n / den[i];
            }
        }
        int gcd = greatestCommonDivisor(Math.abs(m), n);
        m /= gcd;
        n /= gcd;
        return m + "/" + n;
    }

    public static void main(String[] args) {
        S592FractionAdditionAndSubtraction solution = new S592FractionAdditionAndSubtraction();
        System.out.println(solution.fractionAddition1("-1/2+1/2"));
    }
}
