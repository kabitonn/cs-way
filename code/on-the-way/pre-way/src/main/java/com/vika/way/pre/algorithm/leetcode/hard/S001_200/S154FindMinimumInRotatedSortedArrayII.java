package com.vika.way.pre.algorithm.leetcode.hard.S001_200;

public class S154FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                min = nums[i];
                break;
            }
        }
        return min;
    }

    public int getBiasByMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right]) {
                right = right - 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
