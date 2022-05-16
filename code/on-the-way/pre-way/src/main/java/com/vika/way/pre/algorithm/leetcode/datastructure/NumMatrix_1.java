package com.vika.way.pre.algorithm.leetcode.datastructure;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * @author tokabi
 * @date 2019/10/27 20:21
 */
public class NumMatrix_1 {
    int m, n;
    int[][] sumMatrix;

    public NumMatrix_1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        m = matrix.length;
        n = matrix[0].length;
        sumMatrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sumMatrix[i][j] = sumMatrix[i][j - 1] + sumMatrix[i - 1][j] - sumMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row2 + 1][col1] - sumMatrix[row1][col2 + 1] + sumMatrix[row1][col1];
        return sum;
    }
}
