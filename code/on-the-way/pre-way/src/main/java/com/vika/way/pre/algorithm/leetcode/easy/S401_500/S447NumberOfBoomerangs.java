package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import java.util.HashMap;
import java.util.Map;

public class S447NumberOfBoomerangs {

    public static void main(String[] args) {
        S447NumberOfBoomerangs solution = new S447NumberOfBoomerangs();
        //int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        int[][] points = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        System.out.println(solution.numberOfBoomerangs2(points));

    }

    public int numberOfBoomerangs2(int[][] points) {
        int num = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getDistance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
                num += (map.get(distance) - 1) * 2;
            }
            map.clear();
        }
        return num;
    }

    public int numberOfBoomerangs1(int[][] points) {
        int num = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getDistance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (int key : map.keySet()) {
                if (map.get(key) != 1) {
                    int n = map.get(key);
                    num += (n) * (n - 1);
                }
            }
            map.clear();
        }
        return num;
    }

    public int numberOfBoomerangs0(int[][] points) {
        int num = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    num += isEqualDistance(points[i], points[j], points[k]);
                }
            }
        }
        return num;
    }


    public int isEqualDistance(int[] point1, int[] point2, int[] point3) {
        int distance1 = getDistance(point1, point2);
        int distance2 = getDistance(point1, point3);
        int distance3 = getDistance(point2, point3);
        if (distance1 == distance2 || distance1 == distance3 || distance2 == distance3) {
            return 2;
        }
        return 0;
    }

    public int numberOfBoomerangs(int[][] points) {
        int num = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    if (getDistance(points[i], points[j]) == getDistance(points[i], points[k])) {
                        num += 1;
                    }
                }
            }
        }

        return num;
    }


    public int getDistance(int[] point1, int[] point2) {
        int distance = 0;
        for (int i = 0; i < point1.length; i++) {
            distance += (point1[i] - point2[i]) * (point1[i] - point2[i]);
        }
        return distance;
    }
}
