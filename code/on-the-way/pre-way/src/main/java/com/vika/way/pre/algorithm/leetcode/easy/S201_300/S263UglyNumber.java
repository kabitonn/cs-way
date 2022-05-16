package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

public class S263UglyNumber {

	public static void main(String[] args) {

	}
    public boolean isUgly(int num) {
    	if(num<=0) {return false;}
    	while(num%5==0) {
    		num/=5;
    	}
    	while(num%3==0) {
    		num/=3;
    	}
    	while(num%2==0) {
    		num/=2;
    	}
        return num==1;
    }
}