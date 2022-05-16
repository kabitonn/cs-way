//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 1422 👎 0


//Java：正则表达式匹配

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P10RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new P10RegularExpressionMatching().new Solution();
        System.out.println(solution.isMatch("aa", "a*"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch1(String s, String p) {
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            boolean firstMath = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
            if (p.length() >= 2 && p.charAt(1) == '*') {
                return (isMatch(s, p.substring(2))) || (firstMath && isMatch(s.substring(1), p));
            } else {
                return firstMath && isMatch(s.substring(1), p.substring(1));
            }
        }

        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[m][n] = true;
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i == m && j == n) {
                        continue;
                    }
                    boolean firstMath = i < m && j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                    if (j + 1 < n && p.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2] || (firstMath && dp[i + 1][j]);
                    } else {
                        dp[i][j] = firstMath && dp[i + 1][j + 1];
                    }
                }
            }
            return dp[0][0];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}