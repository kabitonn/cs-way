package com.vika.way.pre.autumn.interview.tencent;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author tangjiawei
 * @Date 2020/9/1
 */
public class QuickSort {

    public void quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = quickPass(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    public int quickPass(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = {2, 6, 4, 1, 5, 3};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
