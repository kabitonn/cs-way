package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155最小栈
 *
 * @author tokabi
 * @date 2019/10/27 20:22
 */
public class MinStack_1 {
    private Deque<Integer> stack = null;

    public MinStack_1() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int min = stack.peek();
            stack.push(x);
            min = x < min ? x : min;
            stack.push(min);
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        int min = stack.pop();
        int top = stack.peek();
        stack.push(min);
        return top;
    }

    public int getMin() {
        return stack.peek();
    }
}