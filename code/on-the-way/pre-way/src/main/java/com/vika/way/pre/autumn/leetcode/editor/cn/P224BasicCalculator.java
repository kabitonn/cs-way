//实现一个基本的计算器来计算一个简单的字符串表达式的值。 
//
// 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格 。 
//
// 示例 1: 
//
// 输入: "1 + 1"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: " 2-1 + 2 "
//输出: 3 
//
// 示例 3: 
//
// 输入: "(1+(4+5+2)-3)+(6+8)"
//输出: 23 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学 
// 👍 231 👎 0


//Java：基本计算器

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P224BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new P224BasicCalculator().new Solution();
        System.out.println(solution.calculate("1 + 1"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            List<String> list = infixToSuffix(s);

            return evalRPN(list);
        }

        int evalRPN(List<String> tokens) {
            Stack<Integer> stack = new Stack<>();
            int num1, num2;
            for (String s : tokens) {
                switch (s) {
                    case "+":
                        num2 = stack.pop();
                        num1 = stack.pop();
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        num2 = stack.pop();
                        num1 = stack.pop();
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        num2 = stack.pop();
                        num1 = stack.pop();
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        num2 = stack.pop();
                        num1 = stack.pop();
                        stack.push(num1 / num2);
                        break;
                    default:
                        stack.push(Integer.parseInt(s));
                        break;
                }
            }
            return stack.pop();
        }

        List<String> infixToSuffix(String s) {
            List<String> list = new ArrayList<>();
            Stack<Character> opStack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {

                } else if (c >= '0' && c <= '9') {
                    StringBuilder num = new StringBuilder();
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        num.append(s.charAt(i++));
                    }
                    i--;
                    list.add(num.toString());
                } else if (c == '(') {
                    opStack.push(c);
                } else if (c == ')') {
                    while (!opStack.isEmpty() && opStack.peek() != '(') {
                        list.add("" + opStack.pop());
                    }
                    opStack.pop();
                } else {
                    while (!opStack.isEmpty() && priority(opStack.peek()) >= priority(c)) {
                        list.add("" + opStack.pop());
                    }
                    opStack.push(c);
                }
            }
            while (!opStack.isEmpty()) {
                list.add("" + opStack.pop());
            }
            return list;
        }

        int priority(char c) {
            if (c == '*' || c == '/') {
                return 2;
            } else if (c == '+' || c == '-') {
                return 1;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}