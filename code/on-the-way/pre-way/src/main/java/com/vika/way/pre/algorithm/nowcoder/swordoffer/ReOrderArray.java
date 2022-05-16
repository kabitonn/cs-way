package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class ReOrderArray {

    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int n = array.length;
        int[] evenArray = new int[n];
        int odd = 0, even = 0;
        for (int i = 0; i < n; i++) {
            if ((array[i] & 1) == 0) {
                evenArray[even++] = array[i];
            } else {
                array[odd++] = array[i];
            }
        }
        for (int i = 0; i < even; i++) {
            array[odd + i] = evenArray[i];
        }
    }

}
