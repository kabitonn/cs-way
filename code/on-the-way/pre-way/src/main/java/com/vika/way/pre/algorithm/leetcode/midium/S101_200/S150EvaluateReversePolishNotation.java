package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class S150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Set<String> op = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> stack = new Stack<>();
        int op1, op2, r = 0;
        for (String s : tokens) {
            if (op.contains(s)) {
                op2 = stack.pop();
                op1 = stack.pop();
                switch (s.charAt(0)) {
                    case '+':
                        r = op1 + op2;
                        break;
                    case '-':
                        r = op1 - op2;
                        break;
                    case '*':
                        r = op1 * op2;
                        break;
                    case '/':
                        r = op1 / op2;
                        break;
                    default:
                        break;
                }
                stack.push(r);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        int result = stack.pop();
        return result;
    }

    public int evalRPN1(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int op1, op2, r = 0;
        for (String s : tokens) {
            if ("+".equals(s)) {
                op2 = stack.pop();
                stack.push(stack.pop() + op2);
            } else if ("-".equals(s)) {
                op2 = stack.pop();
                stack.push(stack.pop() - op2);
            } else if ("*".equals(s)) {
                op2 = stack.pop();
                stack.push(stack.pop() * op2);
            } else if ("/".equals(s)) {
                op2 = stack.pop();
                stack.push(stack.pop() / op2);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        int result = stack.pop();
        return result;
    }
}
