package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

public class S342PowerOfFour {

	public static void main(String[] args) {

	}
	public boolean isPowerOfFour(int n) {
		if(n<=0) {return false;}
		while(n%4==0) {
			n/=4;
		}
		return n==1;
	}
	public boolean isPowerOfFour1(int n) {
		//double r = Math.log10(n)/Math.log10(3);
		//return r==(int)r;
		return (Math.log10(n) / Math.log10(4)) % 1 == 0;
	}
	public boolean isPowerOfFour2(int n) {
		if(n<=0) {return false;}
		while(n!=1) {
			if(n%4!=0) {return false;}
			n/=4;
		}
		return true;
	}
	public boolean isPowerOfFour3(int n){
		return n>0 && (n&(n-1))==0 && (0xaaaaaaaa&n)==0;
	}
}
