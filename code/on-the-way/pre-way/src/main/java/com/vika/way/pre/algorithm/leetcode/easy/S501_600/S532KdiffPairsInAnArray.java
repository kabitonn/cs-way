package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

import java.util.Arrays;

public class S532KdiffPairsInAnArray {

    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] == k) {
                    count++;
                    break;
                } else if (nums[j] - nums[i] > k) {
                    break;
                }
            }
        }
        return count;
    }

    public int findPairs1(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            int target = nums[i] + k;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int findPairs2(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        int i = 0;
        int prev = Integer.MAX_VALUE;
        for (int j = 1; j < n; j++) {
            if (nums[i] == prev || nums[j] - nums[i] > k) {
                i++;
                if (i < j) {
                    j--;
                }
            } else if (nums[j] - nums[i] == k) {
                count++;
                prev = nums[i];
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        S532KdiffPairsInAnArray solution = new S532KdiffPairsInAnArray();
        System.out.println(solution.findPairs1(nums, 2));
    }
}
