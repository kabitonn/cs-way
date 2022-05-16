package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

public class S198HouseRobber {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }
        int[] max = new int[len];
        for (int i = 0; i < len; i++) {
            if (i < 2) {
                max[i] = nums[i];
            } else if (i < 3) {
                max[i] = nums[i] + nums[i - 2];
            } else {
                max[i] = Math.max(max[i - 2] + nums[i], max[i - 3] + nums[i]);
            }
        }
        return Math.max(max[len - 1], max[len - 2]);
    }

    public int rob0(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] max = new int[len + 1];
        max[0] = 0;
        max[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            max[i] = Math.max(max[i - 1], max[i - 2] + nums[i - 1]);
        }
        return max[len];
    }

    public int rob01(int[] nums) {
        int pre = 0, cur = 0;
        for (int n : nums) {
            int tmp = cur;
            cur = Math.max(pre + n, cur);
            pre = tmp;
        }
        return cur;
    }

    public int rob1(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int n : nums) {
            int tmp = sum1;
            sum1 = sum2 + n;
            sum2 = Math.max(tmp, sum2);
        }

        return Math.max(sum1, sum2);
    }

    public int rob2(int[] nums) {
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sumEven += nums[i];
                sumEven = Math.max(sumOdd, sumEven);
            } else {
                sumOdd += nums[i];
                sumOdd = Math.max(sumOdd, sumEven);
            }
        }
        return Math.max(sumOdd, sumEven);
    }

}
