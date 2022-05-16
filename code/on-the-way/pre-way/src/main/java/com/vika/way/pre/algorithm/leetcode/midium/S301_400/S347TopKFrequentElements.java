package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.*;

public class S347TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        S347TopKFrequentElements solution = new S347TopKFrequentElements();
        System.out.println(solution.topKFrequent4(nums, 2));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int n = countMap.size();
        int[][] frequence = new int[n][2];
        int i = 0;
        for (int key : countMap.keySet()) {
            frequence[i][0] = key;
            frequence[i][1] = countMap.get(key);
            i++;
        }
        /*
        Arrays.sort(frequence, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            }
        );
        */
        Arrays.sort(frequence, (o1, o2) -> o2[1] - o1[1]);
        List<Integer> list = new ArrayList<>();
        for (i = 0; i < k; i++) {
            list.add(frequence[i][0]);
        }
        return list;
    }

    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int n = countMap.size();
        int[] frequence = new int[n];
        int i = 0;
        for (int key : countMap.keySet()) {
            frequence[i++] = countMap.get(key);
        }
        Arrays.sort(frequence);
        List<Integer> list = new ArrayList<>();
        int limit = frequence[n - k];
        for (int key : countMap.keySet()) {
            if (countMap.get(key) >= limit) {
                list.add(key);
            }
        }
        return list;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int n = nums.length;
        List<Integer>[] lists = new List[n + 1];
        for (int key : countMap.keySet()) {
            int f = countMap.get(key);
            if (lists[f] == null) {
                lists[f] = new ArrayList<>();
            }
            lists[f].add(key);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length; i >= 0 && list.size() < k; i--) {
            if (lists[i] != null) {
                list.addAll(lists[i]);
            }
        }
        return list;
    }

    public List<Integer> topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countMap.get(o1) - countMap.get(o2);
            }
        });
        for (int key : countMap.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(key);
            } else if (countMap.get(key) > countMap.get(minHeap.peek())) {
                minHeap.poll();
                minHeap.add(key);
            }
        }
        return new ArrayList<>(minHeap);
    }

    public List<Integer> topKFrequent3_1(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countMap.get(o1) - countMap.get(o2);
            }
        });
        for (int key : countMap.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }

    public List<Integer> topKFrequent4(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countMap.get(o2) - countMap.get(o1) > 0 ? 1 : -1;
            }
        });
        treeMap.putAll(countMap);
        List<Integer> list = new ArrayList<>();
        for (int key : treeMap.keySet()) {
            list.add(key);
            if (list.size() == k) {
                break;
            }
        }
        return list;
    }

}
