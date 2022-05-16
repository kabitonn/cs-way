package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.Arrays;

public class S567PermutationInString {

    //超时
    public boolean checkInclusion(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        return permutation(chars1, 0, s2);
    }

    public boolean permutation(char[] chars, int pos, String s) {
        if (pos == chars.length) {
            return s.contains(new String(chars));
        }
        for (int i = pos; i < chars.length; i++) {
            swap(chars, i, pos);
            if (permutation(chars, pos + 1, s)) {
                return true;
            }
            swap(chars, i, pos);
        }
        return false;
    }

    public void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }



    public boolean checkInclusion2(String s1, String s2) {
        s1 = sort(s1);
        int n1 = s1.length(), n2 = s2.length();
        for (int i = 0; i <= n2 - n1; i++) {
            String s = s2.substring(i, i + n1);
            s = sort(s);
            if (s1.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public boolean checkInclusion3(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) {
            return false;
        }
        int[] map = new int[26];
        for (char ch : s1.toCharArray()) {
            map[ch - 'a']++;
        }
        int[] substr = new int[26];
        for (int i = 0; i < n1; i++) {
            substr[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(map, substr)) {
            return true;
        }
        for (int i = n1; i < n2; i++) {
            substr[s2.charAt(i) - 'a']++;
            substr[s2.charAt(i - n1) - 'a']--;
            if (Arrays.equals(map, substr)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion4(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) {
            return false;
        }
        int[] need = new int[26];
        for (char ch : s1.toCharArray()) {
            need[ch - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < n1; i++) {
            if (need[s2.charAt(i) - 'a']-- > 0) {
                count++;
            }
        }
        if (count == n1) {
            return true;
        }
        for (int i = n1; i < n2; i++) {
            if (need[s2.charAt(i) - 'a']-- > 0) {
                count++;
            }
            if (need[s2.charAt(i - n1) - 'a']++ >= 0) {
                count--;
            }
            if (count == n1) {
                return true;
            }
        }
        return false;
    }
    public boolean checkInclusion1(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[] need = new int[26];
        for (char ch : s1.toCharArray()) {
            need[ch - 'a']++;
        }
        int i = 0, j = 0;
        int count = 0;
        while (j < n2) {
            if (need[s2.charAt(j++) - 'a']-- > 0) {
                count++;
            }
            if (count == n1) {
                return true;
            }
            if (j - i == n1) {
                if (need[s2.charAt(i++) - 'a']++ >= 0) {
                    count--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        S567PermutationInString solution = new S567PermutationInString();
        System.out.println(solution.checkInclusion4("aba", "eidabaooao"));
    }
}
