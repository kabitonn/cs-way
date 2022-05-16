package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.Arrays;
import java.util.Random;

public class S497RandomPointInNonOverlappingRectangles_1 {

    int[][] rects;
    Random random;
    int[] areaSum;

    public S497RandomPointInNonOverlappingRectangles_1(int[][] rects) {
        this.rects = rects;
        this.random = new Random();
        this.areaSum = new int[rects.length];
        int sum = 0;
        int i = 0;
        for (int[] rect : rects) {
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            areaSum[i++] = sum;
        }
    }

    public int[] pick() {
        int target = random.nextInt(areaSum[areaSum.length - 1]);
        int left = 0, right = areaSum.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (areaSum[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int[] rect = rects[left];
        int px = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int py = rect[1] + random.nextInt(rect[3] - rect[1] + 1);
        return new int[]{px, py};
    }

    public int[] pick1() {
        int target = random.nextInt(areaSum[areaSum.length - 1]);
        int left = 0, right = areaSum.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (areaSum[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int pos = left != 0 ? target - areaSum[left - 1] : target;
        int[] rect = rects[left];
        int px = rect[0] + pos % (rect[2] - rect[0] + 1);
        int py = rect[1] + pos / (rect[2] - rect[0] + 1);
        return new int[]{px, py};
    }

    public static void main(String[] args) {
        int[][] rects = {{-2, -2, -1, -1}, {1, 0, 3, 1}};
        S497RandomPointInNonOverlappingRectangles_1 solution = new S497RandomPointInNonOverlappingRectangles_1(rects);
        int pickNum = 10;
        for (int i = 0; i < pickNum; i++) {
            System.out.println(Arrays.toString(solution.pick()));
        }
    }
}
