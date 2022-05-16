package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.Arrays;

public class S213HouseRobberII {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }
        int sum1 = myRob(Arrays.copyOfRange(nums, 0, len - 1));
        int sum2 = myRob(Arrays.copyOfRange(nums, 1, len));
        return Math.max(sum1, sum2);
    }

    public int rob01(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }
        int[] max1 = new int[len];
        int[] max2 = new int[len + 1];
        max1[1] = nums[0];
        for (int i = 2; i < len; i++) {
            max1[i] = Math.max(max1[i - 2] + nums[i - 1], max1[i - 1]);
        }
        for (int i = 2; i <= len; i++) {
            max2[i] = Math.max(max2[i - 2] + nums[i - 1], max2[i - 1]);
        }
        return Math.max(max1[len - 1], max2[len]);
    }

    public int rob1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }
        int[] max1 = new int[len + 1];
        int[] max2 = new int[len + 1];
        for (int i = 2; i <= len; i++) {
            max1[i] = Math.max(max1[i - 2] + nums[i - 2], max1[i - 1]);
            max2[i] = Math.max(max2[i - 2] + nums[i - 1], max2[i - 1]);
        }
        return Math.max(max1[len], max2[len]);
    }

    public int myRob(int[] nums) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = sum1;
            sum1 = sum2 + nums[i];
            sum2 = Math.max(sum2, tmp);
        }
        return Math.max(sum1, sum2);
    }

    public int myRob0(int[] nums) {
        int pre = 0, cur = 0;
        for (int n : nums) {
            int tmp = cur;
            cur = Math.max(pre + n, cur);
            pre = tmp;
        }
        return cur;
    }
}
