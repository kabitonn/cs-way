package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

public class S171ExcelTitleToNumber {

	public static void main(String[] args) {

	}

    public int titleToNumber(String s) {
        int num = 0;
    	for(char c:s.toCharArray()) {
        	int n = c-'A'+1;
        	num = num*26+n;
        }
    	return num;
    }
}