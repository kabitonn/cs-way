package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.Arrays;

public class S576OutofBoundaryPaths {

    final int mod = (int) (Math.pow(10, 9) + 7);
    //超时
    public int findPaths(int m, int n, int N, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        int path = 0;
        path += findPaths(m, n, N - 1, i + 1, j);
        path += findPaths(m, n, N - 1, i - 1, j);
        path += findPaths(m, n, N - 1, i, j + 1);
        path += findPaths(m, n, N - 1, i, j - 1);
        return path % (mod);
    }

    public int findPaths1(int m, int n, int N, int i, int j) {
        return findPaths1(m, n, N, i, j, new Integer[N][m][n]);
    }

    public int findPaths1(int m, int n, int N, int i, int j, Integer[][][] memo) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        if (memo[N - 1][i][j] != null) {
            return memo[N - 1][i][j];
        }
        long path = 0;
        path += findPaths1(m, n, N - 1, i + 1, j, memo);
        path += findPaths1(m, n, N - 1, i - 1, j, memo);
        path += findPaths1(m, n, N - 1, i, j + 1, memo);
        path += findPaths1(m, n, N - 1, i, j - 1, memo);
        memo[N - 1][i][j] = (int) (path % mod);
        return memo[N - 1][i][j];
    }

    public int findPaths2(int m, int n, int N, int i, int j) {
        int[][][] memo = new int[m][n][N];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                Arrays.fill(memo[r][c], -1);
            }
        }
        return findPaths2(m, n, N, i, j, memo);
    }

    public int findPaths2(int m, int n, int N, int i, int j, int[][][] memo) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        if (memo[i][j][N - 1] != -1) {
            return memo[i][j][N - 1];
        }
        long path = 0;
        path += findPaths2(m, n, N - 1, i + 1, j, memo);
        path += findPaths2(m, n, N - 1, i - 1, j, memo);
        path += findPaths2(m, n, N - 1, i, j + 1, memo);
        path += findPaths2(m, n, N - 1, i, j - 1, memo);
        memo[i][j][N - 1] = (int) (path % mod);
        return memo[i][j][N - 1];
    }

    public int findPaths3(int m, int n, int N, int i, int j) {
        if (i - N >= 0 && i + N < m && j - N >= 0 && j + N < n) {
            return 0;
        }
        int[][][] dp = new int[N + 1][m + 2][n + 2];
        for (int k = 0; k <= N; k++) {
            for (int r = 0; r <= m + 1; r++) {
                for (int c = 0; c <= n + 1; c++) {
                    if (r == 0 || c == 0 || r == m + 1 || c == n + 1) {
                        dp[k][r][c] = 1;
                    }
                }
            }
        }
        for (int k = 1; k <= N; k++) {
            for (int r = 1; r <= m; r++) {
                for (int c = 1; c <= n; c++) {
                    dp[k][r][c] = (dp[k][r][c] + dp[k - 1][r - 1][c]) % mod;
                    dp[k][r][c] = (dp[k][r][c] + dp[k - 1][r + 1][c]) % mod;
                    dp[k][r][c] = (dp[k][r][c] + dp[k - 1][r][c - 1]) % mod;
                    dp[k][r][c] = (dp[k][r][c] + dp[k - 1][r][c + 1]) % mod;
                }
            }
        }
        return dp[N][i + 1][j + 1] % mod;
    }

    //空间优化 有待完善
    public int findPaths4(int m, int n, int N, int i, int j) {
        if (i - N >= 0 && i + N < m && j - N >= 0 && j + N < n) {
            return 0;
        }
        int[][][] dp = new int[2][m + 2][n + 2];
        for (int r = 0; r <= m + 1; r++) {
            for (int c = 0; c <= n + 1; c++) {
                if (r == 0 || c == 0 || r == m + 1 || c == n + 1) {
                    dp[0][r][c] = dp[1][r][c] = 1;
                }
            }
        }
        int prev = 0;
        for (int k = 1; k <= N; k++) {
            int cur = prev == 0 ? 1 : 0;
            for (int r = 1; r <= m; r++) {
                for (int c = 1; c <= n; c++) {
                    dp[cur][r][c] = (dp[cur][r][c] + dp[prev][r - 1][c]) % mod;
                    dp[cur][r][c] = (dp[cur][r][c] + dp[prev][r + 1][c]) % mod;
                    dp[cur][r][c] = (dp[cur][r][c] + dp[prev][r][c - 1]) % mod;
                    dp[cur][r][c] = (dp[cur][r][c] + dp[prev][r][c + 1]) % mod;
                }
            }
            prev = cur;
        }
        return dp[prev][i + 1][j + 1] % mod;
    }

    public static void main(String[] args) {
        S576OutofBoundaryPaths solution = new S576OutofBoundaryPaths();
        System.out.println(solution.findPaths4(1, 3, 3, 0, 1));
    }
}
