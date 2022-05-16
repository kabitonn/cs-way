package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.*;

public class S015ThreeSum {

	public static void main(String[] args) {
		S015ThreeSum solution = new S015ThreeSum();
		//int[] nums= {-1, 0, 1, 2, -1, -4};
		int[] nums= {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(solution.threeSum2(nums));

	}
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> tuples = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int len = nums.length;
        if(len<3) {
            return tuples;
        }
        for(int i=0;i<len-2;i++) {
        	for(int j=i+1;j<len-1;j++) {
        		for(int k=j+1;k<len;k++) {
        			if(nums[i]+nums[j]+nums[k]==0) {
        				List<Integer> tuple = new ArrayList<>();
        				tuple.add(nums[i]);
        				tuple.add(nums[j]);
        				tuple.add(nums[k]);
        				set.add(tuple);
        			}
        		}
        	}
        }
        for (List<Integer> list : set) {
			tuples.add(list);
		}
        return tuples;
    }
    public List<List<Integer>> threeSum1(int[] nums) {
    	List<List<Integer>> tuples = new ArrayList<>();
    	Set<List<Integer>> set = new HashSet<>();
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length-2;i++) {
    		if(i>0&&nums[i]==nums[i-1]) {
    			continue;
    		}
    		int low = i+1;
    		int high = nums.length-1;
    		while(low<high) {
    			int sum = nums[low]+nums[high];
    			if(sum==-nums[i]) {
    				List<Integer> tuple = Arrays.asList(nums[i],nums[low],nums[high]);
    				set.add(tuple);
    				low++;
    				high--;
    			}
    			else if (sum>-nums[i]) {
					high--;
				}
    			else if (sum<-nums[i]) {
    				low++;
				}
    		}
    	}
    	for (List<Integer> list : set) {
			tuples.add(list);
		}
    	return tuples;
    }
    public List<List<Integer>> threeSum2(int[] nums) {
    	List<List<Integer>> tuples = new ArrayList<>();
    	Arrays.sort(nums);
    	int len = nums.length;
    	for(int i=0;i<len-2;i++) {
    		//为了保证不加入重复的 list,因为是有序的，所以如果和前一个元素相同，只需要继续后移就可以
    		if(i>0&&nums[i]==nums[i-1]) {
    			continue;
    		}
    		//两个指针,并且头指针从i + 1开始，防止加入重复的元素
    		int low = i+1;
    		int high = len-1;
    		while(low<high) {
    			int sum = nums[low]+nums[high];
    			if(sum==-nums[i]) {
    				List<Integer> tuple = Arrays.asList(nums[i],nums[low],nums[high]);
    				tuples.add(tuple);
    				//元素相同要后移，防止加入重复的 list
    				while(low<high&&nums[low]==nums[low+1]) {
    					low++;
    				}
    				while(low<high&&nums[high]==nums[high-1]) {
    					high--;
    				}
    				low++;
    				high--;
    			}
    			else if (sum>-nums[i]) {
					high--;
				}
    			else if (sum<-nums[i]) {
    				low++;
				}
    		}
    	}
    	return tuples;
    }
}
