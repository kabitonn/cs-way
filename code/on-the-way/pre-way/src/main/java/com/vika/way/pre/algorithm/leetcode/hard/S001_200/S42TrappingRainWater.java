package com.vika.way.pre.algorithm.leetcode.hard.S001_200;

import org.junit.Test;

import java.util.Stack;

public class S42TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int sum = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    sum += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    sum += (rightMax - height[right]);
                }
                right--;
            }
        }
        return sum;
    }


    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            sum += Math.max(min - height[i], 0);
        }
        return sum;
    }

    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int current = 0;
        while (current < n) {
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int dis = current - stack.peek() - 1;
                int min = Math.min(height[current], height[stack.peek()]);
                sum += dis * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }

    @Test
    public void test() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        //int[] height = {5, 2, 1, 2, 1, 5};
        System.out.println(trap(height));
    }
}
