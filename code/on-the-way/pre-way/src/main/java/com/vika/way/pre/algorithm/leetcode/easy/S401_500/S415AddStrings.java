package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

public class S415AddStrings {

	public static void main(String[] args) {
		S415AddStrings solution = new S415AddStrings();
		System.out.println(solution.addStrings("0", "0"));
	}
    public String addStrings(String num1, String num2) {
    	String str = "";
    	int carry = 0;
    	int i=0,len1=num1.length(),len2=num2.length();
    	while(carry!=0||i<len1||i<len2) {
    		int a = 0,b = 0;
    		if(i<len1) {
    			a = num1.charAt(len1-1-i)-'0';
    		}
    		if(i<len2) {
    			b = num2.charAt(len2-1-i)-'0';
    		}
    		int sum = a+b+carry;
    		carry = sum/10;
    		str = sum%10+str;
    		i++;
    	}
    	
        return str;
    }
    public String addStrings1(String num1, String num2) {
    	StringBuilder sb = new StringBuilder();
    	int carry = 0;
    	int i=0,len1=num1.length(),len2=num2.length();
    	char[] n1 = num1.toCharArray();
    	char[] n2 = num2.toCharArray();
     	while(carry!=0||i<len1||i<len2) {
    		int a = 0,b = 0;
    		if(i<len1) {
    			a = n1[len1-1-i]-'0';
    		}
    		if(i<len2) {
    			b = n2[len2-1-i]-'0';
    		}
    		int sum = a+b+carry;
    		carry = sum/10;
    		sb.append(sum%10);
    		i++;
    	}
    	
        return sb.reverse().toString();
    }
    public String addStrings2(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0||carry!=0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        return res.reverse().toString();
    }
}
