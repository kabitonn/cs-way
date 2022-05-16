package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

public class S278FirstBadVersion {

	public static void main(String[] args) {

	}
    public int firstBadVersion(int n) {
    	int left = 1;
    	int right = n;
    	while(left<right) {
    		int mid = left+(right-left)/2;
    		if(isBadVersion(mid)) {
    			right = mid;
    		}
    		else {
				left = mid+1;
			}
    	}
        return left;
    }
	private boolean isBadVersion(int mid) {
		return false;
	}
}
