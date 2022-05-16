package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

public class S172TrailingZeroes {

	public static void main(String[] args) {
		S172TrailingZeroes solution = new S172TrailingZeroes();
		System.out.println(solution.trailingZeroes(2147483647));
	}
    public int trailingZeroes0(int n) {
        int count = 0;
        for(int i=0;i<=n;i+=5) {
        	int m = i;
        	while(m!=0&&m%5==0) {
        		m/=5;
        		count++;
        	}
        }
        return count;
    }
    public int trailingZeroes1(int n) {
    	int count = 0;
    	while(n/5!=0) {
    		count += n/5;
    		n/=5;
    	}
    	return count;
    }
	public int trailingZeroes(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}

}
