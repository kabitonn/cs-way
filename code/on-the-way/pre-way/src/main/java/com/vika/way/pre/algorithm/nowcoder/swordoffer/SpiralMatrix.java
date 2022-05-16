package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.ArrayList;

public class SpiralMatrix {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int t = 0, b = matrix.length - 1;
        int l = 0, r = matrix[0].length - 1;
        while (t <= b && l <= r) {
            for (int j = l; j < r; j++) {
                list.add(matrix[t][j]);
            }
            for (int i = t; i <= b; i++) {
                list.add(matrix[i][r]);
            }
            if (t < b && l < r) {
                for (int j = r - 1; j > l; j--) {
                    list.add(matrix[b][j]);
                }
                for (int i = b; i > t; i--) {
                    list.add(matrix[i][l]);
                }
            }
            t++;
            b--;
            l++;
            r--;
        }
        return list;
    }
}
