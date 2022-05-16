package com.vika.way.pre.algorithm.leetcode.hard.S001_200;

public class S010RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        //只有长度大于 2 的时候，才考虑 *
        if (p.length() >= 2 && p.charAt(1) == '*') {
            //两种情况
            //pattern 直接跳过两个字符。表示 * 前边的字符出现 0 次
            //pattern 不变，例如 s = aa ，pattern = a*，第一个 a 匹配，然后 s 的第二个 a 接着和 pattern 的第一个 a 进行匹配。表示 * 用前一个字符替代。
            return (isMatch(s, p.substring(2)) ||
                (firstMatch && isMatch(s.substring(1), p)));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public boolean isMatch1(String text, String pattern) {
        // 多一维的空间，因为求 dp[len - 1][j] 的时候需要知道 dp[len][j] 的情况，
        // 多一维的话，就可以把 对 dp[len - 1][j] 也写进循环了
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        // dp[len][len] 代表两个空串是否匹配了，"" 和 "" ，当然是 true 了。
        dp[text.length()][pattern.length()] = true;
        // 从 len 开始减少
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length(); j >= 0; j--) {
                // dp[text.length()][pattern.length()] 已经进行了初始化
                if (i == text.length() && j == pattern.length()) {
                    continue;
                }
                boolean firstMatch = (i < text.length() && j < pattern.length()
                    && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public boolean isMatch2(String text, String pattern) {
        // 多一维的空间，因为求 dp[len - 1][j] 的时候需要知道 dp[len][j] 的情况，
        // 多一维的话，就可以把 对 dp[len - 1][j] 也写进循环了
        boolean[][] dp = new boolean[2][pattern.length() + 1];
        dp[text.length() % 2][pattern.length()] = true;

        // 从 len 开始减少
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length(); j >= 0; j--) {
                if (i == text.length() && j == pattern.length()) {
                    continue;
                }
                boolean firstMatch = (i < text.length() && j < pattern.length()
                    && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i % 2][j] = dp[i % 2][j + 2] || firstMatch && dp[(i + 1) % 2][j];
                } else {
                    dp[i % 2][j] = firstMatch && dp[(i + 1) % 2][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
