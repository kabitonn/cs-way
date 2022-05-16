package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

public class S326PowerOfThree {

	public static void main(String[] args) {
		S326PowerOfThree solution = new S326PowerOfThree();
		System.out.println(solution.isPowerOfThree1(243*243));
	}
	public boolean isPowerOfThree(int n) {
		if(n<=0) {return false;}
		while(n%3==0) {
			n/=3;
		}
		return n==1;
	}
	public boolean isPowerOfThree1(int n) {
		//double r = Math.log10(n)/Math.log10(3);
		//return r==(int)r;
		//return (Math.log10(n) / Math.log10(3)) % 1 == 0;//通过取小数部分（利用 % 1）来检查数字是否是整数，并检查它是否是 0。
		return n > 0 && Math.pow(3, 19) % n == 0;
	}
	public boolean isPowerOfThree2(int n) {
		if(n<=0) {return false;}
		while(n!=1) {
			if(n%3!=0) {return false;}
			n/=3;
		}
		return true;
	}
}
