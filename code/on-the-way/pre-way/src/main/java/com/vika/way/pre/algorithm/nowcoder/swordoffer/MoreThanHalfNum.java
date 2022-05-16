package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.Arrays;

public class MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        int n = array.length;
        int mid = n / 2;
        int left = mid, right = mid;
        for (; left >= 0 && array[left] == array[mid]; left--) {
        }
        left++;
        for (; right < n && array[right] == array[mid]; right++) {
        }
        right--;
        int num = right - left + 1;
        if (num > n / 2) {
            return array[mid];
        } else {
            return 0;
        }
    }

    public int MoreThanHalfNum_Solution1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Integer candidate = null;
        int count = 0;
        for (int num : array) {
            if (candidate == null || count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : array) {
            if (num == candidate) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return candidate;
        }
        return 0;
    }
}
