package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.*;

public class S524LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String str : d) {
            if (isSubsequence(str, s)) {
                if (str.length() > longestWord.length()) {
                    longestWord = str;
                } else if (str.length() == longestWord.length() && str.compareTo(longestWord) < 0) {
                    longestWord = str;
                }
            }
        }
        return longestWord;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        } else if (s.length() == 0 || s.equals(t)) {
            return true;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        for (char c : t.toCharArray()) {
            if (chars[i] == c) {
                i++;
                if (i == chars.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public String findLongestWord1(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return 1;
                } else if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return -1;
                }
            }
        });
        for (String str : d) {
            if (isSubsequence(str, s)) {
                return str;
            }
        }
        return "";
    }

    public String findLongestWord2(String s, List<String> d) {
        String longestWord = "";
        for (String str : d) {
            if (str.length() < longestWord.length()) {
                continue;
            }
            if (str.length() == longestWord.length() && longestWord.compareTo(str) < 0) {
                continue;
            }
            if (isSubsequence1(str, s)) {
                longestWord = str;
            }
        }
        return longestWord;
    }

    public boolean isSubsequence1(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int prev = -1;
        for (char c : s.toCharArray()) {
            int index = t.indexOf(c, prev + 1);
            if (index == -1) {
                return false;
            }
            prev = index;
        }
        return true;
    }


    public static void main(String[] args) {
        S524LongestWordInDictionaryThroughDeleting soluion = new S524LongestWordInDictionaryThroughDeleting();
        List<String> list = new ArrayList<>(Arrays.asList("b", "a"));
        System.out.println(soluion.findLongestWord("", list));
    }
}
