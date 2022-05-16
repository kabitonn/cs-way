package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

public class S566ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return nums;
        }
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] matrix = new int[r][c];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[k / c][k % c] = nums[i][j];
                k++;
            }
        }
        return matrix;
    }

    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return nums;
        }
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] matrix = new int[r][c];
        int row = 0;
        int col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[row][col++] = nums[i][j];
                if (col == c) {
                    row++;
                    col = 0;
                }
            }
        }
        return matrix;
    }
}
