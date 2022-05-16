//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4245 👎 0


//Java：无重复字符的最长子串

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring1(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int n = s.length();
            int max = 0;
            for (int i = 0; i < n; i++) {
                Set<Character> set = new HashSet<>();
                int j = i;
                for (; j < n; j++) {
                    if (set.contains(s.charAt(j))) {
                        break;
                    }
                    set.add(s.charAt(j));
                }
                int l = j - i;
                max = Math.max(max, l);
            }
            return max;
        }

        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int n = s.length();
            int max = 0;
            Map<Character, Integer> map = new HashMap<>();
            int i = 0, j = 0;
            while (j < n) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    i = Math.max(i, map.get(c));
                }
                map.put(c, ++j);
                max = Math.max(max, j - i);
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}