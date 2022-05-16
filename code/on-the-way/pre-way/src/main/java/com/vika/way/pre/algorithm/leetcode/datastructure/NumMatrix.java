package com.vika.way.pre.algorithm.leetcode.datastructure;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * @author tokabi
 * @date 2019/10/27 17:43
 */
public class NumMatrix {
    int m, n;
    int[][] sumArray;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        m = matrix.length;
        n = matrix[0].length;
        sumArray = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sumArray[i][j] = sumArray[i][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sumArray[i + 1][col2 + 1] - sumArray[i + 1][col1];
        }
        return sum;
    }
}


