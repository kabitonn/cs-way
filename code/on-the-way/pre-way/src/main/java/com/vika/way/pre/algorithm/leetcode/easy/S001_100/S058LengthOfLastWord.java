package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S058LengthOfLastWord {

	public static void main(String[] args) {
		S058LengthOfLastWord solution = new S058LengthOfLastWord();
		System.out.println(solution.lengthOfLastWord("Hello World    "));

	}
    public int lengthOfLastWord(String s) {
        String string = s.trim();
        int i = string.length()-1;
        while(i>=0 ) {
        	if((string.charAt(i)<='z'&&string.charAt(i)>='a')||(string.charAt(i)<='Z'&&string.charAt(i)>='A')) {
        		i--;
        	}
        	else {break;}
        }
        return string.length()-i-1;
    }
    public int lengthOfLastWord1(String s) {
        int end = s.length()-1;
        while(end>=0&&s.charAt(end)==' ') {end--;}
        int start = end;
        while(start>=0&&s.charAt(start)!=' ') {start--;}
        return end-start;
    }
}
