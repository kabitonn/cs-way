package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.Arrays;
import java.util.Random;

public class S398RandomPickIndex_1 {

    int[] nums;
    Random random;

    public S398RandomPickIndex_1(int[] nums) {
        random = new Random();
        this.nums = Arrays.copyOf(nums, nums.length);
    }

    public int pick(int target) {
        int index = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (random.nextInt(count) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        S398RandomPickIndex_1 solution = new S398RandomPickIndex_1(nums);
        System.out.println(solution.pick(3));
    }
}
