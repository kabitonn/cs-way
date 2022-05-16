package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S554BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        int total = 0;
        for (int n : wall.get(0)) {
            total += n;
        }
        int size = 0;
        for (List<Integer> line : wall) {
            size = Math.max(size, total - line.get(line.size() - 1));
        }
        int[] bucket = new int[size + 1];
        int maxCount = 0;
        for (List<Integer> line : wall) {
            int sum = 0;
            for (int i = 0; i < line.size() - 1; i++) {
                sum += line.get(i);
                bucket[sum]++;
                maxCount = Math.max(maxCount, bucket[sum]);
            }
        }
        return wall.size() - maxCount;
    }

    public int leastBricks0(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        int[] bucket = new int[65535];
        int maxCount = 0;
        for (List<Integer> line : wall) {
            int s = 0;
            for (int i = 0; i < line.size() - 1; i++) {
                s += line.get(i);
                bucket[s]++;
                maxCount = Math.max(maxCount, bucket[s]);
            }
        }
        return wall.size() - maxCount;
    }

    public int leastBricks1(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        Map<Integer, Integer> mapCount = new HashMap<>();
        int maxCount = 0;
        for (List<Integer> line : wall) {
            int sum = 0;
            for (int i = 0; i < line.size() - 1; i++) {
                sum += line.get(i);
                int frequence = mapCount.getOrDefault(sum, 0) + 1;
                mapCount.put(sum, frequence);
                maxCount = Math.max(maxCount, frequence);
            }
        }
        return wall.size() - maxCount;
    }
}
