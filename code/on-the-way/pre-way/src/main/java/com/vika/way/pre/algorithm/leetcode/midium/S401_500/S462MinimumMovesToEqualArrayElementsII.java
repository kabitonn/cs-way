package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.Arrays;
import java.util.PriorityQueue;

public class S462MinimumMovesToEqualArrayElementsII {


    public static void main(String[] args) {
        S462MinimumMovesToEqualArrayElementsII solution = new S462MinimumMovesToEqualArrayElementsII();
        int[] nums = {1, 0, 0, 8, 6};
        System.out.println(solution.minMoves2_2(nums));

    }

    public int minMoves2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int target = nums[nums.length / 2];
        int sum = 0;
        for (int n : nums) {
            sum += Math.abs(target - n);
        }
        return sum;
    }

    public int minMoves2_3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int size = (len + 1) / 2;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(size + 1);
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > size) {
                minHeap.poll();
            }
        }
        int target = minHeap.peek();
        int sum = 0;
        for (int n : nums) {
            sum += Math.abs(target - n);
        }
        return sum;
    }

    public int minMoves2_2(int[] nums) {
        int len = nums.length;
        int size = (len + 1) / 2;
        buildMinHeap(nums);
        for (int unsorted = len; unsorted > size; ) {
            swap(nums, 0, --unsorted);
            adjustMin(nums, 0, unsorted);
        }
        int target = nums[0];
        int sum = 0;
        for (int n : nums) {
            sum += Math.abs(target - n);
        }
        return sum;
    }

    public void buildMinHeap(int[] arr) {
        int len = arr.length;
        for (int i = len / 2; i >= 0; i--) {
            adjustMin(arr, i, len);
        }
    }

    public void adjustMin(int[] arr, int node, int size) {
        int left = (node << 1) + 1;
        int right = left + 1;
        while (left < size) {
            int small = right < size && arr[right] < arr[left] ? right : left;
            if (arr[node] <= arr[small]) {
                break;
            }
            swap(arr, small, node);
            node = small;
            left = (node << 1) + 1;
            right = left + 1;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int minMoves2_1(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        while (left < right) {
            sum += nums[right--] - nums[left++];
        }
        return sum;
    }

    public int minMoves2_4(int[] nums) {
        int len = nums.length;
        int k = len / 2;
        int target = quickSelect(nums, 0, len - 1, k);
        int sum = 0;
        for (int n : nums) {
            sum += Math.abs(target - n);
        }
        return sum;
    }

    public int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        swap(nums, left, mid);
        int temp = nums[left];
        int start = left, end = right;
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        if (left < k) {
            return quickSelect(nums, left + 1, end, k);
        } else if (left > k) {
            return quickSelect(nums, start, left - 1, k);
        } else {
            return nums[left];
        }
    }

}
