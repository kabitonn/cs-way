package com.vika.way.pre.algorithm.leetcode.datastructure;

/**
 * 307. 区域和检索 - 数组可修改
 *
 * @author tokabi
 * @date 2019/10/27 20:23
 */

import java.util.Arrays;

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(sumTree);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
public class NumArray1 {
    int[] nums;
    public NumArray1(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
    }

    public void update(int i, int val) {
        nums[i] = val;
    }
    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }
}
