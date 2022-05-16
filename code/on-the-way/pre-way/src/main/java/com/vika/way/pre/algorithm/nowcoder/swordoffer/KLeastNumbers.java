package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length < k) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : input) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        ArrayList<Integer> list = new ArrayList<>(maxHeap);
        return list;
    }

    public ArrayList<Integer> GetKthLeastNumbers(int[] input, int k) {
        if (input == null || input.length < k) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = input.length - 1;
        int target = k - 1;
        while (left <= right) {
            int pivot = quickPass(input, left, right);
            if (pivot < target) {
                left = pivot + 1;
            } else if (pivot > target) {
                right = pivot - 1;
            } else {
                for (int i = 0; i < k; i++) {
                    list.add(input[i]);
                }
                break;
            }
        }
        return list;
    }

    @Test
    public void testQuickPass() {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        List<Integer> list = GetKthLeastNumbers(input, 8);
        System.out.println(list);
    }

    public int quickPass(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }


    public ArrayList<Integer> GetKthLeastNumbers1(int[] input, int k) {
        if (input == null || k == 0 || input.length < k) {
            return new ArrayList<>();
        }
        int[] maxHeap = new int[k];
        for (int i = 0; i < k; i++) {
            maxHeap[i] = input[i];
        }
        buildMaxHeap(maxHeap);
        for (int i = k; i < input.length; i++) {
            if (input[i] < maxHeap[0]) {
                maxHeap[0] = input[i];
                adjustMaxHeap(maxHeap, 0, k);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : maxHeap) {
            list.add(num);
        }
        return list;
    }

    public void buildMaxHeap(int[] nums) {
        int len = nums.length;
        for (int i = len / 2; i >= 0; i--) {
            adjustMaxHeap(nums, i, len);
        }
    }

    public void adjustMaxHeap(int[] nums, int node, int size) {
        int left = node * 2 + 1;
        while (left < size) {
            int right = left + 1;
            int large = right < size && nums[right] > nums[left] ? right : left;
            if (nums[node] >= nums[large]) {
                break;
            }
            swap(nums, node, large);
            node = large;
            left = node * 2 + 1;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
