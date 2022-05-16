package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

public class S389FindTheDifference {

	public static void main(String[] args) {

	}
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for(char c:t.toCharArray()) {
        	map[c-'a']++;
        }
        for(char c:s.toCharArray()) {
        	map[c-'a']--;
        }
        for(int i=0;i<map.length;i++) {
        	if(map[i]!=0) {
        		return (char) (i+'a');
        	}
        }
        return ' ';
    }
    public char findTheDifference1(String s, String t) {
        int[] map = new int[26];
        for(char c:s.toCharArray()) {
        	map[c-'a']++;
        }
        for(char c:t.toCharArray()) {
        	if(--map[c-'a']<0) {
        		return c;
        	}
        }
        return ' ';
    }
    public char findTheDifference2(String s, String t) {
        int sum = 0;
    	for(char c:t.toCharArray()) {
        	sum+=c;
        }
        for(char c:s.toCharArray()) {
        	sum-=c;
        }
        return (char) sum;
    }
    public char findTheDifference3(String s, String t) {
        int sum = 0;
    	for(char c:t.toCharArray()) {
        	sum^=c;
        }
        for(char c:s.toCharArray()) {
        	sum^=c;
        }
        return (char) sum;
    }
}
