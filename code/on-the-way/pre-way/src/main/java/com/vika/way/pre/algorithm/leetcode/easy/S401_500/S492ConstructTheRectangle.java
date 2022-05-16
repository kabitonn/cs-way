package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

public class S492ConstructTheRectangle {

    public int[] constructRectangle(int area) {
        if (area <= 0) {
            return new int[0];
        }
        int r = (int) Math.sqrt(area);
        while (r * (area / r) != area) {
            r--;
        }
        return new int[]{area / r, r};
    }
}
