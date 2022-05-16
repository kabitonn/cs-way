//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意: 
//字符串长度 和 k 不会超过 104。 
//
// 示例 1: 
//
// 输入:
//s = "ABAB", k = 2
//
//输出:
//4
//
//解释:
//用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2: 
//
// 输入:
//s = "AABABBA", k = 1
//
//输出:
//4
//
//解释:
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 158 👎 0


//Java：替换后的最长重复字符

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P424LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new P424LongestRepeatingCharacterReplacement().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement1(String s, int k) {
            if (s == null) {
                return 0;
            }
            int n = s.length();
            int i = 0;
            int j = 0;
            int max = 0;
            int replaceNum = 0;
            int replaceIndex = -1;
            while (j < n) {
                if (s.charAt(j) == s.charAt(i)) {
                    j++;
                } else if (replaceNum < k) {
                    if (replaceNum == 0) {
                        replaceIndex = j;
                    }
                    replaceNum++;
                    j++;
                } else {
                    max = Math.max(max, j - i);
                    replaceNum = 0;
                    i = replaceIndex == -1 ? j : replaceIndex;
                    j = i + 1;
                }
            }
            if (replaceNum < k) {
                if (i > k - replaceNum) {
                    i -= k - replaceNum;
                } else {
                    i = 0;
                }
            }

            max = Math.max(max, j - i);
            return max;
        }

        public int characterReplacement(String s, int k) {
            if (s == null) {
                return 0;
            }
            Map<Character, Integer> counter = new HashMap<>();
            int max = 0;
            int maxCount = 0;
            for (int j = 0, i = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                counter.put(c, counter.getOrDefault(c, 0) + 1);
                maxCount = Math.max(maxCount, counter.get(c));
                if (j - i + 1 - maxCount > k) {
                    counter.put(s.charAt(i), counter.get(s.charAt(i)) - 1);
                    i++;
                }
                max = Math.max(max, j - i + 1);
            }

            return max;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}