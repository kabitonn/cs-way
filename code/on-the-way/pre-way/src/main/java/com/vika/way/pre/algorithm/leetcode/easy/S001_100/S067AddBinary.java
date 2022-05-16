package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S067AddBinary {

	public static void main(String[] args) {

	}
    public String addBinary(String a, String b) {
    	int i = a.length()-1;
    	int j = b.length()-1;
    	char[] stra = a.toCharArray();
    	char[] strb = b.toCharArray();
    	int carry = 0;
    	StringBuilder sb = new StringBuilder();
    	while(i>=0||j>=0||carry!=0) {
    		int c = 0 + carry;
    		if(i>=0) {	c+=stra[i--] - '0';}
    		if(j>=0) {	c+=strb[j--] - '0';}
    		carry = c/2;
    		c %= 2;
    		sb.append((char)(c+'0'));
    		//sb.insert(0,(char)(c+'0'));
    	}
        return sb.reverse().toString();
    }
	public String addBinary1(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int num1 = i >= 0 ? a.charAt(i) - 48 : 0;
			int num2 = j >= 0 ? b.charAt(j) - 48 : 0;
			int sum = num1 + num2 + carry;
			carry = 0;
			if (sum >= 2) {
				sum = sum % 2;
				carry = 1;
			}
			sb.insert(0, sum);
			i--;
			j--;

		}
		if (carry == 1) {
			sb.insert(0, 1);
		}
		return sb.toString();
	}
}
