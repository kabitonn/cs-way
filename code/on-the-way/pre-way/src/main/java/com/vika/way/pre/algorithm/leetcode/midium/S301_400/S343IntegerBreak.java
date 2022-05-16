package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S343IntegerBreak {
    public int integerBreak(int n) {
        int r = n % 3;
        int q = n / 3;
        if (q == 0) {
            return 1;
        } else if (q == 1 && r == 0) {
            return 2;
        }
        if (r == 0) {
            return (int) Math.pow(3, q);
        } else if (r == 1) {
            return (int) Math.pow(3, q - 1) * 4;
        }
        return (int) Math.pow(3, q) * r;
    }

    public int integerBreak1(int n) {
        return integerBreak(n, new int[n + 1]);
    }

    public int integerBreak(int n, int[] memo) {
        if (n <= 2) {
            return 1;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        int product = 0;
        for (int i = 1; i < n; i++) {
            product = Math.max(product, Math.max(i * (n - i), i * integerBreak(n - i, memo)));
        }
        memo[n] = product;
        return product;
    }

    public int integerBreak2(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    //1 * max(dp[i−1],i−1)，2 * max(dp[i - 2], i - 2) 3 * max(dp[i−3],i−3)，大于 3 的加法因子不予考虑。更有甚1的加法因子也无需考虑
    public int integerBreak3(int n) {
        int[] dp = {0, 1, 1};

        for (int i = 3; i < n + 1; i++) {
            dp[i % 3] = Math.max((2 * Math.max(dp[(i - 2) % 3], i - 2)), 3 * Math.max(dp[(i - 3) % 3], i - 3));
        }
        return dp[n % 3];
    }


}
