package com.vika.way.pre.autumn.exam.bytedance;

import org.junit.Test;

/**
 * @Author tangjiawei
 * @Date 2020/9/6
 */
public class SubArrayCircle {

    public long maxSubArraySum(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        long max = Integer.MIN_VALUE;
        long sum = 0;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (sum < 0) {
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(max, sum);
        }
        if (m <= 1) {
            return max;
        }
        long preMaxSum = 0, preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            preMaxSum = Math.max(preMaxSum, preSum);
        }
        long postMaxSum = 0, postSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            postSum += nums[i];
            postMaxSum = Math.max(postMaxSum, postSum);
        }
        max = Math.max(max, Math.max(preMaxSum + postMaxSum, preMaxSum + postMaxSum + total * (m - 2)));
        return max;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, -9, 2, 4};
        long max = maxSubArraySum(nums, 3);
        System.out.println(max);
    }
}
