package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.Arrays;

public class NumArray1_1 {

    int[] sums;
    int[] nums;

    public NumArray1_1(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] += sums[i - 1] + nums[i - 1];
        }
    }

    public void update(int i, int val) {
        int diff = nums[i] - val;
        nums[i] = val;
        for (int k = i + 1; k < sums.length; k++) {
            sums[k] -= diff;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
