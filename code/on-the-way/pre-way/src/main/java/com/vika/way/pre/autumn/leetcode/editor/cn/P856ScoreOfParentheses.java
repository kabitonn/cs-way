//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
// Related Topics 栈 字符串 
// 👍 125 👎 0


//Java：括号的分数

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Stack;

public class P856ScoreOfParentheses {
    public static void main(String[] args) {
        Solution solution = new P856ScoreOfParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scoreOfParentheses1(String S) {
            Stack<Integer> stack = new Stack<>();
            int sum = 0;
            for (char c : S.toCharArray()) {
                if (c == '(') {
                    stack.push(sum);
                    sum = 0;
                } else {
                    sum = stack.peek() + Math.max(2 * sum, 1);
                    stack.pop();
                }
            }
            return sum;
        }

        public int scoreOfParentheses(String S) {
            int level = 0;
            int sum = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '(') {
                    level++;
                } else {
                    level--;
                }
                if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') {
                    sum += (1 << level);
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}