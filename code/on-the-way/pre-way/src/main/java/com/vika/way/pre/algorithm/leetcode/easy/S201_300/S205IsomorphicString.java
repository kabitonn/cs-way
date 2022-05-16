package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

import java.util.HashMap;
import java.util.Map;

public class S205IsomorphicString {

    public static void main(String[] args) {
        S205IsomorphicString solution = new S205IsomorphicString();
        System.out.println(solution.isIsomorphic4("ab", "aa"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            if (!map.containsKey(ss[i])) {
                if (map.containsValue(tt[i])) {
                    return false;
                }
                map.put(ss[i], tt[i]);
                ss[i] = tt[i];
            } else {
                ss[i] = map.get(ss[i]);
            }
        }
        String str = new String(ss);
        return str.equals(t);
    }

    public boolean isIsomorphic1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            if (!map.containsKey(ss[i])) {
                if (map.containsValue(tt[i])) {
                    return false;
                }
                map.put(ss[i], tt[i]);
            } else {
                if (map.get(ss[i]) != tt[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] sIndex = new int[256];
        int[] tIndex = new int[256];
        for (int i = ss.length - 1; i >= 0; i--) {
            if (sIndex[ss[i]] != tIndex[tt[i]]) {
                return false;
            }
            sIndex[ss[i]] = tIndex[tt[i]] = i;
        }
        return true;
    }

    public boolean isIsomorphic4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        char[] mapS2T = new char[128];
        char[] mapT = new char[128];
        for (int i = ss.length - 1; i >= 0; i--) {
            if (mapS2T[ss[i]] != mapT[tt[i]]) {
                return false;
            }
            mapS2T[ss[i]] = mapT[tt[i]] = tt[i];
        }
        return true;
    }
}
