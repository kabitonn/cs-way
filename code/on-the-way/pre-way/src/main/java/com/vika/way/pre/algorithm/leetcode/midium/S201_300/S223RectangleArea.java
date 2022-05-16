package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

public class S223RectangleArea {
    public static void main(String[] args) {

    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long left = Math.max(A, E);
        long right = Math.min(C, G);
        long up = Math.min(D, H);
        long down = Math.max(B, F);
        return (C - A) * (D - B) + (G - E) * (H - F) - (int) Math.max(right - left, 0) * (int) Math.max(up - down, 0);
    }

    public int computeArea1(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaSum = (C - A) * (D - B) + (G - E) * (H - F);
        if (C < E || A > G) {
            return areaSum;
        }
        if (D < F || B > H) {
            return areaSum;
        }
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int up = Math.min(D, H);
        int down = Math.max(B, F);
        return areaSum - (right - left) * (up - down);
    }

}
