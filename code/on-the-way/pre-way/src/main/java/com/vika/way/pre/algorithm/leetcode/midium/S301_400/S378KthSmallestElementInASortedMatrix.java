package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S378KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] nums = new int[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[index++] = matrix[i][j];
            }
        }
        Arrays.parallelSort(nums);
        return nums[k - 1];
    }

    public int kthSmallest1_1(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxHeap.add(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }

    public int kthSmallest1_2(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minHeap.add(matrix[i][j]);
            }
        }
        for (int i = 0; i < k - 1; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (left + right) >>> 1;
            int count = countLeqNumber(matrix, n, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    //求count，从右上角往左下角遍历，O(n)
    public int countLeqNumber(int[][] matrix, int n, int value) {
        int i = 0, j = n - 1;
        int count = 0;
        while (j >= 0 && i < n) {
            if (matrix[i][j] <= value) {
                count += j + 1;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
