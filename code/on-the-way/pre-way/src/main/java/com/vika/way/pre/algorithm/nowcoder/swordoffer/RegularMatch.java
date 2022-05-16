package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import org.junit.Test;

public class RegularMatch {
    public boolean match(char[] str, char[] pattern) {
        return match(str, pattern, 0, 0);
    }

    public boolean match(char[] str, char[] p, int i, int j) {
        if (i == str.length && j == p.length) {
            return true;
        } else if (j == p.length) {
            return false;
        }
        boolean next = (j < p.length - 1 && p[j + 1] == '*');
        if (next) {
            if (i < str.length && (p[j] == '.' || str[i] == p[j])) {
                return match(str, p, i, j + 2) || match(str, p, i + 1, j);
            } else {
                return match(str, p, i, j + 2);
            }
        } else {
            if (i < str.length && (p[j] == '.' || str[i] == p[j])) {
                return match(str, p, i + 1, j + 1);
            } else {
                return false;
            }
        }
    }

    public boolean match(char[] str, int i, char[] p, int j) {
        if (j == p.length) {
            return i == str.length;
        }
        boolean firstMatch = i < str.length && (p[j] == '.' || str[i] == p[j]);
        boolean next = (j < p.length - 1 && p[j + 1] == '*');
        if (next) {
            return match(str, i, p, j + 2) || (firstMatch && match(str, i + 1, p, j));
        } else {
            return firstMatch && match(str, i + 1, p, j + 1);
        }
    }

    public boolean match1(char[] s, char[] p) {
        if (s == null || p == null) {
            return false;
        }
        s = (" " + String.valueOf(s)).toCharArray();
        p = (" " + String.valueOf(p)).toCharArray();
        int m = s.length, n = p.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        //长度i, j 的两串是否匹配
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s[i - 1] == p[j - 1] || p[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p[j - 1] == '*') {
                    if (s[i - 1] != p[j - 2] && p[j - 2] != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean match2(char[] s, char[] p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length, n = p.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) {
                    continue;
                }
                boolean firstMatch = i < m && j < n && (s[i] == p[j] || p[j] == '.');
                if (j + 1 < n && p[j + 1] == '*') {
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    @Test
    public void test() {
        boolean match = match2("a".toCharArray(), ".zz*".toCharArray());
        System.out.println(match);
    }
}
