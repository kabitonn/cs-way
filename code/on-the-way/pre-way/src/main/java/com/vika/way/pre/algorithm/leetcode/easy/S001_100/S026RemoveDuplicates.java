
package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S026RemoveDuplicates {

	public static void main(String[] args) {

	}
    public int removeDuplicates(int[] nums) {
    	if(nums.length==0) {
            return 0;
        }
    	int len = 1;
    	for(int i=1;i<nums.length;i++) {
    		if(nums[i]!=nums[i-1]) {
    			nums[len++] = nums[i];
    		}
    	}
        return len-1;
    }
	public int removeDuplicates1(int[] nums) {
		if(nums.length==0) {
            return 0;
        }
		int len = 0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]!=nums[len]) {
				nums[++len] = nums[i];
			}
		}
		return len+1;
	}
}
