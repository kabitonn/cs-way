package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.Arrays;


public class S016ThreeSumClosest {

	public static void main(String[] args) {
		S016ThreeSumClosest solution = new S016ThreeSumClosest();
		int[] nums = {1,2,4,8,16,32,64,128};
		System.out.println(solution.threeSumClosest2(nums, 82));
	}
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int res = target;
        for(int i=0;i<len-2;i++) {
        	for(int j=i+1;j<len-1;j++) {
        		for(int k=j+1;k<len;k++) {
        			int sum = nums[i]+nums[j]+nums[k];
        			int dif = Math.abs(sum-target);
        			if(dif<min) {
        				min = dif;
        				res = sum;
        			}
        		}
        	}
        }
        return res;
    }
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int res = target;
        for(int i=0;i<len-2;i++) {
        	for(int j=i+1;j<len-1;j++) {
        		int mink = Integer.MAX_VALUE;
        		for(int k=j+1;k<len;k++) {
        			int sum = nums[i]+nums[j]+nums[k];
        			int dif = Math.abs(sum-target);
        			if(dif<min) {
        				min = dif;
        				res = sum;
        			}
        			if(dif<=mink) {
        				mink = dif;
        			}
        			else {
        				break;
        			}
        		}
        	}
        }
        return res;
    }
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int res = target;
        int sum;
        int diff;
    	for(int i=0;i<len-2;i++) {
    		if(i>0&&nums[i]==nums[i-1]) {
    			continue;
    		}
    		int low = i+1;
    		int high = len-1;
    		while(low<high) {
    			sum = nums[low]+nums[high]+nums[i];
    			diff = sum - target;
    			if(Math.abs(diff)<min) {
    				min = Math.abs(diff);
    				res = sum;
    			}
    			if(diff<0) {
    				/*while(low<high&&nums[low]==nums[low+1]) {
    					low++;
    				}*/
    				low++;
    			}
    			else if (diff>0) {
    				/*while(low<high&&nums[high]==nums[high-1]) {
    					high--;
    				}*/
					high--;
				}
    			else {
    				break;
    			}
    			
    		}
    	}
        return res;
    }
}
