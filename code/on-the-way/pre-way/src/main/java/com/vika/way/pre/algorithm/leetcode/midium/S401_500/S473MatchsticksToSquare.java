package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.Arrays;

public class S473MatchsticksToSquare {

    public static void main(String[] args) {
        S473MatchsticksToSquare solution = new S473MatchsticksToSquare();
        int[] nums = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
        System.out.println(solution.makesquare(nums));
    }

    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 3) != 0) {
            return false;
        }
        int side = sum >> 2;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > side) {
            return false;
        }
        int[] sides = new int[4];
        return backtrack_1(nums, nums.length - 1, sides, side);
    }

    public boolean backtrack(int[] nums, int index, int[] sides, int side) {
        if (index == -1) {
            for (int i = 0; i < 4; i++) {
                if (sides[i] != side) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + nums[index] > side) {
                continue;
            }
            sides[i] += nums[index];
            if (backtrack(nums, index - 1, sides, side)) {
                return true;
            }
            sides[i] -= nums[index];
        }
        return false;
    }

    public boolean backtrack_1(int[] nums, int index, int[] sides, int side) {
        if (index == -1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            // 剪枝，即前一个桶和当前桶火柴数一致时，可以直接跳过，因为对于1根火柴来讲，两个桶如果当前大小一样，再放入时是没有区别的
            // 而前面那个桶放入失败，则如果重新放入也肯定失败，故可以直接跳过
            if (i == 0 || sides[i - 1] != sides[i]) {
                if (sides[i] + nums[index] > side) {
                    continue;
                }
                sides[i] += nums[index];
                if (backtrack_1(nums, index - 1, sides, side)) {
                    return true;
                }
                sides[i] -= nums[index];
            }
        }
        return false;
    }

    public boolean makesquare1(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 3) != 0) {
            return false;
        }
        int side = sum >> 2;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > side) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        int index = nums.length - 1;
        for (int i = 0; i < 4; i++) {
            while (visited[index]) {
                index--;
            }
            if (!dfs1(nums, index, 0, side, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs1(int[] nums, int index, int len, int side, boolean[] visited) {
        if (len == side) {
            return true;
        }
        for (int i = index; i >= 0; i--) {
            if (visited[i] || len + nums[i] > side) {
                continue;
            }
            visited[i] = true;
            if (dfs1(nums, i - 1, len + nums[i], side, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
