package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class InversePairs {

    private final int mod = (int) 1e9 + 7;

    public int inversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = mergeSort(array, 0, array.length - 1);
        return count;
    }

    public int mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) >>> 1;
        int leftCount = mergeSort(array, left, mid);
        int rightCount = mergeSort(array, mid + 1, right);
        int mergeCount = merge(array, left, mid, right);
        return (leftCount + rightCount + mergeCount) % mod;
    }

    public int merge(int[] array, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int[] copy = new int[right - left + 1];
        int k = 0;
        int count = 0;
        while (i <= mid && j <= right) {
            if (array[i] > array[j]) {
                copy[k++] = array[j++];
                count += (mid - i + 1);
                count %= mod;
            } else {
                copy[k++] = array[i++];
            }
        }
        for (; i <= mid; i++) {
            copy[k++] = array[i];
        }
        for (; j <= right; j++) {
            copy[k++] = array[j];
        }
        for (k = 0; k < copy.length; k++) {
            array[left + k] = copy[k];
        }
        return count;
    }

}
