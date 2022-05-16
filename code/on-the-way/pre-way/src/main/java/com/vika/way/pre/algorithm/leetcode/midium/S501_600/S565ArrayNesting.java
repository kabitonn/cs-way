package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.HashSet;
import java.util.Set;

public class S565ArrayNesting {

    public int arrayNesting(int[] nums) {
        int N = nums.length;
        boolean[] visited = new boolean[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            int j = i;
            while (set.add(nums[j])) {
                visited[j] = true;
                j = nums[j];
            }
            max = Math.max(max, set.size());
            if (max > N / 2) {
                break;
            }
        }
        return max;
    }

    public int arrayNesting1(int[] nums) {
        int N = nums.length;
        boolean[] visited = new boolean[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            int j = i;
            int count = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = nums[j];
                count++;
            }
            max = Math.max(max, count);
            if (max > N / 2) {
                break;
            }
        }
        return max;
    }
}
