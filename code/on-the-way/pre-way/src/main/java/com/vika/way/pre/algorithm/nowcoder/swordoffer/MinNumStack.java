package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.Stack;

public class MinNumStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else if (node <= minStack.peek()) {
            minStack.push(node);
        }
    }

    public void pop() {
        int node = stack.pop();
        if (node == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
