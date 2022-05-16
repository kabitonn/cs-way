package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S131PalindromePartitioning {

    public List<List<String>> partition(String s) {
        return conquer(s);
    }

    public List<List<String>> conquer(String s) {
        List<List<String>> listList = new ArrayList<>();
        if (s.length() == 0) {
            listList.add(new ArrayList<>());
            return listList;
        }
        if (s.length() == 1) {
            listList.add(new ArrayList<>(Arrays.asList(s)));
            return listList;
        }
        for (int i = 0; i < s.length(); i++) {
            String leftStr = s.substring(0, i + 1);
            if (!isPalindrome(leftStr)) {
                continue;
            }
            String rightStr = s.substring(i + 1);
            for (List<String> list : conquer(rightStr)) {
                list.add(0, leftStr);
                listList.add(list);
            }
        }
        return listList;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public List<List<String>> partition1(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int l = 1; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int j = i + l - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (l < 3 || dp[i + 1][j - 1]);
            }
        }
        return conquer1(s, 0, dp);
    }

    public List<List<String>> conquer1(String s, int start, boolean[][] dp) {
        List<List<String>> listList = new ArrayList<>();
        if (start == s.length()) {
            listList.add(new ArrayList<>());
            return listList;
        }
        for (int i = start; i < s.length(); i++) {
            if (!dp[start][i]) {
                continue;
            }
            String leftStr = s.substring(start, i + 1);
            for (List<String> list : conquer1(s, i + 1, dp)) {
                list.add(0, leftStr);
                listList.add(list);
            }
        }
        return listList;
    }

    public List<List<String>> partition2(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int l = 1; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int j = i + l - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (l < 3 || dp[i + 1][j - 1]);
            }
        }
        List<List<String>> listList = new ArrayList<>();
        backtrack(s, 0, listList, new ArrayList<>(), dp);
        return listList;
    }

    public void backtrack(String s, int start, List<List<String>> listList, List<String> list, boolean[][] dp) {
        if (start == s.length()) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                list.add(s.substring(start, i + 1));
                backtrack(s, i + 1, listList, list, dp);
                list.remove(list.size() - 1);
            }
        }
    }
}


