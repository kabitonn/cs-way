package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.*;

public class S436FindRightInterval {


    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 3}, {3, 4}};
        S436FindRightInterval solution = new S436FindRightInterval();
        System.out.println(Arrays.toString(solution.findRightInterval4(intervals)));
    }

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = -1;
            for (int j = 0; j < n; j++) {
                if (intervals[j][0] >= intervals[i][1]) {
                    if (index[i] != -1) {
                        if (intervals[j][0] < intervals[index[i]][0]) {
                            index[i] = j;
                        }
                    } else {
                        index[i] = j;
                    }
                }
            }
        }
        return index;
    }

    public int[] findRightInterval1(int[][] intervals) {
        int n = intervals.length;
        int[] index = new int[n];
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        for (int i = 0; i < n; i++) {
            index[map.get(intervals[i])] = -1;
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] >= intervals[i][1]) {
                    index[map.get(intervals[i])] = map.get(intervals[j]);
                    break;
                }
            }
        }
        return index;
    }

    public int[] findRightInterval2(int[][] intervals) {
        int n = intervals.length;
        int[] index = new int[n];
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        for (int i = 0; i < n; i++) {
            int pos = binarySearch(intervals, intervals[i][1], i + 1, n);
            index[map.get(intervals[i])] = pos != -1 ? map.get(intervals[pos]) : -1;
        }
        return index;
    }

    public int binarySearch(int[][] intervals, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == intervals.length ? -1 : left;
    }

    public int[] findRightInterval3(int[][] intervals) {
        int n = intervals.length;
        int[] index = new int[n];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < n; i++) {
            treeMap.put(intervals[i][0], i);
        }
        for (int i = 0; i < n; i++) {
            Integer pos = treeMap.ceilingKey(intervals[i][1]);
            index[i] = pos != null ? treeMap.get(pos) : -1;
        }
        return index;
    }

    public int[] findRightInterval4(int[][] intervals) {
        int n = intervals.length;
        int[] index = new int[n];
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i], i);
        }
        int[][] endIntervals = Arrays.copyOf(intervals, n);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(endIntervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && endIntervals[i][1] > intervals[j][0]) {
                j++;
            }
            index[map.get(endIntervals[i])] = j != n ? map.get(intervals[j]) : -1;
        }
        return index;
    }

}
