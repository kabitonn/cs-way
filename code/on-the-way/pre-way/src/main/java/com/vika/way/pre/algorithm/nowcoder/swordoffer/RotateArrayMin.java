package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class RotateArrayMin {

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length;
        int left = 0;
        for (; left < n - 1; left++) {
            if (array[left] > array[left + 1]) {
                return array[left + 1];
            }
        }
        return array[left];
    }

    public int minNumberInRotateArray1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[left];
    }
}
