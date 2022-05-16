package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

public class S371TwoIntSum {

	public static void main(String[] args) {

	}
    public int getSum(int a, int b) {
    	while(b != 0){
            int sum = a ^ b;    //按位加但不进位
            int carry = (a & b) << 1;   //按位与表示进位
            a = sum;
            b = carry;
        }
        return a;
    }
}
