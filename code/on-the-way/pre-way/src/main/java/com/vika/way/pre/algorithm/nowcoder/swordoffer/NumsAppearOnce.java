package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class NumsAppearOnce {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int xor = 0;
        for (int n : array) {
            xor ^= n;
        }
        int mask = xor;
        mask &= (-mask);
        for (int n : array) {
            if ((n & mask) != 0) {
                num1[0] ^= n;
            } else {
                num2[0] ^= n;
            }
        }
    }
}
