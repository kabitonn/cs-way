package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S018FourSum {

	public static void main(String[] args) {
		S018FourSum solution = new S018FourSum();
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		System.out.println(solution.fourSum(nums, target));
	}
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> tuples = new ArrayList<>();
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length-3;i++) {
    		if(i>0&&nums[i]==nums[i-1]) {
    			continue;
    		}
    		for(int j=nums.length-1;j>=3;j--) {
    			if(j<nums.length-1&&nums[j]==nums[j+1]) {
        			continue;
        		}
    			int low = i+1;
    			int high = j-1;
    			while(low<high) {
    				int sum = nums[i]+nums[j]+nums[low]+nums[high];
    				if(sum==target) {
    					List<Integer> tuple = Arrays.asList(nums[i],nums[low],nums[high],nums[j]);
    					tuples.add(tuple);
    					while(low<high&&nums[low]==nums[low+1]) {
    						low++;
    					}
    					while(low<high&&nums[high]==nums[high-1]) {
    						high--;
    					}
    					low++;
    					high--;
    				}
    				else if (sum<target) {
						low++;
					}
    				else if (sum>target) {
						high--;
					}
    			}
    		}
    	}
    	return tuples;
    }
}
