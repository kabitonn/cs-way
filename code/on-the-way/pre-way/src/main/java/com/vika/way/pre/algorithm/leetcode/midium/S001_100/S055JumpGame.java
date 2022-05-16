package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S055JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return true;
        }
        int[] step = new int[len];
        step[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (step[i - 1] < i) {
                return false;
            }
            step[i] = Math.max(i + nums[i], step[i - 1]);
        }
        return step[len - 1] >= len - 1;
    }

    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int len = nums.length;
        int step = 0;
        for (int i = 0; i < len; i++) {
            if (step < i) {
                return false;
            }
            step = Math.max(i + nums[i], step);
        }
        return step >= len - 1;
    }

    public boolean canJump2(int[] nums) {
        if (nums == null) {
            return false;
        }
        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 逐步向前递推
            if (nums[i] + i >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }

}
