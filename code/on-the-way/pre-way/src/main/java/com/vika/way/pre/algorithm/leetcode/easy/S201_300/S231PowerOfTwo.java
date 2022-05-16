package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

public class S231PowerOfTwo {

	public static void main(String[] args) {

	}
    public boolean isPowerOfTwo(int n) {
    	if(n<=0) {return false;}
    	while(n!=1) {
    		if((n&1)==1) {return false;}
    		n>>=1;
    	}
        return true;
    }
    public boolean isPowerOfTwo1(int n) {
        return n>0&&(n&(n-1))==0;
    }
}
