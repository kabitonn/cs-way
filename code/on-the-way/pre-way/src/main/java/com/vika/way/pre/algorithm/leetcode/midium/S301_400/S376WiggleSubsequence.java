package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S376WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j]);
                }
                if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j]);
                }
            }
            up[i]++;
            down[i]++;
        }
        int max = Math.max(up[n - 1], down[n - 1]);
        return max;
    }

    public int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int prevDiff = nums[1] - nums[0];
        int count = prevDiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff != 0 && diff * prevDiff <= 0) {
                count++;
                prevDiff = diff;
            }
        }
        return count;
    }
}
