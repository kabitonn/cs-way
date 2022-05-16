package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S334IncreasingTripletSubsequence {

    public static void main(String[] args) {
        S334IncreasingTripletSubsequence solution = new S334IncreasingTripletSubsequence();
        int[] nums = {1, 3, 2, 1, 3};
        System.out.println(solution.increasingTriplet1(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            if (dp[i] >= 3) {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet1(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        int left, right;
        for (int num : nums) {
            left = 0;
            right = len;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num;
            len = left == len ? len + 1 : len;
        }
        return len >= 3;
    }

    public boolean increasingTriplet2(int[] nums) {
        Integer[] seq = new Integer[3];
        for (int num : nums) {
            if (seq[0] == null || seq[0] >= num) {
                seq[0] = num;
            } else if (seq[1] == null || (seq[1] >= num)) {
                seq[1] = num;
            } else if (seq[2] == null || (seq[2] >= num)) {
                seq[2] = num;
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet3(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= first) {
                first = n;
            } else if (n <= second) {
                second = n;
            } else {
                return true;
            }
        }

        return false;
    }
}
