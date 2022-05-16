//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划 
// 👍 946 👎 0


//Java：最长有效括号

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P32LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses1(String s) {
            int left = 0, right = 0;
            char[] chars = s.toCharArray();
            int n = chars.length;
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (chars[i] == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    max = Math.max(max, right * 2);
                } else if (right > left) {
                    left = right = 0;
                }
            }
            left = right = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (chars[i] == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    max = Math.max(max, left * 2);
                } else if (left > right) {
                    left = right = 0;
                }
            }
            return max;
        }

        public int longestValidParentheses(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            int[] dp = new int[n];
            int max = 0;
            for (int i = 1; i < n; i++) {
                if (chars[i] == '(') {
                    continue;
                }
                if (chars[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && chars[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}