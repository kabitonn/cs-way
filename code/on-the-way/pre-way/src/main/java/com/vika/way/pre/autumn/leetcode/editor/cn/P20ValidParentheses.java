//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1725 👎 0


//Java：有效的括号

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Stack;

public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid1(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(c);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.peek() != '(') {
                            return false;
                        }
                        stack.pop();
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.peek() != '[') {
                            return false;
                        }
                        stack.pop();
                        break;
                    case '}':
                        if (stack.isEmpty() || stack.peek() != '{') {
                            return false;
                        }
                        stack.pop();
                        break;
                    default:
                        break;
                }
            }
            return stack.isEmpty();
        }

        public boolean isValid(String s) {
            char[] stack = new char[s.length()];
            int top = 0;
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                        stack[top++] = c;
                        break;
                    case ')':
                        if (top == 0 || stack[top - 1] != '(') {
                            return false;
                        }
                        top--;
                        break;
                    case ']':
                        if (top == 0 || stack[top - 1] != '[') {
                            return false;
                        }
                        top--;
                        break;
                    case '}':
                        if (top == 0 || stack[top - 1] != '{') {
                            return false;
                        }
                        top--;
                        break;
                    default:
                        break;
                }
            }
            return top == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}