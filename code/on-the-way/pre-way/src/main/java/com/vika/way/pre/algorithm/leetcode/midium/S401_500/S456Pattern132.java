package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

public class S456Pattern132 {

    // 超时
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean find132pattern1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            for (; j < n - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    break;
                }
            }
            for (int k = j + 1; k < n; k++) {
                if (nums[i] < nums[k] && nums[k] < nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (; i < n - 2; i++) {
                if (nums[i] < nums[i + 1]) {
                    break;
                }
            }
            int j = i + 1;
            for (; j < n - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    break;
                }
            }
            for (int k = j + 1; k < n; k++) {
                if (nums[i] < nums[k] && nums[k] < nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find132pattern3(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] stack = new int[n];
        int top = 0;
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(nums[i], min[i - 1]);
        }
        for (int j = n - 1; j > 0; j--) {
            if (nums[j] > min[j]) {
                while (top > 0 && stack[top - 1] <= min[j]) {
                    top--;
                }
                if (top > 0 && stack[top - 1] < nums[j]) {
                    return true;
                }
                stack[top++] = nums[j];
            }
        }
        return false;
    }

    public boolean find132pattern4(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] stack = new int[n];
        int top = 0;
        int secondMax = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < secondMax) {
                return true;
            }
            while (top > 0 && nums[i] > stack[top - 1]) {
                secondMax = Math.max(secondMax, stack[--top]);
            }
            stack[top++] = nums[i];
        }
        return false;
    }
}
