package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

public class S283MoveZeroes {

	public static void main(String[] args) {

	}
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0) {
				int pos = i;
				for(int j=i+1;j<nums.length;j++) {
					if(nums[j]==0) {continue;}
					swap(nums, pos, j);
					pos = j;
				}
			}
		}
    }
    public void moveZeroes1(int[] nums) {
    	int pos = 0;
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]!=0) {
    			nums[pos++] = nums[i];
    		}
    	}
    	for(int i=pos;i<nums.length;i++) {
    		nums[i] = 0;
    	}
    }
    public void moveZeroes2(int[] nums) {
    	int pos = 0;
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]!=0) {
    			swap(nums, pos++, i);
    		}
    	}
    }
    public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
