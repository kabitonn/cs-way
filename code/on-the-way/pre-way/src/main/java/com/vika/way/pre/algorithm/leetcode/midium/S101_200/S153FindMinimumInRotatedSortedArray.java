package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

public class S153FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        S153FindMinimumInRotatedSortedArray solution = new S153FindMinimumInRotatedSortedArray();
        int[] nums = {2, 1};
        System.out.println(solution.findMin(nums));
    }

    public int findMin(int[] nums) {
        int bias = getBiasByMax(nums);
        return nums[bias];
    }

    public int getBiasByMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int getBiasByMax(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= nums[left]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (right + 1) % nums.length;
    }
}
