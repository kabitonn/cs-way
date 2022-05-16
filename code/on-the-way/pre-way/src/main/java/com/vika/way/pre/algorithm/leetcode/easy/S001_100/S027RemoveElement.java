package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S027RemoveElement {

	public static void main(String[] args) {

	}
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]!=val) {
        		nums[len++] = nums[i];
        	}
        }
        return len;
    }
    public int removeElement1(int[] nums, int val) {
        int len = nums.length;
        int i=0;
        while(i<len) {
        	if(nums[i]==val) {
        		nums[i] = nums[--len];
        	}
        	else {
        		i++;
        	}
        }
        return len;
    }
}
