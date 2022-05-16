package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.Random;
import java.util.TreeMap;

public class S497RandomPointInNonOverlappingRectangles {

    int[][] rects;
    Random random;
    TreeMap<Integer, Integer> area;
    int sumArea;

    public S497RandomPointInNonOverlappingRectangles(int[][] rects) {
        this.rects = rects;
        this.random = new Random();
        area = new TreeMap<>();
        sumArea = 0;
        int i = 0;
        for (int[] rect : rects) {
            area.put(sumArea, i++);
            sumArea += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
        }
    }

    public int[] pick() {
        int r = random.nextInt(sumArea);
        int pos = area.get(area.floorKey(r));
        int[] rect = rects[pos];
        int px = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int py = rect[1] + random.nextInt(rect[3] - rect[1] + 1);
        return new int[]{px, py};
    }

    public int[] pick1() {
        int target = random.nextInt(sumArea);
        int index = area.get(area.floorKey(target));
        int[] rect = rects[index];
        int pos = target - area.floorKey(target);
        int px = rect[0] + pos % (rect[2] - rect[0] + 1);
        int py = rect[1] + pos / (rect[2] - rect[0] + 1);
        return new int[]{px, py};
    }
}
