package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.Arrays;

public class S062UniquePaths {
    public int uniquePaths0(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int steps = m + n - 2;
        int minStep = Math.min(m, n) - 1;
        long paths = 1;
        for (int i = 1; i <= minStep; i++) {
            paths = paths * (steps - i + 1) / i;
        }
        return (int) paths;
    }

    public int uniquePaths(int m, int n) {
        return uniquePaths(m, n, new int[m + 1][n + 1]);
    }

    public int uniquePaths(int m, int n, int[][] path) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (m == 1 || n == 1) {
            return 1;
        }
        if (path[m][n] > 0) {
            return path[m][n];
        }
        path[m][n] = uniquePaths(m - 1, n, path) + uniquePaths(m, n - 1, path);
        return path[m][n];
    }

    public int uniquePaths1(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] paths = new int[n];
        Arrays.fill(paths, 1);
        //从上向下更新所有行
        for (int i = 1; i < m; i++) {
            //从左向右更新所有列
            for (int j = 1; j < n; j++) {
                //path[j]为上,path[j-1]为左
                paths[j] = paths[j] + paths[j - 1];
            }
        }
        return paths[n - 1];
    }

    public int uniquePaths3(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] paths = new int[m];
        Arrays.fill(paths, 1);
        //从右向左更新所有列
        for (int j = n - 2; j >= 0; j--) {
            //从下向上更新所有行
            for (int i = m - 2; i >= 0; i--) {
                //path[i]为右,path[i+1]为下
                paths[i] = paths[i] + paths[i + 1];
            }
        }
        return paths[0];
    }
}
