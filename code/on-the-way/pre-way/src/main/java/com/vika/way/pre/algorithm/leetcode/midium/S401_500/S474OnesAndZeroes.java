package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

public class S474OnesAndZeroes {

    public static void main(String[] args) {
        S474OnesAndZeroes solution = new S474OnesAndZeroes();
        String[] strs = {"0", "11", "1000", "01", "0", "101", "1", "1", "1", "0", "0", "0", "0", "1", "0", "0110101",
            "0", "11", "01", "00", "01111", "0011", "1", "1000", "0", "11101", "1", "0", "10", "0111"};
        int zero = 9, one = 80;
        long startTime = System.currentTimeMillis();
        System.out.println(solution.findMaxForm2(strs, zero, one));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        return dfs(strs, 0, m, n, new Integer[strs.length][m + 1][n + 1]);
    }

    public int dfs(String[] strs, int index, int m, int n, Integer[][][] memo) {
        if (index == strs.length) {
            return 0;
        }
        if (memo[index][m][n] != null) {
            return memo[index][m][n];
        }
        int one = countOne(strs[index]);
        int zero = strs[index].length() - one;
        int sum1 = 0;
        if (m >= zero && n >= one) {
            sum1 = 1 + dfs(strs, index + 1, m - zero, n - one, memo);
        }
        int sum0 = dfs(strs, index + 1, m, n, memo);
        return memo[index][m][n] = Math.max(sum0, sum1);
    }

    public int countOne(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    public int findMaxForm1(String[] strs, int m, int n) {
        int num = strs.length;
        int[] zero = new int[num + 1];
        int[] one = new int[num + 1];
        for (int i = 0; i < num; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zero[i + 1]++;
                }
            }
            one[i + 1] = strs[i].length() - zero[i + 1];
        }
        int[][][] dp = new int[num + 1][m + 1][n + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j < zero[i] || k < one[i]) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], 1 + dp[i - 1][j - zero[i]][k - one[i]]);
                    }
                }
            }
        }
        return dp[num][m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = new int[2];
            for (char c : s.toCharArray()) {
                count[c - '0']++;
            }
            for (int j = m; j >= count[0]; j--) {
                for (int k = n; k >= count[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - count[0]][k - count[1]]);
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm3(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int zero = 0, one = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - zero][k - one]);
                }
            }
        }
        return dp[m][n];
    }

}
