package com.vika.way.pre.autumn.interview.tencent;

/**
 * @author ：tangjiawei
 * @date ：2020/9/12 22:35
 */

/**
 * 3.逐行打印n * n回型矩阵（ 不可以在内存填好整个矩阵然后再打印）
 * <p>
 * n=3
 * 1 2 3
 * 8 9 4
 * 7 6 5
 * <p>
 * n=4
 * 1 2 3 4
 * 12 13 14 5
 * 11 16 15 6
 * 10 9 8 7
 */
public class SpiralMatrix {

    public void printSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int l = 0, r = n - 1;
        int t = 0, b = n - 1;
        while (num <= n * n) {
            for (int j = l; j <= r; j++) {
                matrix[t][j] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                matrix[i][r] = num++;
            }
            r--;
            for (int j = r; j >= l; j--) {
                matrix[b][j] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
