package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

public class S162FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int i = 0;
        for (; i < n; i++) {
            if (i == 0) {
                if (n > 1 && nums[i] > nums[i + 1]) {
                    break;
                } else if (n == 1) {
                    break;
                }
            } else if (i == n - 1) {
                if (nums[i] > nums[i - 1]) {
                    break;
                }
            } else {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    break;
                }
            }
        }
        return i;
    }

    public int findPeakElement1(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] > nums[1]) {
            return 0;
        }
        int i = 1;
        for (; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        return 0;
    }

    public int findPeakElement2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public int findPeakElement3(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findPeakElement4(int[] nums) {
        return searchPeak(nums, 0, nums.length - 1);
    }

    public int searchPeak(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return searchPeak(nums, left, mid);
        } else {
            return searchPeak(nums, mid + 1, right);
        }
    }
}
