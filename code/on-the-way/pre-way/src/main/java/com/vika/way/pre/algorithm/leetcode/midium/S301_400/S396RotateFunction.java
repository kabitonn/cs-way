package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S396RotateFunction {

    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int f = 0;
            for (int j = 0; j < n; j++) {
                f += j * A[(j + i) % n];
            }
            max = Math.max(max, f);
        }
        return max;
    }

    public int maxRotateFunction1(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int f = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            f += i * A[i];
            sum += A[i];
        }
        int max = f;
        //数组循环右移1次，
        for (int i = 1; i < n; i++) {
            f = f + sum - (n) * A[n - i];
            max = Math.max(max, f);
        }
        return max;
    }
}
