package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

public class S189RotateArray {

	public static void main(String[] args) {

	}
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k%=len;
        if(len == 0||k==0) {return;}
    	for(int i=0;i<k;i++) {
        	int tmp = nums[len-1];
        	for(int j=len-1;j>0;j--) {
        		nums[j] = nums[j-1];
        	}
        	nums[0] = tmp;
        }
    }
    public void rotate1(int[] nums, int k) {
    	int len = nums.length;
        k%=len;
        if(len == 0||k==0) {return;}
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }
    public void reverse(int[] nums, int i,int j) {
    	while(i<j) {
    		int tmp = nums[i];
    		nums[i] = nums[j];
    		nums[j] = tmp;
    		i++;
    		j--;
    	}
    }
	public void rotate2(int[] nums,int k) {
		int len = nums.length;
        k%=len;
        if(len == 0||k==0) {return;}
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                current = (current + k) % nums.length;
                int temp = nums[current];
                nums[current] = prev;
                prev = temp;
                count++;
            } while (start != current);
        }
	}
	public void swap(int[] nums,int i,int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
