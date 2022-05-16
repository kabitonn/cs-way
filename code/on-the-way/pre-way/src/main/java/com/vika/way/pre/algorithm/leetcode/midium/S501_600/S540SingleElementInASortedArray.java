package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

public class S540SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int i = 0;
        for (; i + 1 < n; i += 2) {
            if (nums[i] != nums[i + 1]) {
                break;
            }
        }
        return nums[i];
    }

    public int singleNonDuplicate1(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int midNum = nums[mid] == nums[mid + 1] ? 1 : 0;
            //左侧数目的奇偶性
            int leftNum = mid - left + 1 + midNum;
            if ((leftNum & 1) == 0) {
                left = mid + midNum + 1;
            } else {
                right = mid - midNum;
            }
        }
        return nums[left];
    }

    public int singleNonDuplicate1_1(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            boolean leftEven = ((mid - left) & 1) == 0;
            if (nums[mid] == nums[mid + 1]) {
                if (leftEven) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (leftEven) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }

    public int singleNonDuplicate2(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if ((mid & 1) != 0) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
