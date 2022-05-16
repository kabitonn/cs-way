package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

public class S209MinimumSizeSubarraySum {

    public static void main(String[] args) {
        S209MinimumSizeSubarraySum solution = new S209MinimumSizeSubarraySum();
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen1(7, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int min = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    if (j - i + 1 < min) {
                        min = j - i + 1;
                        break;
                    }
                }
            }
        }
        return min != nums.length + 1 ? min : 0;
    }

    public int minSubArrayLen0(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int min = nums.length + 1;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = sums[j + 1] - sums[i + 1] + nums[i];
                if (sum >= s) {
                    if (j - i + 1 < min) {
                        min = j - i + 1;
                        break;
                    }
                }
            }
        }
        return min != nums.length + 1 ? min : 0;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int min = nums.length + 1;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = n - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                int sum = sums[mid + 1] - sums[i + 1] + nums[i];
                if (sum < s) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int sum = sums[left + 1] - sums[i + 1] + nums[i];
            if (sum >= s) {
                if (left - i + 1 < min) {
                    min = left - i + 1;
                }
            }
        }
        return min != nums.length + 1 ? min : 0;
    }


    public int minSubArrayLen2(int s, int[] nums) {
        int i = 0, j = 0;
        int min = nums.length + 1;
        int sum = 0;
        while (j < nums.length || sum >= s) {
            if (sum < s) {
                sum += nums[j++];
            } else {
                min = Math.min(j - i, min);
                sum -= nums[i++];
            }
        }
        return min != nums.length + 1 ? min : 0;
    }

    public int minSubArrayLen3(int s, int[] nums) {
        int i = 0, j = 0;
        int min = nums.length + 1;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= s) {
                min = Math.min(j - i, min);
                sum -= nums[i++];
            }
        }
        return min != nums.length + 1 ? min : 0;
    }
}
