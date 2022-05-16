package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

import java.util.HashMap;
import java.util.Map;

public class S383RansomNote {

	public static void main(String[] args) {

	}
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransom = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int count;
        for(char c:maga) {
        	count = map.getOrDefault(c, 0);
        	map.put(c, ++count);
        }
        for(char c:ransom) {
        	count = map.getOrDefault(c, 0);
        	count--;
        	if(count<0) {return false;}
        	map.put(c, count);
        }
        return true;
    }
    public boolean canConstruct1(String ransomNote, String magazine) {
        char[] ransom = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        int[] map = new int[26];
        for(char c:maga) {
        	map[c-'a']++;
        }
        for(char c:ransom) {
        	map[c-'a']--;
        	if(map[c-'a']<0) {return false;}
        }
        return true;
    }
}
