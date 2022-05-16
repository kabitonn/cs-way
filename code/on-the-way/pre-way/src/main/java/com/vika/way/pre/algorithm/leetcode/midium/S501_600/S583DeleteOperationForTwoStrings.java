package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

public class S583DeleteOperationForTwoStrings {

    public int minDistance(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

    public int minDistance1(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[] dp = new int[n2 + 1];
        for (int i = 0; i <= n1; i++) {
            int prev = 0;
            for (int j = 0; j <= n2; j++) {
                int tmp = dp[j];
                if (i == 0 || j == 0) {
                    dp[j] = i + j;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
                }
                prev = tmp;
            }
        }
        return dp[n2];
    }

    public int minDistance2(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 == 0) {
            return n2;
        } else if (n2 == 0) {
            return n1;
        }
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
        return n1 + n2 - 2 * dp[n2];
    }


}
