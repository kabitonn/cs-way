package com.vika.way.pre.algorithm.leetcode.midium.S1101_1200;

public class S1143LongestCommonSubsequence {

    public int longestCommonSubsequence(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        return longestCommonSubsequence(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    public int longestCommonSubsequence(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + longestCommonSubsequence(s1, s2, i - 1, j - 1);
        } else {
            return Math.max(longestCommonSubsequence(s1, s2, i - 1, j), longestCommonSubsequence(s1, s2, i, j - 1));
        }
    }

    public int longestCommonSubsequence1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        int n1 = s1.length(), n2 = s2.length();
        Integer[][] memo = new Integer[n1][n2];
        return longestCommonSubsequence1(s1, s2, n1 - 1, n2 - 1, memo);
    }

    public int longestCommonSubsequence1(String s1, String s2, int i, int j, Integer[][] memo) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + longestCommonSubsequence1(s1, s2, i - 1, j - 1, memo);
        } else {
            memo[i][j] = Math.max(longestCommonSubsequence1(s1, s2, i - 1, j, memo), longestCommonSubsequence1(s1, s2, i, j - 1, memo));
        }
        return memo[i][j];
    }

    public int longestCommonSubsequence2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public int longestCommonSubsequence3(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        int n1 = s1.length(), n2 = s2.length();
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] dp = new int[n2 + 1];
        for (int i = 1; i <= n1; i++) {
            int prev = 0;
            for (int j = 1; j <= n2; j++) {
                int tmp = dp[j];
                if (str1[i - 1] == str2[j - 1]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = tmp;
            }
        }
        return dp[n2];
    }


}
