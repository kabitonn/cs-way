package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import java.util.Arrays;

public class S475Heaters {

    public static void main(String[] args) {
        S475Heaters solution = new S475Heaters();
        int[] houses = {617819336, 399125485, 156091745, 356425228};
        int[] heaters = {585640194, 937186357};
        System.out.println(solution.findRadius(houses, heaters));
    }

    public int findRadius(int[] houses, int[] heaters) {
        int m = houses.length, n = heaters.length;
        if (m == 0 || n == 0) {
            return 0;
        }
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;
        int index = 0;
        for (int house : houses) {
            while (index < n && house > heaters[index]) {
                index++;
            }
            int min;
            if (index == 0) {
                min = heaters[0] - house;
            } else if (index == n) {
                min = Math.abs(house - heaters[n - 1]);
            } else {
                min = Math.min(house - heaters[index - 1], heaters[index] - house);
            }
            radius = Math.max(radius, min);
        }
        return radius;
    }

    public int findRadius1(int[] houses, int[] heaters) {
        int m = houses.length, n = heaters.length;
        if (m == 0 || n == 0) {
            return 0;
        }
        Arrays.sort(heaters);
        int radius = 0;
        for (int house : houses) {
            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (heaters[mid] < house) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int min;
            if (left == n) {
                min = house - heaters[n - 1];
            } else if (left == 0) {
                min = heaters[0] - house;
            } else {
                min = Math.min(heaters[left] - house, house - heaters[left - 1]);
            }
            radius = Math.max(radius, min);
        }
        return radius;
    }
}
