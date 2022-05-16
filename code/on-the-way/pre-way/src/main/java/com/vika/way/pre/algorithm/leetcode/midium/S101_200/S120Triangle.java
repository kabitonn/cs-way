package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

import java.util.ArrayList;
import java.util.List;

public class S120Triangle {

    public static void main(String[] args) {
        S120Triangle solution = new S120Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(new ArrayList<>(list));
        list.clear();
        list.add(3);
        list.add(4);
        triangle.add(new ArrayList<>(list));
        list.clear();
        list.add(6);
        list.add(5);
        list.add(7);
        triangle.add(new ArrayList<>(list));
        list.clear();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        triangle.add(new ArrayList<>(list));
        System.out.println(solution.minimumTotal1(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        return minimumTotal(triangle, 0, 0, 0);
    }

    public int minimumTotal(List<List<Integer>> triangle, int row, int index, int sum) {
        sum += triangle.get(row).get(index);
        if (row == triangle.size() - 1) {
            return sum;
        }
        int sum0 = minimumTotal(triangle, row + 1, index, sum);
        int sum1 = minimumTotal(triangle, row + 1, index + 1, sum);
        return Math.min(sum0, sum1);
    }

    public int minimumTotal0(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        Integer[][] map = new Integer[size][];
        for (int i = size - 1; i >= 0; i--) {
            map[i] = new Integer[i + 1];
        }
        return minimumTotal(triangle, 0, 0, map);
    }

    public int minimumTotal(List<List<Integer>> triangle, int row, int index, Integer[][] map) {
        if (row == triangle.size()) {
            return 0;
        }
        if (map[row][index] != null) {
            return map[row][index];
        }
        int sum0 = minimumTotal(triangle, row + 1, index, map);
        int sum1 = minimumTotal(triangle, row + 1, index + 1, map);
        int sum = Math.min(sum0, sum1) + triangle.get(row).get(index);
        map[row][index] = sum;
        return sum;
    }


    public int minimumTotal1(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int[][] pathSum = new int[size + 1][];
        for (int i = size; i >= 0; i--) {
            pathSum[i] = new int[i + 1];
            if (i == size) {
                continue;
            }
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                pathSum[i][j] = Math.min(pathSum[i + 1][j], pathSum[i + 1][j + 1]) + row.get(j);
            }
        }
        return pathSum[0][0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int[] pathSum = new int[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                pathSum[j] = Math.min(pathSum[j], pathSum[j + 1]) + row.get(j);
            }
        }
        return pathSum[0];
    }
}
