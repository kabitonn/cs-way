package com.vika.way.pre.algorithm.leetcode.midium.S201_300;


public class S287FindTheDuplicateNumber {
    public int findDuplicate1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public int findDuplicate2(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
