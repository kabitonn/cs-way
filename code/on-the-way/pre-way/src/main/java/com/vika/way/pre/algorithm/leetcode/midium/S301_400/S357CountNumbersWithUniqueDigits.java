package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S357CountNumbersWithUniqueDigits {


    public int countNumbersWithUniqueDigits(int n) {
        int sum = 0;
        for (int i = 0; i <= 2 && i <= n; i++) {
            int s = 1;
            for (int j = 0; j < i; j++) {
                s *= 9;
            }
            sum += s;
        }
        for (int i = 3; i <= n; i++) {
            int s = 9 * 9;
            for (int j = 2; j < i; j++) {
                s *= 9 - (i - j);
            }
            sum += s;
        }
        return sum;
    }

    public int countNumbersWithUniqueDigits1(int n) {
        n = Math.min(n, 10);
        int[] dp = new int[n != 0 ? n + 1 : 2];
        dp[0] = 1;
        dp[1] = 10;
        int mul = 9;
        for (int i = 2; i <= n; i++) {
            mul *= (10 - i + 1);
            dp[i] = dp[i - 1] + mul;
        }
        return dp[n];
    }

    public int countNumbersWithUniqueDigits2(int n) {
        n = Math.min(n, 10);
        int[] counts = {9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int count = 1;
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= counts[i];
            count += product;
        }
        return count;
    }
}
