package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

import java.util.Arrays;

public class S268MissingNumber {

	public static void main(String[] args) {

	}
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        for(;i<nums.length;i++) {
        	if(nums[i]!=i) {
        		break;
        	}
        }
        return i;
    }
    public int missingNumber1(int[] nums) {
        int sum = 0;
        for(int n:nums) {
        	sum+=n;
        }
        return (nums.length+1)*nums.length/2-sum;
    }
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
