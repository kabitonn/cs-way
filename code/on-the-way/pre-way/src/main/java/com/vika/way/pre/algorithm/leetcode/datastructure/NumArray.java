package com.vika.way.pre.algorithm.leetcode.datastructure;

/**
 * 303. 区域和检索 - 数组不可变
 * @author tokabi
 * @date 2019/10/25 17:03
 */
public class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        this.sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

    /*public int sumRange(int i, int j) {
    	int sum = 0;
        for(;i<=j&&i<elementData.length;i++) {
        	sum+=elementData[i];
        }
        return sum;
    }*/
}
