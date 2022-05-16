package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S438FindStringAnagrams {

    public static void main(String[] args) {
        S438FindStringAnagrams solution = new S438FindStringAnagrams();
        System.out.println(solution.findAnagrams2("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int lens = s.length(), lenp = p.length();
        if (lens < lenp || lenp == 0) {
            return list;
        }
        for (int i = 0; i <= lens - lenp; i++) {
            if (isAnagram(s.substring(i, i + lenp), p)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean isAnagram(String s, String t) {
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

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int lens = s.length(), lenp = p.length();
        if (lens < lenp || lenp == 0) {
            return list;
        }
        int[] map = new int[26];
        for (char c : p.toCharArray()) {
            map[c - 'a']++;
        }
        int[] substr = new int[26];
        for (int start = 0; start < lenp; start++) {
            substr[s.charAt(start) - 'a']++;
        }
        if (Arrays.equals(map, substr)) {
            list.add(0);
        }
        for (int start = 1; start <= lens - lenp; start++) {
            substr[s.charAt(start - 1) - 'a']--;
            substr[s.charAt(start + lenp - 1) - 'a']++;
            if (Arrays.equals(map, substr)) {
                list.add(start);
            }
        }
        return list;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int lens = s.length(), lenp = p.length();
        if (lens < lenp || lenp == 0) {
            return list;
        }
        int[] need = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        int left = 0, right = 0;
        int count = 0;
        while (right < lens) {
            if (need[s.charAt(right) - 'a']-- > 0) {
                //先判断符合需求？，对应需求数目-1，符合数+1
                count++;
            }
            right++;
            //数目相等符合异位词要求
            if (count == lenp) {
                list.add(left);
            }
            //窗口达到最大移除左边界
            if (right - left == lenp) {
                if (need[s.charAt(left) - 'a']++ >= 0) {
                    //移除元素是符合需求？对应需求+1，符合数-1
                    count--;
                }
                left++;
            }
        }
        return list;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int lens = s.length(), lenp = p.length();
        if (lens < lenp || lenp == 0) {
            return list;
        }
        int[] need = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < lenp; i++) {
            if (need[s.charAt(i) - 'a']-- > 0) {
                count++;
            }
        }
        if (count == lenp) {
            list.add(0);
        }
        for (int i = 1; i <= lens - lenp; i++) {
            if (need[s.charAt(i - 1) - 'a']++ >= 0) {
                count--;
            }
            if (need[s.charAt(i + lenp - 1) - 'a']-- > 0) {
                count++;
            }
            if (count == lenp) {
                list.add(i);
            }
        }
        return list;
    }
}
