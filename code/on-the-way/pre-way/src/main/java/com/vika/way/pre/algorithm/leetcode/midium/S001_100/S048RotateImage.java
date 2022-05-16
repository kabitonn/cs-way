package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S048RotateImage {

    //自外向内顺时针循环
    //自外向内一共有不超过 n/2 层（单个中心元素不算一层）矩形框。对于第 times 层矩形框，其框边长 len=nums-(times*2)，将其顺时针分为 4 份 len-1 的边，对四条边进行元素的循环交换即可。
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        int times = 0;
        while (times < n >> 1) {
            int len = n - times << 1 - 1;
            for (int i = 0; i < len; i++) {
                int temp = matrix[times][times + i];
                matrix[times][times + i] = matrix[n - 1 - (times + i)][times];
                matrix[n - 1 - (times + i)][times] = matrix[n - 1 - times][n - 1 - (times + i)];
                matrix[n - 1 - times][n - 1 - (times + i)] = matrix[times + i][n - 1 - times];
                matrix[times + i][n - 1 - times] = temp;
            }
            times++;
        }
    }

    public void rotate0(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

    //两次翻转
    //先沿右上 - 左下的对角线翻转（270° + 一次镜像），再沿水平中线上下翻转（−180°+ 一次镜像），可以实现顺时针 90 度的旋转效果
    public void rotate1(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }
        for (int i = 0; i < (n >> 1); ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
    }


    //转置加翻转
    //先沿左上 - 右下的对角线翻转，再沿垂直中线上下翻转，可以实现顺时针 90 度的旋转效果
    public void rotate2(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

}
