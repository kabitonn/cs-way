package com.vika.way.pre.algorithm.alg.sort;



import com.vika.way.pre.algorithm.alg.common.RandomArray;

import java.util.Arrays;

public class BubbleSort {

    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public void bubbleSortFlag(int[] nums) {
        int n = nums.length;
        boolean flag = true;
        for (int i = 1; i < n && flag; i++) {
            flag = false;
            for (int j = 0; j < n - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = true;
                }
            }
        }
    }

    public void bubbleTwoSort(int[] nums) {
        int left = 0, right = nums.length - 1;
        boolean flag = true;
        while (left < right && flag) {
            flag = false;
            for (int i = left; i < right; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    flag = true;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                    flag = true;
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int n = 1000;
        int[] nums = RandomArray.randomArray(n, n);
        int[] copy = nums.clone();
        Arrays.sort(copy);
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(nums);
        System.out.println(Arrays.equals(copy, nums));
    }
}
