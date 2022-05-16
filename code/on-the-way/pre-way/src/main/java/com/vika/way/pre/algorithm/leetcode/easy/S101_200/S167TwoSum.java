package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

public class S167TwoSum {

	public static void main(String[] args) {

	}
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0;i<numbers.length-1;i++) {
        	for(int j=i+1;j<numbers.length;j++) {
        		int sum = numbers[i]+numbers[j];
        		if(sum==target) {
        			return new int[] {i+1,j+1};
        		}
        		else if (sum>target) {
					break;
				}
        	}
        }
        return new int[]{};
    }
    public int[] twoSum1(int[] numbers, int target) {
    	int i = 0;
    	int j = numbers.length-1;
    	while(i<j) {
    		int sum = numbers[i]+numbers[j];
    		if(sum==target) {
    			return new int[] {i+1,j+1};
    		}
    		else if (sum>target) {
				j--;
			}
    		else if (sum<target) {
				i++;
			}
    	}
    	return new int[]{};
    }

}
