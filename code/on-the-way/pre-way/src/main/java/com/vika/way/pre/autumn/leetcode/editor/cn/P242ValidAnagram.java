//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 244 👎 0


//Java：有效的字母异位词

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Arrays;

public class P242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram1(String s, String t) {
            char[] s1 = s.toCharArray();
            char[] t1 = t.toCharArray();
            Arrays.sort(s1);
            Arrays.sort(t1);
            return Arrays.equals(s1, t1);
        }

        public boolean isAnagram(String s, String t) {
            char[] count1 = new char[26];
            char[] count2 = new char[26];
            for (char c : s.toCharArray()) {
                count1[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                count2[c - 'a']++;
            }
            return Arrays.equals(count1, count2);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}