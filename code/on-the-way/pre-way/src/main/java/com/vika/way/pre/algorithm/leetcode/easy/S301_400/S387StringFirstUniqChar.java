package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

import java.util.HashMap;
import java.util.Map;

public class S387StringFirstUniqChar {

	public static void main(String[] args) {

	}
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(char c:s.toCharArray()) {
        	if(!map.containsKey(c)) {
        		map.put(c, i);
        	}
        	else {
				map.put(c, -1);
			}
        	i++;
        }
        int first = -1;
        for(Character c:map.keySet()) {
        	int index = map.get(c);
        	if(index!=-1&&(first==-1||first>index)) {
        		first = index;
        	}
        }
        return first;
    }
	public int firstUniqChar3(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c:s.toCharArray()) {
			int count = map.getOrDefault(c, 0);
			map.put(c, ++count);
		}
		for(int i=0;i<s.length();i++) {
			if(map.get(s.charAt(i))==1){
				return i;
			}
		}
		return -1;
	}
    public int firstUniqChar1(String s) {
        char[] str = s.toCharArray();
        int[] map = new int[26];
        for(char c:str) {
        	map[c-'a']++;
        }
        for(int i=0;i<str.length;i++) {
        	if(map[str[i]-'a']==1) {
        		return i;
        	}
        }
        return -1;
    }
    public int firstUniqChar2(String s) {
    	int first = -1;
    	for(char c = 'a';c<='z';c++) {
    		int firstIndex = s.indexOf(c);
    		int lastIndex = s.lastIndexOf(c);
    		if(firstIndex==-1||firstIndex!=lastIndex) {continue;}
    		if(first==-1||first>firstIndex) {
    			first = firstIndex;
    		}
    	}
    	return first;
    }
}
