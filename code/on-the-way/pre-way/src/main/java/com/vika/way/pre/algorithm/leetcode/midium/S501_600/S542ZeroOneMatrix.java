package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S542ZeroOneMatrix {

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = m + n;
                }
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }

    public int[][] updateMatrix1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    dp[i][j] = m + n;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            for (int[] d : dir) {
                int i = x + d[0];
                int j = y + d[1];
                if (i < 0 || i >= m || j < 0 || j >= n) {
                    continue;
                }
                if (dp[i][j] > dp[x][y] + 1) {
                    dp[i][j] = dp[x][y] + 1;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        return dp;
    }

    public int[][] updateMatrix2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = m + n;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    dfs2(dp, i, j);
                }
            }
        }
        return dp;
    }

    public void dfs2(int[][] dp, int x, int y) {
        for (int[] d : dir) {
            int i = x + d[0];
            int j = y + d[1];
            if (i < 0 || i >= dp.length || j < 0 || j >= dp[0].length) {
                continue;
            }
            if (dp[i][j] > dp[x][y] + 1) {
                dp[i][j] = dp[x][y] + 1;
                dfs2(dp, i, j);
            }
        }
    }

    public int[][] updateMatrix3(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dfs3(matrix, dp, i, j);
                }
            }
        }
        return dp;
    }

    public int dfs3(int[][] matrix, int[][] dp, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return m + n;
        }
        if (matrix[x][y] == 0) {
            return 0;
        }
        if ((x > 0 && matrix[x - 1][y] == 0) ||
            (y > 0 && matrix[x][y - 1] == 0) ||
            (x < m - 1 && matrix[x + 1][y] == 0) ||
            (y < n - 1 && matrix[x][y + 1] == 0)) {
            dp[x][y] = 1;
            return 1;
        }
        int min = m + n;
        if (x > 0 && dp[x - 1][y] != 0) {
            min = Math.min(min, dp[x - 1][y]);
        }
        if (y > 0 && dp[x][y - 1] != 0) {
            min = Math.min(min, dp[x][y - 1]);
        }
        min = Math.min(min, dfs3(matrix, dp, x + 1, y));
        min = Math.min(min, dfs3(matrix, dp, x, y + 1));
        dp[x][y] = min + 1;
        return dp[x][y];
    }

    public static void main(String[] args) {
        S542ZeroOneMatrix solution = new S542ZeroOneMatrix();
        int[][] matrix = {
            {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
            {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
            {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
            {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        int[][] dp = solution.updateMatrix3(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
