package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.LinkedList;
import java.util.Queue;

public class S322CoinChange {
    public static void main(String[] args) {
        S322CoinChange solution = new S322CoinChange();
        int[] coins = {2};
        System.out.println(solution.coinChange(coins, 3));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = coinChange(coins, amount - coin);
            if (count != -1) {
                min = Math.min(min, count);
            }
        }
        return min != Integer.MAX_VALUE ? min + 1 : -1;
    }


    public int coinChange0(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        memo[0] = 0;
        coinChange0(coins, amount, memo);
        return memo[amount] != Integer.MAX_VALUE ? memo[amount] : -1;
    }

    public int coinChange0(int[] coins, int amount, Integer[] memo) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != null) {
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            min = Math.min(min, coinChange0(coins, amount - coin, memo));
        }
        memo[amount] = min != Integer.MAX_VALUE ? min + 1 : min;
        return memo[amount];
    }


    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                min = Math.min(dp[i - coin], min);
            }
            dp[i] = min != Integer.MAX_VALUE ? min + 1 : min;
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public int coinChange2(int[] coins, int amount) {
        Queue<Integer> leftQueue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];
        leftQueue.add(amount);
        visited[amount] = true;
        int count = 0;
        while (!leftQueue.isEmpty()) {
            int size = leftQueue.size();
            for (int i = 0; i < size; i++) {
                int left = leftQueue.poll();
                if (left == 0) {
                    return count;
                }
                for (int coin : coins) {
                    int tmp = left - coin;
                    if (tmp >= 0 && !visited[tmp]) {
                        leftQueue.add(tmp);
                        visited[tmp] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }

}
