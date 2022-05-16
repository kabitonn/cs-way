package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S169MajorityElement {

	public static void main(String[] args) {

	}
    public int majorityElement(int[] nums) {
    	Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public int majorityElement2(int[] nums) {
    	int candidate=nums[0],count=1,i=1;
        for(;i<nums.length;i++)
        {
            if(candidate==nums[i]) {
                count++;
            } else if(--count==0) {
                candidate=nums[i+1];
            }
        }   
        return candidate;
	}
	public int majorityElement3(int[] nums) {
		Integer candidate=null;
		int count=0;
		for(int n:nums){
			if(count==0){
				candidate = n;
			}
			count += n==candidate?1:-1;
		}
		return candidate;
	}
    public int majorityElement1(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int n :nums) {
    		int frequence = map.getOrDefault(n, 0);
    		map.put(n, frequence+1);
    		if(map.get(n)>nums.length/2) {
    			return n;
    		}
    	}
    	return -1;
    	/*int max = Integer.MIN_VALUE;
    	int majority = 0;
    	for(Integer n:map.keySet()) {
    		if (map.get(n)>max) {
    			max = map.get(n);
    			majority = n;
    		}
    	}
        return majority;*/
    }
}