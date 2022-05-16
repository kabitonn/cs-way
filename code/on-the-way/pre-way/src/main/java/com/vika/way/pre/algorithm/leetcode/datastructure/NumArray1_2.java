package com.vika.way.pre.algorithm.leetcode.datastructure;

public class NumArray1_2 {

    int[] sums;
    int[] nums;
    boolean update;

    public NumArray1_2(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length + 1];
        update = true;
    }

    public void update(int i, int val) {
        nums[i] = val;
        update = true;
    }

    public int sumRange(int i, int j) {
        if (!update) {
            return sums[j + 1] - sums[i];
        }
        sums = new int[nums.length + 1];
        for (int k = 1; k <= nums.length; k++) {
            sums[k] += sums[k - 1] + nums[k - 1];
        }
        update = false;
        return sums[j + 1] - sums[i];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray1_2 array = new NumArray1_2(nums);
        System.out.println(array.sumRange(0, 2));
    }
}
