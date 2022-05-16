package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

public class S498DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        boolean d = true;//右上
        int m = matrix.length, n = matrix[0].length;
        int[] order = new int[m * n];
        int i = 0, j = 0;
        for (int k = 0; k < m * n; k++) {
            order[k] = matrix[i][j];
            if (d) {
                //右上方向
                if (i - 1 >= 0 && j + 1 < n) {
                    i--;
                    j++;
                } else {
                    d = !d;
                    if (j + 1 < n) {
                        j++;//上方碰壁
                    } else {
                        i++;//右侧碰壁
                    }
                }
            } else {
                //左下方向
                if (i + 1 < m && j - 1 >= 0) {
                    i++;
                    j--;
                } else {
                    d = !d;
                    if (i + 1 < m) {
                        i++;//左侧碰壁
                    } else {
                        j++;//下方碰壁
                    }
                }
            }
        }
        return order;
    }

    public int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int[] order = new int[m * n];
        int i = 0, j = 0, k = 0;
        while (k < m * n) {
            while (i >= 0 && j < n) {
                order[k++] = matrix[i--][j++];
            }
            if (j < n) {
                i = 0;//上方碰壁
            } else {
                i += 2;//右侧碰壁
                j = n - 1;
            }
            while (i < m && j >= 0) {
                order[k++] = matrix[i++][j--];
            }
            if (i < m) {
                j = 0;//左侧碰壁
            } else {
                j += 2;//下方碰壁
                i = m - 1;
            }
        }
        return order;
    }

    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int[] order = new int[m * n];
        int lines = m + n + 2;
        int i = 0, j = 0, k = 0;
        for (int line = 0; line < lines; line++) {
            if (line % 2 == 0) {
                i = i < m ? i : m - 1;
                j = line - i;
                while (i >= 0 && j < n) {
                    order[k++] = matrix[i--][j++];
                }
            } else {
                j = j < n ? j : n - 1;
                i = line - j;
                while (i < m && j >= 0) {
                    order[k++] = matrix[i++][j--];
                }
            }
        }
        return order;
    }
}
