package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S011MaxArea {

	public static void main(String[] args) {
		S011MaxArea solution = new S011MaxArea();
		int[] height = {2,3,4,5,18,17,6};
		System.out.println(solution.maxArea2(height));
	}
    public int maxArea(int[] height) {
    	int maxArea = 0;
    	int area;
    	for(int i=0;i<height.length-1;i++) {
    		for(int j=i+1;j<height.length;j++) {
    			area = (j-i)*Math.min(height[i], height[j]);
    			if(area>maxArea) {
    				maxArea = area;
    			}
    		}
    	}
        return maxArea;
    }
    public int maxArea0(int[] height) {
		int maxArea =0;
		int area;
		for(int i=0;i<height.length-1;i++) {
			area = (height.length-1-i)*Math.min(height[i], height[height.length-1]);
			if(area>maxArea) {
				maxArea = area;
			}
			for(int j=height.length-1;j>i;j--) {
				if(height[j]<=height[height.length-1]) {
                    continue;
                }
				area = (j-i)*Math.min(height[i], height[j]);
				if(area>maxArea) {
					maxArea = area;
				}
			}
		}
	    return maxArea;
    }
    public int maxArea1(int[] height) {
    	int maxArea =0;
    	int area;
    	int max;
    	for(int i=0;i<height.length-1;i++) {
    		area = (height.length-1-i)*Math.min(height[i], height[height.length-1]);
			if(area>maxArea) {
				maxArea = area;
			}
			max = height[height.length-1];
    		for(int j=height.length-1;j>i;j--) {
    			if(height[j]<=max) {
                    continue;
                }
    			max = height[j];
    			area = (j-i)*Math.min(height[i], height[j]);
    			if(area>maxArea) {
    				maxArea = area;
    			}
    		}
    	}
        return maxArea;
    }
    public int maxArea2(int[] height) {
    	int left = 0, right = height.length-1;
    	int maxArea = 0;
    	while(left<right) {
    		maxArea=Math.max(maxArea, (right-left)*Math.min(height[left], height[right]));
    		if(height[left]<height[right]) {
    			left++;
    		}
    		else {
				right--;
			}
    	}
    	return maxArea;
    }
}
