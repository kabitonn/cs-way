//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2639 👎 0


//Java：最长回文子串

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome1(String s) {
            if (s == null) {
                return "";
            }
            String longestStr = "";
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            for (int l = 1; l <= n; l++) {
                for (int i = 0; i <= n - l; i++) {
                    int j = i + l - 1;
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (l < 3 || dp[i + 1][j - 1]);
                    if (dp[i][j] && l > longestStr.length()) {
                        longestStr = s.substring(i, j + 1);
                    }
                }

            }
            return longestStr;
        }

        public String longestPalindrome2(String s) {
            if (s == null) {
                return "";
            }
            int n = s.length();
            int max = 0;
            int start = 0, end = 0;
            for (int c = 0; c < n; c++) {
                int l1 = longestPalindrome(s, c, c);
                int l2 = longestPalindrome(s, c - 1, c);
                int l = Math.max(l1, l2);
                if (l > max) {
                    start = c - l / 2;
                    end = c + (l + 1) / 2;
                    max = l;
                }
            }
            return s.substring(start, end);
        }

        public int longestPalindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }

        public String longestPalindrome(String s) {
            if (s == null) {
                return "";
            }
            String longestStr = "";
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    int l = j - i + 1;
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (l < 3 || dp[i + 1][j - 1]);
                    if (dp[i][j] && l > longestStr.length()) {
                        longestStr = s.substring(i, j + 1);
                    }
                }
            }
            return longestStr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}