//删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。 
//
// 说明: 输入可能包含了除 ( 和 ) 以外的字符。 
//
// 示例 1: 
//
// 输入: "()())()"
//输出: ["()()()", "(())()"]
// 
//
// 示例 2: 
//
// 输入: "(a)())()"
//输出: ["(a)()()", "(a())()"]
// 
//
// 示例 3: 
//
// 输入: ")("
//输出: [""] 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 251 👎 0


//Java：删除无效的括号

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P301RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new P301RemoveInvalidParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            int len = validLength(s);
            Set<String> set = new HashSet<>();
            generateValidParentheses(set, s.toCharArray(), 0, 0, 0, len, "");
            return new ArrayList<>(set);
        }

        public void generateValidParentheses(Set<String> set, char[] chars, int index, int left, int right, int len, String s) {
            if (s.length() == len && left == right) {
                set.add(s);
                return;
            }
            if (index >= chars.length || s.length() > len) {
                return;
            }
            char c = chars[index++];
            if (c == '(') {
                generateValidParentheses(set, chars, index, left + 1, right, len, s + "(");
                generateValidParentheses(set, chars, index, left, right, len, s);
            } else if (c == ')') {
                if (left > right) {
                    generateValidParentheses(set, chars, index, left, right + 1, len, s + ")");
                }
                generateValidParentheses(set, chars, index, left, right, len, s);
            } else {
                generateValidParentheses(set, chars, index, left, right, len, s + c);
            }
        }

        public int validLength(String s) {
            int len = 0;
            int left = 0, right = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    left++;
                } else if (c == ')') {
                    if (left > 0) {
                        left--;
                        len += 2;
                    }
                } else {
                    len++;
                }
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();
        List<String> list = solution.removeInvalidParentheses("()())()");
        System.out.println(list);
    }
}