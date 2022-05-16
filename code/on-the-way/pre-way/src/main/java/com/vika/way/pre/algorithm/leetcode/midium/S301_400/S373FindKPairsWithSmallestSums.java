package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.*;

public class S373FindKPairsWithSmallestSums {

    public static void main(String[] args) {
        S373FindKPairsWithSmallestSums solution = new S373FindKPairsWithSmallestSums();
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        System.out.println(solution.kSmallestPairs1(nums1, nums2, 2));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(k + 1, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int sum1 = o1.get(0) + o1.get(1);
                int sum2 = o2.get(0) + o2.get(1);
                return sum2 - sum1;
            }
        });
        int m = Math.min(nums1.length, k);
        int n = Math.min(nums2.length, k);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxHeap.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return new ArrayList<>(maxHeap);
    }

    public List<List<Integer>> kSmallestPairs0(int[] nums1, int[] nums2, int k) {
        int m = Math.min(nums1.length, k);
        int n = Math.min(nums2.length, k);
        int[][] array = new int[m * n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i * n + j][0] = nums1[i];
                array[i * n + j][1] = nums2[j];
            }
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] + o1[1]) - (o2[0] + o2[1]);
            }
        });
        k = Math.min(k, array.length);
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int[] num = array[i];
            listList.add(new ArrayList<>(Arrays.asList(num[0], num[1])));
        }
        return listList;
    }

    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k + 1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0] + o2[1]) - (o1[0] + o1[1]);
            }
        });
        int m = Math.min(nums1.length, k);
        int n = Math.min(nums2.length, k);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxHeap.add(new int[]{nums1[i], nums2[j]});
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        List<List<Integer>> listList = new ArrayList<>();
        k = Math.min(k, maxHeap.size());
        for (int i = 0; i < k; i++) {
            int[] num = maxHeap.poll();
            listList.add(new ArrayList<>(Arrays.asList(num[0], num[1])));
        }
        return listList;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        int m = Math.min(nums1.length, k);
        int n = Math.min(nums2.length, k);
        if (m == 0 || n == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k * k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] + o1[1]) - (o2[0] + o2[1]);
            }
        });
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minHeap.add(new int[]{nums1[i], nums2[j]});
            }
        }
        List<List<Integer>> listList = new ArrayList<>();
        k = Math.min(k, minHeap.size());
        for (int i = 0; i < k; i++) {
            int[] num = minHeap.poll();
            listList.add(new ArrayList<>(Arrays.asList(num[0], num[1])));
        }
        return listList;
    }

    public List<List<Integer>> kSmallestPairs3(int[] nums1, int[] nums2, int k) {
        int m = Math.min(nums1.length, k);
        int n = Math.min(nums2.length, k);
        if (m == 0 || n == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k * 2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
            }
        });
        for (int i = 0; i < m; i++) {
            minHeap.add(new int[]{i, 0});
        }
        List<List<Integer>> listList = new ArrayList<>();
        k = Math.min(k, m * n);
        for (int i = 0; i < k; i++) {
            int[] index = minHeap.poll();
            listList.add(new ArrayList<>(Arrays.asList(nums1[index[0]], nums2[index[1]])));
            index[1]++;
            if (index[1] < n) {
                minHeap.add(index);
            }
        }
        return listList;
    }
}
