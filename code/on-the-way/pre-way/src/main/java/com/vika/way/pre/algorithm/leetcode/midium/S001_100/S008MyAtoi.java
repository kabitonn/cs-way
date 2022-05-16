package com.vika.way.pre.algorithm.leetcode.midium.S001_100;


public class S008MyAtoi {

	public static void main(String[] args) {
		S008MyAtoi solution = new S008MyAtoi();
		System.out.println(solution.myAtoi1("9223372036854775808"));
		System.out.println(solution.myAtoi1("words and -987"));
		System.out.println(solution.myAtoi1("-91283472332"));
		
	}
	public int myAtoi(String str) {
		int num = 0;
		boolean isMinus = false;
		String s = str.trim();
		int start=0;
		if(s.length()==0) {
            return 0;
        }
		if(s.charAt(start)=='-') {
			isMinus = true;
			start++;
		}
		else if(s.charAt(start)=='+') {
			start++;
		}
		else if(s.charAt(start)>='0'&&s.charAt(start)<='9') {
			
		}
		else {
			return 0;
		}
		for(int i=start;i<s.length();i++) {
			if(s.charAt(i)>='0' && s.charAt(i)<='9') {
				int n = s.charAt(i)-'0';
				if( num>Integer.MAX_VALUE/10||(num==Integer.MAX_VALUE/10 && n >=8)) {
					if(isMinus) {
                        return Integer.MIN_VALUE;
                    }
					return Integer.MAX_VALUE;
				}
				
				num = num*10+n;
			}
			else {
				break;
			}
		}
		if(isMinus) {
			num = -num;
		}
        return num;
    }
	public int myAtoi1(String str) {
		long num = 0;
		boolean isMinus = false;
		String s = str.trim();
		int start=0;
		if(s.length()==0) {
            return 0;
        }
		if(s.charAt(start)=='-') {
			isMinus = true;
			start++;
		}
		else if(s.charAt(start)=='+') {
			start++;
		}
		else if(s.charAt(start)>='0'&&s.charAt(start)<='9') {
			
		}
		else {
			return 0;
		}
		for(int i=start;i<s.length();i++) {
			if(s.charAt(i)>='0' && s.charAt(i)<='9') {
				int n = s.charAt(i)-'0';
				num = num*10+n;
				if(num>Integer.MAX_VALUE) {
					if(isMinus) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }

				}
			}
			else {
				break;
			}
		}
		if(isMinus) {
			num = -num;
		}
		
		return (int)num;
    }
	

}
