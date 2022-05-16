package com.vika.way.pre.algorithm.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public int[][] getSpiralMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        int count = 1;
        int t = 0, b = m - 1;
        int l = 0, r = n - 1;
        while (count <= m * n) {
            for (int j = l; j <= r; j++) {
                matrix[t][j] = count++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                matrix[i][r] = count++;
            }
            r--;
            for (int j = r; j >= l; j--) {
                matrix[b][j] = count++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                matrix[i][l] = count++;
            }
            l++;
        }
        return matrix;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int t = 0, b = m - 1;
        int l = 0, r = n - 1;
        while (list.size() < m * n) {
            for (int j = l; j <= r; j++) {
                list.add(matrix[t][j]);
            }
            t++;
            for (int i = t; i <= b; i++) {
                list.add(matrix[i][r]);
            }
            r--;
            for (int j = r; j >= l; j--) {
                list.add(matrix[b][j]);
            }
            b--;
            for (int i = b; i >= t; i--) {
                list.add(matrix[i][l]);
            }
            l++;
        }
        return list;
    }

    public void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        int[][] matrix = getSpiralMatrix(4, 4);
        printMatrix(matrix);
    }
}
