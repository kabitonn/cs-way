package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

public class S168ExcelConvertToTitle {

	public static void main(String[] args) {

	}
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n!=0) {
        	int r = n%26;
        	char c = r==0?'Z':(char) ((r-1)+'A');
        	n = r==0?(n-26)/26:n/26;
        	sb.append(c);
        }
        return sb.reverse().toString();
    }
    public String convertToTitle1(int n) {
    	StringBuilder sb = new StringBuilder();
    	while(n!=0) {
    		n--;
    		int r = n%26;
    		char c = (char) (r+'A');
    		n/=26;
    		sb.append(c);
    	}
    	return sb.reverse().toString();
    }
}
