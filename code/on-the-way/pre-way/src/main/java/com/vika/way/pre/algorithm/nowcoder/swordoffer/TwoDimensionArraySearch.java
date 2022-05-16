package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class TwoDimensionArraySearch {

    public boolean find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int m = array.length;
        int n = array[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (array[i][j] < target) {
                j++;
            } else if (array[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
