package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import java.util.Arrays;

public class S414ThirdMaxNumber {

	public static void main(String[] args) {
		int[] nums = new int[] {2,2,3,1};
		S414ThirdMaxNumber solution = new S414ThirdMaxNumber();
		System.out.println(solution.thirdMax3(nums));
	}
	public int thirdMax(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		int count = 1;
		int third = nums[len-1];
		for(int i=len-2;i>=0&&count<3;i--) {
			if(nums[i]==nums[i+1]) {
				continue;
			}
			count++;
			third = nums[i];
		}
		if(count==3) {return third;}
		else {return nums[len-1];}
	}
	public int thirdMax1(int[] nums) {
		int count = 0;
		int maxFirst = Integer.MIN_VALUE;
		int maxSecond = Integer.MIN_VALUE;
		int maxThird = Integer.MIN_VALUE;
		boolean minExsit = false;
		for(int n:nums) {
			if(n==Integer.MIN_VALUE&&!minExsit) {
				count++;
				minExsit = true;
			}
			if(n>maxFirst) {
				maxThird = maxSecond;
				maxSecond = maxFirst;
				maxFirst = n;
				count++;
			}
			else if (n>maxSecond&&n!=maxFirst) {
				maxThird = maxSecond;
				maxSecond = n;
				count++;
			}
			else if (n>maxThird&&n!=maxSecond&&n!=maxFirst) {
				maxThird = n;
				count++;
			}
		}
		if(count>=3) {return maxThird;}
		else {		return maxFirst;}
	}
	public int thirdMax2(int[] nums) {
		long maxFirst=Long.MIN_VALUE,maxSecond=Long.MIN_VALUE,maxThird=Long.MIN_VALUE;
		for(long num:nums){
			if(num>maxFirst){
				maxThird=maxSecond;
				maxSecond=maxFirst;
				maxFirst=num;
			}else if(num>maxSecond&&num<maxFirst){
				maxThird=maxSecond;
				maxSecond=num;
			}else if(num>maxThird&&num<maxSecond){
				maxThird=num;
			}
		}
		return (maxThird==Long.MIN_VALUE||maxThird==maxSecond)?(int)maxFirst:(int)maxThird;
	}
	public int thirdMax3(int[] nums) {
		Integer maxFirst = null;
		Integer maxSecond = null;
		Integer maxThird = null;
		for(int num:nums){
			if(maxFirst==null||num>maxFirst){
				maxThird=maxSecond;
				maxSecond=maxFirst;
				maxFirst=num;
			}else if(num<maxFirst&&(maxSecond==null||num>maxSecond)){
				maxThird=maxSecond;
				maxSecond=num;
			}else if(num<maxFirst&&num<maxSecond&&(maxThird==null||num>maxThird)){
				maxThird=num;
			}
		}
		return (maxThird==null)?maxFirst:maxThird;
	}
}
