package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.Arrays;

public class S031NextPermutation {

    public static void main(String[] args) {
        S031NextPermutation solution = new S031NextPermutation();
        int[] nums = {1, 2, 3};
        solution.nextPermutation1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int index1 = -1;
        int index2 = -1;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    index1 = i;
                    index2 = j;
                }
            }
        }
        if (index1 == -1) {
            reverse(nums, 0);
        } else {
            swap(nums, index1, index2);
            reverse(nums, index1 + 1);
        }
    }

    public void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i < 0) {
            reverse(nums, 0);
            return;
        }
        int j = i + 1;
        while (j < nums.length && nums[j] > nums[i]) {
            j++;
        }
        j--;
        swap(nums, i, j);
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
