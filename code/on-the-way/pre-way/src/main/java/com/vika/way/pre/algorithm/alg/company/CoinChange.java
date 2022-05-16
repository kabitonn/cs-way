package com.vika.way.pre.algorithm.alg.company;

import java.util.Scanner;

public class CoinChange {

    private final int T = 1024;

    private int[] coin = {64, 16, 4, 1};

    public int minCoinChange(int n) {
        int sum = T - n;
        int count = 0;
        for (int i = 0; i < coin.length; i++) {
            while (sum >= coin[i]) {
                sum -= coin[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.minCoinChange(200));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(coinChange.minCoinChange(n));
    }
}
