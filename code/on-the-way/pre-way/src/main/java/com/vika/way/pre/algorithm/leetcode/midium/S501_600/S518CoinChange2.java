package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.Arrays;

public class S518CoinChange2 {

    //超时
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return change(coins, amount, 0);
    }

    public int change(int[] coins, int remain, int start) {
        if (remain == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = start; i < coins.length && remain >= coins[i]; i++) {
            sum += change(coins, remain - coins[i], i);
        }
        return sum;
    }

    public int change0(int amount, int[] coins) {
        Arrays.sort(coins);
        return change0(coins, amount, 0, new Integer[coins.length + 1][amount + 1]);
    }

    public int change0(int[] coins, int remain, int start, Integer[][] memo) {
        if (remain == 0) {
            return 1;
        }
        if (memo[start][remain] != null) {
            return memo[start][remain];
        }
        int sum = 0;
        for (int i = start; i < coins.length && remain >= coins[i]; i++) {
            sum += change0(coins, remain - coins[i], i, memo);
        }
        memo[start][remain] = sum;
        return sum;
    }

    public int change1(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    public int change_1(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    public int change_2(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[amount + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (coins[j - 1] <= i) {
                    dp[i][j] += dp[i - coins[j - 1]][j];
                }
            }
        }
        return dp[amount][n];
    }


    public static void main(String[] args) {
        S518CoinChange2 solution = new S518CoinChange2();
        int[] coins = {1, 2, 5};
        System.out.println(solution.change_1(5, coins));
    }
}
