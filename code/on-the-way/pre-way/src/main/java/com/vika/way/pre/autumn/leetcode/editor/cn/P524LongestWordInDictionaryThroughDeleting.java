//给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符
//串。如果答案不存在，则返回空字符串。 
//
// 示例 1: 
//
// 
//输入:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//输出: 
//"apple"
// 
//
// 示例 2: 
//
// 
//输入:
//s = "abpcplea", d = ["a","b","c"]
//
//输出: 
//"a"
// 
//
// 说明: 
//
// 
// 所有输入的字符串只包含小写字母。 
// 字典的大小不会超过 1000。 
// 所有输入的字符串长度不会超过 1000。 
// 
// Related Topics 排序 双指针 
// 👍 89 👎 0


//Java：通过删除字母匹配到字典里最长单词

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.List;

public class P524LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new P524LongestWordInDictionaryThroughDeleting().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> d) {
            d.sort((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length());
            for (String str : d) {
                if (isSubSequence(str, s)) {
                    return str;
                }
            }
            return "";
        }

        public boolean isSubSequence(String s, String t) {
            if (s.length() > t.length()) {
                return false;
            } else if (s.length() == 0) {
                return true;
            }
            int index = 0;
            for (char c : t.toCharArray()) {
                if (c == s.charAt(index)) {
                    index++;
                    if (index == s.length()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}