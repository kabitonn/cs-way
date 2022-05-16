package com.vika.way.pre.algorithm.leetcode.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S40LeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length <= k) {
            return arr;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int n : arr) {
            maxHeap.offer(n);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[] minArray = new int[k];
        for (int i = 0; i < k; i++) {
            minArray[i] = maxHeap.poll();
        }
        return minArray;
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr == null || arr.length <= k) {
            return arr;
        }
        int target = k - 1;
        quickSelect(arr, target);
        return Arrays.copyOf(arr, k);
    }

    public void quickSelect(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int pivot = quickPass(arr, left, right);
            if (pivot < target) {
                left = pivot + 1;
            } else if (pivot > target) {
                right = pivot - 1;
            } else {
                return;
            }
        }
    }

    public int quickPass(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || k <= 0) {
            return new int[]{};
        }
        if (arr.length <= k) {
            return arr;
        }
        int[] maxHeap = new int[k];
        for (int i = 0; i < k; i++) {
            maxHeap[i] = arr[i];
        }
        buildMaxHeap(maxHeap);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap[0]) {
                maxHeap[0] = arr[i];
                adjustMax(maxHeap, k, 0);
            }
        }
        return maxHeap;
    }

    public void buildMaxHeap(int[] arr) {
        int len = arr.length;
        for (int i = len / 2; i >= 0; i--) {
            adjustMax(arr, len, i);
        }
    }

    public void adjustMax(int[] arr, int size, int node) {
        int left = node * 2 + 1;
        int temp = arr[node];
        while (left < size) {
            int right = left + 1;
            int large = right < size && arr[right] > arr[left] ? right : left;
            if (temp >= arr[large]) {
                break;
            }
            arr[node] = arr[large];
            node = large;
            left = node * 2 + 1;
        }
        arr[node] = temp;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}