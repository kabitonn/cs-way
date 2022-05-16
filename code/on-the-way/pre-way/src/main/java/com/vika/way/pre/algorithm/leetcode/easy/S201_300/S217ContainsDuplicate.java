package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class S217ContainsDuplicate {

	public static void main(String[] args) {

	}
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums) {
        	if(set.contains(n)) {return true;}
        	set.add(n);
        }
        return false;
    }
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++) {
        	if(nums[i]==nums[i-1]) {return true;}
        }
        return false;
    }
}
