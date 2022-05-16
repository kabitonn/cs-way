package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S309BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int sold = 0;
        int rest = 0;
        for (int price : prices) {
            int preSold = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, preSold);
        }
        return Math.max(sold, rest);
    }

    public int maxProfit0(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][1] = -prices[i];
            } else if (i == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
        }
        return dp[n - 1][0];
    }

    /**
     * @param prices
     * @return int
     * @date 2019/10/28 9:46
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
     */
    public int maxProfit1(int[] prices) {
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        // dp[i-2][0];
        int dpPre = 0;
        for (int price : prices) {
            int temp = dp0;
            dp0 = Math.max(dp1 + price, dp0);
            dp1 = Math.max(dpPre - price, dp1);
            dpPre = temp;
        }
        return dp0;
    }
}
