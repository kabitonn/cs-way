package com.vika.way.pre.algorithm.alg.sort;



import com.vika.way.pre.algorithm.alg.common.RandomArray;

import java.util.Arrays;

public class HeapSort {

    public void heapSortMax(int[] nums) {
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustMax(nums, 0, i);
        }
    }

    public void heapSortMax1(int[] nums) {
        int n = nums.length;
        for (int i = n / 2; i >= 0; i--) {
            adjustMax1(nums, i, n);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustMax1(nums, 0, i);
        }
    }

    public void buildMaxHeap(int[] nums) {
        int size = nums.length;
        for (int i = size / 2; i >= 0; i--) {
            adjustMax(nums, i, size);
        }
    }

    public void adjustMax(int[] nums, int node, int size) {
        int left = node * 2 + 1;
        int right, max;
        while (left < size) {
            right = left + 1;
            max = right < size && nums[right] > nums[left] ? right : left;
            if (nums[node] >= nums[max]) {
                break;
            }
            swap(nums, node, max);
            node = max;
            left = node * 2 + 1;
        }
    }

    public void adjustMax1(int[] nums, int node, int size) {
        int temp = nums[node];
        int left = node * 2 + 1;
        int right, max;
        while (left < size) {
            right = left + 1;
            max = right < size && nums[right] > nums[left] ? right : left;
            if (temp >= nums[max]) {
                break;
            }
            nums[node] = nums[max];
            node = max;
            left = node * 2 + 1;
        }
        nums[node] = temp;
    }

    public void heapSortMin(int[] nums) {
        int n = nums.length;
        for (int i = n / 2; i >= 0; i--) {
            adjustMin(nums, i, n);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustMin(nums, 0, i);
        }
    }

    public void adjustMin(int[] nums, int node, int size) {
        int left = node * 2 + 1;
        int right, min;
        while (left < size) {
            right = left + 1;
            min = right < size && nums[right] < nums[left] ? right : left;
            if (nums[node] <= nums[min]) {
                break;
            }
            swap(nums, node, min);
            node = min;
            left = node * 2 + 1;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int n = 8;
        int[] nums = RandomArray.randomArray(n, n);
        HeapSort sort = new HeapSort();
        sort.heapSortMax1(nums);
        System.out.println(Arrays.toString(nums));
        sort.heapSortMin(nums);
        System.out.println(Arrays.toString(nums));
    }
}
