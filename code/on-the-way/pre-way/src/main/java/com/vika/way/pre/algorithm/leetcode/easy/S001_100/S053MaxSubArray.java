package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S053MaxSubArray {

	public static void main(String[] args) {

	}
	public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] maxSums = new int[len];
        maxSums[0] = nums[0];
        int maxSum = maxSums[0];
        for(int i=1;i<len;i++) {
        	if(maxSums[i-1]<0) {
        		maxSums[i] = nums[i];
        	}else {
				maxSums[i] = maxSums[i-1] + nums[i];
			}
        	if(maxSums[i]>maxSum) {	maxSum = maxSums[i];}
        }
        return maxSum;
    }
	public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int maxSumTail = 0;
        for(int i=0;i<len;i++) {
        	if(maxSumTail<0) {
        		maxSumTail = nums[i];
        	}else {
        		maxSumTail= maxSumTail + nums[i];
			}
        	if(maxSumTail>maxSum) {	maxSum = maxSumTail;}
        }
        return maxSum;
    }
	public int maxSubArray2(int[] nums) {
        int sum=0;
        int maxSum = Integer.MIN_VALUE;
        for(int num:nums){
        	if(sum<0) {sum = num;}
        	else {sum+=num;}
            if(maxSum<sum){	maxSum=sum;}
        }
        return maxSum;
    }

    public int maxSubArray0(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
        	int sum = 0;
        	for(int j=i;j<nums.length;j++) {
        		sum += nums[j];
        		if(sum>maxSum) {	maxSum = sum;}
        	}
        }
        return maxSum;
    }
    public int maxSubArray3(int[] nums) {
        return maxSubArrayPart(nums,0,nums.length-1);
    }
    
    private int maxSubArrayPart(int[] nums,int left,int right){
        if(left==right){
            return nums[left];
        }
        int mid=(left+right)/2;
        return Math.max(
            maxSubArrayPart(nums,left,mid),
            Math.max(
                maxSubArrayPart(nums,mid+1,right),
                maxSubArrayAll(nums,left,mid,right)
            )
        );
    }

    //左右两边合起来求解
    private int maxSubArrayAll(int[] nums,int left,int mid,int right){
        int leftSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=mid;i>=left;i--){
            sum+=nums[i];
            if(sum>leftSum){
                leftSum=sum;
            }
        }
        sum=0;
        int rightSum=Integer.MIN_VALUE;
        for(int i=mid+1;i<=right;i++){
            sum+=nums[i];
            if(sum>rightSum){
                rightSum=sum;
            }
        }
        return leftSum+rightSum;
    }
}

