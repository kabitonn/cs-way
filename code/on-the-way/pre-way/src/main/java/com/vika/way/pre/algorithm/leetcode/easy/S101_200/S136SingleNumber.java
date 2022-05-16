package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S136SingleNumber {

	public static void main(String[] args) {

	}
    public int singleNumber(int[] nums) {
    	Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
        	if(i+1<nums.length&&nums[i]==nums[i+1]) {
        		while(i+1<nums.length&&nums[i]==nums[i+1]) {i++;}
        	}
        	else {
				return nums[i];
			}
        }
        return 0;
    }
    public int singleNumber1(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int n:nums) {
    		Integer count = map.get(n);
    		count = count==null?1:count+1;
    		map.put(n, count);
    	}
    	for(Integer n:map.keySet()) {
    		if(map.get(n)==1) {
    			return n;
    		}
    	}
    	return 0;
    }
    public int singleNumber2(int[] nums) {
    	int xor = 0;
    	for(int n:nums) {
    		xor ^=  n;
    	}
    	return xor;
    }
}
