package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

public class S121MaxStockProfit {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(price - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int num = prices[i] - prices[i - 1];
            dp = Math.max(dp + num, num);
            max = Math.max(max, dp);
        }
        return max;
    }


}
