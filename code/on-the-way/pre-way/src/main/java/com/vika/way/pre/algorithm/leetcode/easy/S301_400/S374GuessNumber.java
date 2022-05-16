package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

public class S374GuessNumber {

	public static void main(String[] args) {

	}
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low<=high) {
        	int mid = low+(high-low)/2;
        	if(guess(mid)==0) {
        		return mid;
        	}
        	else if (guess(mid)==-1) {
				high = mid-1;
			}
        	else {
				low = mid+1;
			}
        }
        return 0;
    }
    public int guessNumber1(int n) {
        int low = 1;
        int high = n;
        while(low<high) {
        	int mid = low+(high-low+1)/2;
        	if (guess(mid)==-1) {
				high = mid-1;
			}
        	else {
				low = mid;
			}
        }
        return low;
    }
	public int guessNumber2(int n) {
		for (int i = 1; i < n; i++) {
            if (guess(i) == 0) {
                return i;
            }
        }
		return n;
	}

	private int guess(int mid) {
		return 0;
	}
}
