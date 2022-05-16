package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S066PlusOne {

	public static void main(String[] args) {
		S066PlusOne solution = new S066PlusOne();
		int[] digits = {9,9};
		System.out.println(Arrays.toString(solution.plusOne1(digits)));
	}
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		List<Integer> list = new ArrayList<>();
		int carry = 1;
		int num = 0;
		for(int i=n-1;i>=0;i--) {
			num = digits[i]+carry;
			carry = num/10;
			num %= 10;
			list.add(0,num);
		}
		if(carry!=0) {
			list.add(0, carry);
		}
		n = list.size();
    	int[] plusNum = new int[n];
    	for(int i=0;i<n;i++) {
    		plusNum[i] = list.get(i);
    	}
		return plusNum;
	}
	public int[] plusOne1(int[] digits) {
		int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
	}
    public int[] plusOne0(int[] digits) {
        long num = 0;
    	for(int n:digits) {
        	num = num*10+n;
        }
    	num++;
    	List<Integer> list = new ArrayList<>();
    	while(num!=0) {
    		list.add((int)(num%10));
    		num/=10;
    	}
    	int n = list.size();
    	int[] plusNum = new int[n];
    	for(int i=0;i<n;i++) {
    		plusNum[i] = list.get(n-i-1);
    	}
    	return plusNum;
    }
}
