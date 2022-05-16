package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.Arrays;

public class S503NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = -1;
            for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
                if (nums[i] < nums[j]) {
                    next[i] = nums[j];
                    break;
                }
            }
        }
        return next;
    }

    public int[] nextGreaterElements1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int n = nums.length;
        int[] next = new int[n];
        if (n == 0) {
            return next;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        int[] stackIndex = new int[n];
        int top = 0;
        for (int k = maxIndex + 1; k <= maxIndex + n; k++) {
            int i = k % n;
            while (top > 0 && nums[stackIndex[top - 1]] < nums[i]) {
                next[stackIndex[--top]] = nums[i];
            }
            stackIndex[top++] = i;
        }
        while (top > 0) {
            next[stackIndex[--top]] = -1;
        }
        return next;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        if (n == 0) {
            return next;
        }
        int[] stackIndex = new int[n];
        int top = 0;
        for (int k = 0; k < n * 2; k++) {
            int i = k % n;
            while (top > 0 && nums[stackIndex[top - 1]] < nums[i]) {
                next[stackIndex[--top]] = nums[i];
            }
            //超出 cols 的那部分，无需再次入栈,遍历第 2 遍，是为了让栈弹出，即为更大值存在于其前面的元素
            if (k < n) {
                stackIndex[top++] = i;
            }
        }
        while (top > 0) {
            next[stackIndex[--top]] = -1;
        }
        return next;
    }

    public int[] nextGreaterElements3(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        int[] stackIndex = new int[n];
        int top = 0;
        for (int k = 2 * n - 1; k >= 0; k--) {
            int i = k % n;
            while (top > 0 && nums[stackIndex[top - 1]] <= nums[i]) {
                top--;
            }
            next[i] = top > 0 ? nums[stackIndex[top - 1]] : -1;
            stackIndex[top++] = i;
        }
        return next;
    }

    public static void main(String[] args) {
        S503NextGreaterElementII solution = new S503NextGreaterElementII();
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(solution.nextGreaterElements2(nums)));
    }
}
