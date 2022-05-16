package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S005LongestPalindrome {

    public static void main(String[] args) {

    }

    public String longestPalindrome5(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String r = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxLen = 0;
        return null;
    }


    public String longestPalindrome4(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxLen = 0;
        int start = 0, end = 0;
        for (int c = 0; c < s.length(); c++) {
            int len1 = expandAroundCenter(s, c, c);
            int len2 = expandAroundCenter(s, c, c + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                start = c - (len - 1) / 2;
                end = c + len / 2;
                maxLen = len;
            }
        }
        String longestPalindrome = s.substring(start, end + 1);
        return longestPalindrome;
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public String longestPalindrome3(String s) {
        int n = s.length();
        String longestPalindrome = "";
        boolean[] dp = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                dp[j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[j - 1]);
                if (dp[j] && j - i + 1 > longestPalindrome.length()) {
                    longestPalindrome = s.substring(i, j + 1);
                }
            }
        }
        return longestPalindrome;
    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        String longestPalindrome = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                //j - i 代表长度减去 1
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > longestPalindrome.length()) {
                    longestPalindrome = s.substring(i, j + 1);
                }
            }
        }
        return longestPalindrome;
    }

    public String longestPalindrome1(String s) {
        String longestPalindrome = "";
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        for (int len = 1; len <= length; len++) {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                //下标已经越界，结束本次循环
                if (end >= length) {
                    break;
                }
                //长度为 1 和 2 的单独判断下
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                if (P[start][end]) {
                    longestPalindrome = s.substring(start, end + 1);
                }
            }
        }
        return longestPalindrome;
    }

    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                if (isPalindrome(str) && j + 1 - i > len) {
                    longestPalindrome = str;
                    len = j + 1 - i;
                }
            }
        }
        return longestPalindrome;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
