package com.vika.way.pre.algorithm.alg.sort;



import com.vika.way.pre.algorithm.alg.common.RandomArray;

import java.util.Arrays;

public class InsertSort {

    public void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0 && nums[j] > temp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }

    public void insertSortBinary(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int target = nums[i];
            int left = 0, right = i;
            int mid;
            while (left < right) {
                mid = (left + right) >>> 1;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            for (int j = i; j > left; j--) {
                nums[j] = nums[j - 1];
            }
            nums[left] = target;
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        int[] nums = RandomArray.randomArray(n, n);
        int[] copy = nums.clone();
        Arrays.sort(copy);
        InsertSort insertSort=new InsertSort();
        insertSort.insertSort(nums);
        System.out.println(Arrays.equals(copy,nums));
    }
}
