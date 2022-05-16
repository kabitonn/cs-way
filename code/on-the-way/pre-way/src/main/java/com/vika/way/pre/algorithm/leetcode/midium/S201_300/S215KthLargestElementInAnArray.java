package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.Arrays;
import java.util.PriorityQueue;

public class S215KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        S215KthLargestElementInAnArray solution = new S215KthLargestElementInAnArray();
        System.out.println(solution.findKthLargest3(nums, 9));
    }

    public int findKthLargest0(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int pivot = quickPass(nums, left, right);
            if (pivot == target) {
                break;
            } else if (pivot > target) {
                right = pivot - 1;
            } else if (pivot < target) {
                left = pivot + 1;
            }
        }
        return nums[target];
    }

    public int quickPass(int[] nums, int left, int right) {
        int temp = nums[left];
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
        return left;
    }

    public int findKthLargest1(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
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

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (a, b) -> (b - a));
        for (int n : nums) {
            maxHeap.add(n);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public int findKthLargest2_1(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len);
        for (int n : nums) {
            minHeap.add(n);
        }
        for (int i = 0; i < len - k; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public int findKthLargest2_2(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public int findKthLargest2_3(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            minHeap.add(nums[i]);
            minHeap.poll();
        }
        return minHeap.peek();
    }


    public int findKthLargest3(int[] nums, int k) {
        buildMaxHeap(nums);
        int len = nums.length;
        int unsorted = len;
        //剩余未排序数量
        for (int i = 0; i < k - 1; i++) {
            swap(nums, 0, --unsorted);
            adjustMax(nums, 0, unsorted);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] arr) {
        int len = arr.length;
        for (int i = len / 2; i >= 0; i--) {
            adjustMax(arr, i, len);
        }
    }

    public void adjustMax(int[] arr, int node, int size) {
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        while (left < size) {
            int large = right < size && arr[right] > arr[left] ? right : left;
            if (arr[node] >= arr[large]) {
                break;
            }
            swap(arr, node, large);
            node = large;
            left = 2 * node + 1;
            right = 2 * node + 2;
        }
    }

    public int findKthLargest4(int[] nums, int k) {
        buildMinHeap(nums);
        int len = nums.length;
        int unsorted = len;
        //剩余未排序数量
        for (int i = k; i < len; i++) {
            swap(nums, 0, --unsorted);
            adjustMin(nums, 0, unsorted);
        }
        return nums[0];
    }

    public void buildMinHeap(int[] arr) {
        int len = arr.length;
        for (int i = len / 2; i >= 0; i--) {
            adjustMin(arr, i, len);
        }
    }

    public void adjustMin(int[] arr, int node, int size) {
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        while (left < size) {
            int small = right < size && arr[right] < arr[left] ? right : left;
            if (arr[node] <= arr[small]) {
                break;
            }
            swap(arr, node, small);
            node = small;
            left = 2 * node + 1;
            right = 2 * node + 2;
        }
    }
}
