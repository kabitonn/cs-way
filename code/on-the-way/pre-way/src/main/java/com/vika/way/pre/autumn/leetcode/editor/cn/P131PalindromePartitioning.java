//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入:"aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法 
// 👍 352 👎 0


//Java：分割回文串

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new P131PalindromePartitioning().new Solution();
        // TO TEST
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.partition("efe"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition1(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            for (int l = 1; l <= n; l++) {
                for (int i = 0; i <= n - l; i++) {
                    int j = i + l - 1;
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (l < 3 || dp[i + 1][j - 1]);
                }
            }
            return conquer(s, dp, 0);

        }

        public List<List<String>> conquer(String s, boolean[][] dp, int start) {
            List<List<String>> listList = new ArrayList<>();
            if (start == s.length()) {
                listList.add(new ArrayList<>());
                return listList;
            }
            for (int i = start; i < s.length(); i++) {
                if (!dp[start][i]) {
                    continue;
                }
                String left = s.substring(start, i + 1);
                for (List<String> list : conquer(s, dp, i + 1)) {
                    list.add(0, left);
                    listList.add(list);
                }
            }
            return listList;
        }

        public List<List<String>> partition(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            for (int l = 1; l <= n; l++) {
                for (int i = 0; i <= n - l; i++) {
                    int j = i + l - 1;
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (l < 3 || dp[i + 1][j - 1]);
                }
            }
            List<List<String>> listList = new ArrayList<>();
            backtrack(listList, new ArrayList<>(), dp, s, 0);
            return listList;
        }

        public void backtrack(List<List<String>> listList, List<String> list, boolean[][] dp, String s, int start) {
            if (start == s.length()) {
                listList.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i < s.length(); i++) {
                if (!dp[start][i]) {
                    continue;
                }
                list.add(s.substring(start, i + 1));
                backtrack(listList, list, dp, s, i + 1);
                list.remove(list.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}