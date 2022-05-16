package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.Arrays;
import java.util.Comparator;

public class S452MinimumNumberOfArrowsToBurstBalloons {


    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int n = points.length;
        int i = 0;
        int count = 0;
        while (i < n) {
            int j = i + 1;
            int right = points[i][1];
            while (j < n && right >= points[j][0]) {
                right = Math.min(right, points[j][1]);
                j++;
            }
            i = j;
            count++;
        }
        return count;
    }

    public int findMinArrowShots_1(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int n = points.length;
        int i = n - 1;
        int count = 0;
        while (i >= 0) {
            int j = i - 1;
            int left = points[i][0];
            while (j >= 0 && left <= points[j][1]) {
                left = Math.max(left, points[j][0]);
                j--;
            }
            i = j;
            count++;
        }
        return count;
    }

    public int findMinArrowShots1(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = points.length;
        int count = 1;
        int right = points[0][1];
        for (int i = 1; i < n; i++) {
            if (points[i][0] <= right) {
                right = Math.min(right, points[i][1]);
            } else {
                count++;
                right = points[i][1];
            }
        }
        return count;
    }

    public int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int n = points.length;
        int count = 1;
        int right = points[0][1];
        for (int i = 1; i < n; i++) {
            if (points[i][0] > right) {
                count++;
                right = points[i][1];
            }
        }
        return count;
    }
}
