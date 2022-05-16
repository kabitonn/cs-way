//实现一个基本的计算器来计算一个简单的字符串表达式的值。 
//
// 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 字符串 
// 👍 161 👎 0


//Java：基本计算器 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Stack;

public class P227BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new P227BasicCalculatorIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate1(String s) {
            Stack<Integer> numStack = new Stack<>();
            Stack<Character> opStack = new Stack<>();
            s = s + "+";
            int num = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    continue;
                }
                if (c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                    continue;
                }
                if (!opStack.isEmpty()) {
                    char op = opStack.peek();
                    if (op == '*') {
                        num = numStack.pop() * num;
                        opStack.pop();
                    } else if (op == '/') {
                        num = numStack.pop() / num;
                        opStack.pop();
                    }
                }
                if (!numStack.isEmpty() && !opStack.isEmpty() && c != '*' && c != '/') {
                    char op = opStack.pop();
                    if (op == '+') {
                        num = numStack.pop() + num;
                    } else if (op == '-') {
                        num = numStack.pop() - num;
                    }
                }
                opStack.push(c);
                numStack.push(num);
                num = 0;
            }
            return numStack.pop();
        }

        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            s = s + '+';
            char sign = '+';
            int num = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    continue;
                }
                if (c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                    continue;
                }
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
            int sum = 0;
            for (int n : stack) {
                sum += n;
            }
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}