package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class CountOfK {

    public int GetNumberOfK(int[] array, int k) {
        int count = 0;
        for (int n : array) {
            count += n == k ? 1 : 0;
        }
        return count;
    }

    public int GetNumberOfK1(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = getMin(array, k);
        int right = getMax(array, k);
        if (left == -1) {
            return 0;
        }
        return right - left + 1;
    }

    public int getMin(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (arr[left] != k) {
            return -1;
        }
        return left;
    }

    public int getMax(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (arr[mid] > k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (arr[left] != k) {
            return -1;
        }
        return left;
    }
}
