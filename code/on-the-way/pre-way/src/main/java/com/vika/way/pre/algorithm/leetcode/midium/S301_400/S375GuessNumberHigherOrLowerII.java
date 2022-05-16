package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S375GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        return cost(1, n, new Integer[n + 1][n + 1]);
    }

    public int cost(int i, int j, Integer[][] memo) {
        if (i >= j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = (i + j) >>> 1; k < j; k++) {
            int max = k + Math.max(cost(i, k - 1, memo), cost(k + 1, j, memo));
            min = Math.min(min, max);
        }
        memo[i][j] = min;
        return memo[i][j];
    }

    public int getMoneyAmount1(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < i + len - 1; k++) {
                    int max = k + Math.max(dp[i][k - 1], dp[k + 1][i + len - 1]);
                    min = Math.min(min, max);
                }
                dp[i][i + len - 1] = min;
            }
        }
        return dp[1][n];
    }

    public int getMoneyAmount2(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int min = Integer.MAX_VALUE;
                for (int k = i + ((len - 1) >>> 1); k < i + len - 1; k++) {
                    int max = k + Math.max(dp[i][k - 1], dp[k + 1][i + len - 1]);
                    min = Math.min(min, max);
                }
                dp[i][i + len - 1] = min;
            }
        }
        return dp[1][n];
    }
}
