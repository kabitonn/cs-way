package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

import java.util.Arrays;

public class S581ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] array = Arrays.copyOf(nums, n);
        Arrays.sort(array);
        int left = 0, right = n - 1;
        while (left <= right && nums[left] == array[left]) {
            left++;
        }
        while (left <= right && nums[right] == array[right]) {
            right--;
        }
        return right - left + 1;
    }

    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int left = n - 1, right = 0;
        int max = nums[0], min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            } else {
                min = nums[i];
            }
        }
        return left > right ? 0 : right - left + 1;
    }
}
