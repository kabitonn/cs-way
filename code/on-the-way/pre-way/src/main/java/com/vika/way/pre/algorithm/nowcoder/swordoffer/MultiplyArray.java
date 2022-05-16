package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.Arrays;

public class MultiplyArray {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }
        int n = A.length;
        int[] B = new int[n];
        Arrays.fill(B, 1);
        int left = 1, right = 1;
        for (int i = 0; i < n; i++) {
            B[i] *= left;
            left *= A[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            B[i] *= right;
            right *= A[i];
        }
        return B;
    }

    public int[] multiply1(int[] A) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }
        int n = A.length;
        int[] B = new int[n];
        Arrays.fill(B, 1);
        int left = 1, right = 1;
        for (int i = 0; i < n; i++) {
            B[i] *= left;
            left *= A[i];
            B[n - i - 1] *= right;
            right *= A[n - i - 1];
        }
        return B;
    }
}
