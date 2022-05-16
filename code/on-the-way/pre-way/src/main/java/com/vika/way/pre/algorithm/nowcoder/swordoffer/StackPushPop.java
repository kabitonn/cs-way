package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.Stack;

public class StackPushPop {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null && popA == null) {
            return true;
        }
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        int pop = 0;
        int n = pushA.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && pop < n && stack.peek() == popA[pop]) {
                stack.pop();
                pop++;
            }
        }
        return stack.isEmpty();
    }
}
