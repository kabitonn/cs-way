package com.vika.way.pre.autumn.exam.pdd;

import org.junit.Test;

import java.util.Scanner;

public class MaxBagProfit {

    public int maxProfit1(int m, int[] c, int[] v) {
        int n = c.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (c[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i - 1]] + v[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] c = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        MaxBagProfit solution = new MaxBagProfit();
        int result = solution.maxProfit(m, c, v);
        //solution.backtrackProfit(m, c, v, 0, 0, 0);
        System.out.println(result);
    }

    public int max = 0;

    public void backtrackProfit(int m, int[] c, int[] v, int i, int used, int profit) {
        if (i >= c.length) {
            if (used <= m) {
                max = Math.max(profit, max);
            }
            return;
        }
        backtrackProfit(m, c, v, i + 1, used + c[i], profit + v[i]);
        backtrackProfit(m, c, v, i + 1, used, profit);
    }

    public int maxProfit(int m, int[] c, int[] v) {
        int bit = 1 << m;
        int max = 0;
        for (int i = 0; i < bit; i++) {
            int p = 0, used = 0;
            int j = 0;
            int b = i;
            while (b != 0) {
                if ((b & 1) == 1) {
                    p += v[j];
                    used += c[j];
                }
                j++;
                b >>= 1;
            }
            if (used <= m) {
                max = Math.max(max, p);
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] c = {1, 1, 1, 6};
        int[] v = {-1, -1, 1, 6};
        int r = maxProfit1(6, c, v);
        System.out.println(r);
    }

}
