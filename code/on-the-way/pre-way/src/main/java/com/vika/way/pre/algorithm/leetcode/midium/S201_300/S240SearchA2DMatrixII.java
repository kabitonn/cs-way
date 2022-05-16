package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

public class S240SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return searchMatrix(matrix, target, 0, 0);
    }

    public boolean searchMatrix(int[][] matrix, int target, int i, int j) {
        if (i == matrix.length || j == matrix[0].length) {
            return false;
        }
        if (matrix[i][j] > target) {
            return false;
        }
        if (matrix[i][j] == target) {
            return true;
        }
        return searchMatrix(matrix, target, i + 1, j) || searchMatrix(matrix, target, i, j + 1);
    }

    public boolean searchMatrix0(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 选左上角，往右走和往下走都增大，不能选
     * 选右下角，往上走和往左走都减小，不能选
     * 选左下角，往右走增大，往上走减小，可选
     * 选右上角，往下走增大，往左走减小，可选
     */

    public boolean searchMatrix0_1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] < target) {
                    break;
                }
            }
        }
        return false;
    }


    public boolean searchMatrix1_1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public boolean searchMatrix1_2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }


}
