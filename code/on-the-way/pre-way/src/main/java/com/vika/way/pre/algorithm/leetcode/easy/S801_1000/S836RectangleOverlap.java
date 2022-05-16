package com.vika.way.pre.algorithm.leetcode.easy.S801_1000;

public class S836RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] >= rec2[2] || rec1[2] <= rec2[0]) {
            return false;
        }
        if (rec1[1] >= rec2[3] || rec1[3] <= rec2[1]) {
            return false;
        }
        return true;
    }
}
