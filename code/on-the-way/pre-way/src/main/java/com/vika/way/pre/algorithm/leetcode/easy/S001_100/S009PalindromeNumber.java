package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S009PalindromeNumber {

	public static void main(String[] args) {
		S009PalindromeNumber solution = new S009PalindromeNumber();
		System.out.println(solution.isPalindrome1(11));
	}
	public boolean isPalindrome(int x) {
		if(x<0) {
			return false;
		}
		int y=0;
		int tmp = x;
		while(x!=0) {
			y=y*10+x%10;
			x/=10;
		}
        return tmp==y?true:false;
    }
	public boolean isPalindrome1(int x) {
		if(x<0) {
			return false;
		}
		int digit = (int)Math.log10(x)+1;
		int y = 0;
		for(int i=0;i<digit/2;i++) {
			y=y*10+x%10;
			x/=10;
		}
		if(digit%2==0) {
			return x==y?true:false;
		}
		else {
			return (x/10)==y?true:false;
		}
    }
	
}

