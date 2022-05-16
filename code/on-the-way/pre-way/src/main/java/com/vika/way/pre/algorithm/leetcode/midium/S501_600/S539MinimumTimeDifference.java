package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.Arrays;
import java.util.List;

public class S539MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n < 2) {
            return 0;
        }
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            //String[] strs = timePoints.get(i).split(":");
            //times[i] = Integer.valueOf(strs[0]) * 60 + Integer.valueOf(strs[1]);
            String time = timePoints.get(i);
            times[i] = Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3));
        }
        Arrays.sort(times);
        int min = times[0] + 24 * 60 - times[n - 1];
        for (int i = 1; i < n; i++) {
            min = Math.min(times[i] - times[i - 1], min);
        }
        return min;
    }

    public int findMinDifference2(List<String> timePoints) {
        int n = timePoints.size();
        if (n < 2) {
            return 0;
        }
        if (n > 24 * 60) {
            return 0;
        }
        int[] map = new int[24 * 60];
        for (String time : timePoints) {
            int t = Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3));
            if (map[t] != 0) {
                return 0;
            }
            map[t] = 1;
        }
        int first = -1, prev = -1;
        int min = 24 * 60;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                continue;
            }
            if (prev == -1) {
                first = i;
            } else {
                min = Math.min(min, i - prev);
            }
            prev = i;
        }
        min = Math.min(first + 24 * 60 - prev, min);
        return min;
    }
}
