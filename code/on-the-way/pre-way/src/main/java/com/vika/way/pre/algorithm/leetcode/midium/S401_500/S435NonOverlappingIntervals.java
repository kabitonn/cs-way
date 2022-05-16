package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.Arrays;
import java.util.Comparator;

public class S435NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int i = 0, j = 1;
        int n = intervals.length;
        int count = 0;
        while (j < n) {
            if (intervals[j][0] < intervals[i][1]) {
                if (intervals[j][1] < intervals[i][1]) {
                    i = j;
                }
                count++;
            } else {
                i = j;
            }
            j++;
        }
        return count;
    }

    public int eraseOverlapIntervals_1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int count = 1;
        int n = intervals.length;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (intervals[j][0] >= intervals[i][1]) {
                count++;
                i = j;
            } else if (intervals[j][1] < intervals[i][1]) {
                i = j;
            }
        }
        return n - count;
    }

    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int count = 1;
        int n = intervals.length;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (intervals[j][0] >= intervals[i][1]) {
                count++;
                i = j;
            }
        }
        return n - count;
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int n = intervals.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = dp[j];
                    break;
                }
            }
            dp[i]++;
            count = Math.max(dp[i], count);
        }
        return n - count;
    }

    public int eraseOverlapIntervals3(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int n = intervals.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = dp[j];
                    break;
                }
            }
            dp[i] = Math.max(dp[i] + 1, dp[i - 1]);
            count = Math.max(dp[i], count);
        }
        return n - count;
    }
}
