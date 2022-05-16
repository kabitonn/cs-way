package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

public class S345ReverseVowels {

	public static void main(String[] args) {
		S345ReverseVowels solution = new S345ReverseVowels();
		System.out.println(solution.reverseVowels2("leetcode"));
	}
	public String reverseVowels(String s) {
		char[] str = s.toCharArray();
		int i=0,j=str.length-1;
		boolean left = false,right = false;
		while(i<j) {
			if(left&&right) {
				swap(str, i++, j--);
				left = false;
				right = false;
				continue;
			}
			if(!left) {
				if(!isVowel(str[i])) {	i++;}
				else {	left = true;}
			}
			if(!right) {
				if(!isVowel(str[j])) {	j--;}
				else {	right = true;}
			}

		}
		return new String(str);
	}
	public String reverseVowels1(String s) {
		char[] str = s.toCharArray();
		int i=0,j=str.length-1;
		while(i<j) {
			if(isVowel(str[i])&&isVowel(str[j])) {
				swap(str, i++, j--);
				continue;
			}
			if(!isVowel(str[i])) {	i++;}
			if(!isVowel(str[j])) {	j--;}
		}
		return new String(str);
	}
	public String reverseVowels2(String s) {
		char[] str = s.toCharArray();
		int i=0,j=str.length-1;
		while(i<j) {
			while(i<j&&!isVowel(str[i])) {	i++;}
			while(i<j&&!isVowel(str[j])) {	j--;}
				swap(str, i++, j--);
		}
		return new String(str);
	}
	public boolean isVowel(char c) {
		if(c=='a'||c=='i'||c=='u'||c=='o'||c=='e') {return true;}
		if(c=='A'||c=='I'||c=='U'||c=='O'||c=='E') {return true;}
		return false;
	}
	public void swap(char[] s, int i,int j) {
		char tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;
	}
}
