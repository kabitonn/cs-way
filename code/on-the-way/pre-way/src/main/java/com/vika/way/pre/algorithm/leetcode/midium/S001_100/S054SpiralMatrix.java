package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.ArrayList;
import java.util.List;

public class S054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int i = 0, j = 0, d = 0;
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        for (int k = 0; k < m * n; k++) {
            list.add(matrix[i][j]);
            visited[i][j] = true;
            int iTemp = i + di[d];
            int jTemp = j + dj[d];
            if (0 <= iTemp && iTemp < m && 0 <= jTemp && jTemp < n && !visited[iTemp][jTemp]) {
                i = iTemp;
                j = jTemp;
            } else {
                d = (d + 1) % 4;
                i = i + di[d];
                j = j + dj[d];
            }
        }
        return list;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c < c2; c++) {
                list.add(matrix[r1][c]);
            }
            for (int r = r1; r <= r2; r++) {
                list.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    list.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1; r--) {
                    list.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return list;
    }
}
