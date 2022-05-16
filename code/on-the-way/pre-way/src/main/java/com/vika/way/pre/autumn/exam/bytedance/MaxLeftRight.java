package com.vika.way.pre.autumn.exam.bytedance;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author tangjiawei
 * @Date 2020/9/6
 */
public class MaxLeftRight {

    public long maxLeftRight(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                l[i] = 0;
            } else {
                l[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 1; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                l[i] = 0;
            } else {
                l[i] = stack.peek();
            }
            stack.push(i);
        }
        long max = Long.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, (long) l[i] * (long) r[i]);
        }
        return max;
    }

    @Test
    public void test() {
        int[] nums = {0, 5, 4, 3, 4, 5};
        long max = maxLeftRight(nums);
        System.out.println(max);
    }
}
