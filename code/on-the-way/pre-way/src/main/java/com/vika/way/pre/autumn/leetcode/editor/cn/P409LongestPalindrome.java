//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 225 👎 0


//Java：最长回文串

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P409LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new P409LongestPalindrome().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int len = 0;
            boolean odd = false;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                len = len + entry.getValue() / 2 * 2;
            }
            if (len < s.length()) {
                len ++;
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}