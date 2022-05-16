//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回符合要求的最少分割次数。 
//
// 示例: 
//
// 输入:"aab"
//输出: 1
//解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
// Related Topics 动态规划 
// 👍 191 👎 0


//Java：分割回文串 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P132PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new P132PalindromePartitioningIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int n = s.length();
            boolean[][] palindrome = new boolean[n][n];
            for (int l = 1; l <= n; l++) {
                for (int i = 0; i <= n - l; i++) {
                    int j = i + l - 1;
                    palindrome[i][j] = s.charAt(i) == s.charAt(j) && (l < 3 || palindrome[i + 1][j - 1]);
                }
            }
            int[] dp = new int[n];
            for (int i = 1; i < n; i++) {
                if (palindrome[0][i]) {
                    dp[i] = 0;
                    continue;
                }
                dp[i] = i;
                for (int j = 0; j < i; j++) {
                    if (palindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}