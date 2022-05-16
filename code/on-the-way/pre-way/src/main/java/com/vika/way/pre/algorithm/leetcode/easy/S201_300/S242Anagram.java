package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S242Anagram {

    public static void main(String[] args) {
        S242Anagram solution = new S242Anagram();
        System.out.println(solution.isAnagram5("car", "rac"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (char c : ss) {
            int count = mapS.getOrDefault(c, 0);
            mapS.put(c, count + 1);
        }
        for (char c : tt) {
            int count = mapT.getOrDefault(c, 0);
            mapT.put(c, count + 1);
        }
        for (char c : mapS.keySet()) {
            if (!mapS.get(c).equals(mapT.getOrDefault(c, 0))) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (char c : ss) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        for (char c : tt) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count - 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (char c : ss) {
            int index = c - 'a';
            map[index]++;
        }
        for (char c : tt) {
            int index = c - 'a';
            map[index]--;
            if (map[index] < 0) {
                return false;
            }
        }
    	/*for(int n:map) {
    		if(n!=0) {return false;}
    	}*/
        return true;
//    	return Arrays.equals(map,new int[26]);
    }

    public boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);
    }

    //key溢出
    public boolean isAnagram5(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        long keyS = 1, keyT = 1;
        for (int i = 0; i < s.length(); i++) {
            keyS *= prime[s.charAt(i) - 'a'];
            keyT *= prime[t.charAt(i) - 'a'];
        }
        return keyS == keyT;
    }
}
