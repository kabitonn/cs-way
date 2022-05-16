package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S227BasicCalculatorII {
    public static void main(String[] args) {
        S227BasicCalculatorII solution = new S227BasicCalculatorII();
        //System.out.println(solution.calculate4("3+2*2"));
        System.out.println(solution.calculate4(" 3/2 "));

    }

    public int calculate0(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int num = 0;
        String str = s + "+";
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                continue;
            }
            if (!nums.isEmpty() && !ops.isEmpty()) {
                char op = ops.peek();
                if (op == '*') {
                    num = nums.pop() * num;
                    ops.pop();
                } else if (op == '/') {
                    num = nums.pop() / num;
                    ops.pop();
                }
            }
            if (nums.isEmpty() || ops.isEmpty() || c == '*' || c == '/') {

            } else {
                char op = ops.pop();
                if (op == '+') {
                    num = nums.pop() + num;
                } else if (op == '-') {
                    num = nums.pop() - num;
                }
            }
            nums.push(num);
            ops.push(c);
            num = 0;
        }
        return nums.pop();
    }

    public int calculate(String s) {
        int[] nums = new int[s.length()];
        char[] ops = new char[s.length()];
        int topNum = 0, topOp = 0;
        int num = 0;
        String str = s + "+";
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                continue;
            }
            char op = c;
            if (topOp != 0) {
                char preOp = ops[topOp - 1];
                if (preOp == '*') {
                    num = nums[--topNum] * num;
                    topOp--;
                } else if (preOp == '/') {
                    num = nums[--topNum] / num;
                    topOp--;
                }
            }
            if (topOp == 0 || op == '*' || op == '/') {

            } else {
                char preOp = ops[--topOp];
                if (preOp == '+') {
                    num = nums[--topNum] + num;
                } else if (preOp == '-') {
                    num = nums[--topNum] - num;
                }
            }
            nums[topNum++] = num;
            ops[topOp++] = op;
            num = 0;
        }
        return nums[--topNum];
    }

    public int calculate1(String s) {
        int[] nums = new int[s.length()];
        int top = 0;
        int num = 0;
        char sign = '+';
        String str = s + '+';
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                continue;
            }
            if (sign == '+') {
                nums[top++] = num;
            } else if (sign == '-') {
                nums[top++] = -num;
            } else if (sign == '*') {
                nums[top - 1] = nums[top - 1] * num;
            } else if (sign == '/') {
                nums[top - 1] = nums[top - 1] / num;
            }
            sign = c;
            num = 0;
        }
        int result = 0;
        for (int i = 0; i < top; i++) {
            result += nums[i];
        }
        return result;
    }

    public int calculate2(String s) {
        int num = 0;
        String str = s + '+';
        int res = 0;
        int[] left = {0};
        char sign = '+';
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                continue;
            }
            res = compute(left, num, sign, res);
            sign = c;
            num = 0;
        }
        return res;
    }

    public int compute(int[] left, int right, char operator, int res) {

        if (operator == '+') {
            res += right;
            left[0] = right;
        }
        if (operator == '-') {
            res -= right;
            left[0] = -right;
        }
        if (operator == '*') {
            res = res - left[0] + left[0] * right;
            left[0] = left[0] * right;
        }
        if (operator == '/') {
            res = res - left[0] + left[0] / right;
            left[0] = left[0] / right;
        }
        return res;
    }

    public int calculate3(String s) {
        List<String> reversePolishNotationToken = infixToSuffix(s);
        System.out.println(reversePolishNotationToken);
        return evalSuffix(reversePolishNotationToken);
    }

    public List<String> infixToSuffix(String s) {
        List<String> list = new ArrayList<>();
        char[] ops = new char[s.length() / 2];
        int top = 0;


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                String num = "";
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num += s.charAt(i++);
                }
                list.add(num);
                i--;
                continue;
            }
            if (c == '(') {
                ops[top++] = c;
            } else if (c == ')') {
                while (top > 0 && ops[top - 1] != '(') {
                    list.add("" + ops[--top]);
                }
                if (top > 0) {
                    --top;
                }
            } else {
                while (top > 0 && priority(c) <= priority(ops[top - 1])) {
                    list.add("" + ops[--top]);
                }
                ops[top++] = c;
            }
        }
        while (top > 0) {
            list.add("" + ops[--top]);
        }
        return list;
    }

    public int evalSuffix(List<String> strs) {
        int[] nums = new int[strs.size() / 2 + 1];
        int top = 0;
        int op2;
        for (String s : strs) {
            if ("+".equals(s)) {
                op2 = nums[--top];
                nums[top - 1] = (nums[top - 1] + op2);
            } else if ("-".equals(s)) {
                op2 = nums[--top];
                nums[top - 1] = (nums[top - 1] - op2);
            } else if ("*".equals(s)) {
                op2 = nums[--top];
                nums[top - 1] = (nums[top - 1] * op2);
            } else if ("/".equals(s)) {
                op2 = nums[--top];
                nums[top - 1] = (nums[top - 1] / op2);
            } else {
                nums[top++] = (Integer.valueOf(s));
            }
        }
        return nums[0];
    }


    private int priority(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        }
        return 0;
    }

    public int calculate4(String s) {
        s=s.replaceAll("\\s*","");
        return expression(s);
    }

    int curPos = 0;

    public int expression(String s) {
        int num1 = term(s);
        while (curPos < s.length() && (s.charAt(curPos) == '+' || s.charAt(curPos) == '-')) {
            char op = s.charAt(curPos++);
            int num2 = term(s);
            if (op == '+') {
                num1 += num2;
            } else {
                num1 -= num2;
            }
        }

        if (curPos < s.length() && s.charAt(curPos) == ')') {
            curPos++;
        }
        return num1;
    }

    public int term(String s) {
        int num1 = factor(s);
        while (curPos < s.length() && (s.charAt(curPos) == '*' || s.charAt(curPos) == '/')) {
            char op = s.charAt(curPos++);
            int num2 = factor(s);
            if (op == '*') {
                num1 *= num2;
            } else {
                num1 /= num2;
            }
        }
        return num1;
    }

    public int factor(String s) {
        if (s.charAt(curPos) == '(') {
            curPos++;
            return expression(s);
        }
        String str = "";
        while (curPos < s.length() && s.charAt(curPos) >= '0' && s.charAt(curPos) <= '9') {
            str += s.charAt(curPos++);
        }
        return Integer.valueOf(str);
    }
}
