package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

public class S221MaximalSquare {

    public int maximalSquare0(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int side = 1;
                    boolean flag = true;
                    while (i + side < m && j + side < n) {
                        for (int k = j; k <= j + side && flag; k++) {
                            if (matrix[i + side][k] == '0') {
                                flag = false;
                            }
                        }
                        for (int k = i; k < i + side && flag; k++) {
                            if (matrix[k][j + side] == '0') {
                                flag = false;
                            }
                        }
                        if (flag) {
                            side++;
                        } else {
                            break;
                        }
                    }
                    max = Math.max(side, max);
                }
            }
        }
        return max * max;
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }

    public int maximalSquare1(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n + 1];
        int max = 0;
        int prev;
        for (int i = 1; i <= m; i++) {
            prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j - 1], prev));
                    max = Math.max(dp[j], max);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return max * max;
    }
}
