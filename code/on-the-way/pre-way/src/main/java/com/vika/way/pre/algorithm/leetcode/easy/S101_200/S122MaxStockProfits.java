package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

public class S122MaxStockProfits {

    public static void main(String[] args) {
        S122MaxStockProfits solution = new S122MaxStockProfits();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit1(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int len = prices.length;
        int i = 0;
        while (i < len - 1) {
            while (i < len - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int valley = prices[i];
            while (i < len - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            int peak = prices[i++];
            maxProfit += (peak - valley);
        }

        return maxProfit;
    }
}
