package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.*;

public class S398RandomPickIndex {

    Map<Integer, List<Integer>> listMap;
    int[] nums;
    Random random;

    public S398RandomPickIndex(int[] nums) {
        random = new Random();
        this.nums = Arrays.copyOf(nums, nums.length);
        listMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!listMap.containsKey(nums[i])) {
                listMap.put(nums[i], new ArrayList<>());
            }
            listMap.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = listMap.get(target);
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        S398RandomPickIndex solution = new S398RandomPickIndex(nums);
        System.out.println(solution.pick(3));
    }
}
