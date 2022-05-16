//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1241 👎 0


//Java：最长公共前缀

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String s = strs[0];
            int max = s.length();
            for (int i = 1; i < strs.length; i++) {
                max = Math.min(max, maxCommon(s, strs[i]));
            }
            return s.substring(0, max);
        }

        public int maxCommon(String s1, String s2) {
            int n = Math.min(s1.length(), s2.length());
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return i;
                }
            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}