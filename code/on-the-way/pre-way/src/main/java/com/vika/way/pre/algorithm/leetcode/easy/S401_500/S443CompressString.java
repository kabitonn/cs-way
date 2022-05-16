package com.vika.way.pre.algorithm.leetcode.easy.S401_500;


public class S443CompressString {

	public static void main(String[] args) {

	}
    public int compress(char[] chars) {
        int len=chars.length;
        int count=1;
        int index = 0;
        int i=0;
        for(;i<len;i++) {
        	if(i==0) {continue;}
        	if(chars[i]==chars[i-1]) {count++;}
        	else if(chars[i]!=chars[i-1]) {
        		chars[index++] = chars[i-1];
        		if(count!=1) {
        			String strCount = Integer.toString(count);
        			for(int j=0;j<strCount.length();j++) {
        				chars[index++] = strCount.charAt(j);
        			}
        		}
        		count = 1;
        	}
        }
        chars[index++] = chars[len-1];
        if(count!=1) {
			String strCount = Integer.toString(count);
			for(int j=0;j<strCount.length();j++) {
				chars[index++] = strCount.charAt(j);
			}
		}
        return index;
    }
	public int compress0(char[] chars) {
		int len=chars.length;
		int count=1;
		int index = 0;
		int i=0;
		for(;i<len;i++) {
			if(i+1<len&&chars[i]==chars[i+1]) {count++;}
			else if(i+1<len&&chars[i]!=chars[i+1]) {
				chars[index++] = chars[i];
				if(count!=1) {
					String strCount = Integer.toString(count);
					for(int j=0;j<strCount.length();j++) {
						chars[index++] = strCount.charAt(j);
					}
				}
				count = 1;
			}
		}
		chars[index++] = chars[len-1];
		if(count!=1) {
			String strCount = Integer.toString(count);
			for(int j=0;j<strCount.length();j++) {
				chars[index++] = strCount.charAt(j);
			}
		}
		return index;
	}
    public int compress1(char[] chars) {
    	int len=chars.length;
        int index = 0;
        int i=0;
        while(i<len) {
        	chars[index++] = chars[i];
        	int j=i+1;
        	while(j<len&&chars[j]==chars[i]) {j++;}
        	if(j-i!=1) {
        		String strCount = String.valueOf(j-1-1);
        		for(char c:strCount.toCharArray()) {chars[index++]=c;}
        		i=j;
        	}
        	i++;
        }
        return index;
    }
}
