package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S040CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        combine(lists, new ArrayList<>(), candidates, target, 0);
        return lists;
    }

    private void combine(List<List<Integer>> list, List<Integer> line, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            list.add(new ArrayList<>(line));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            line.add(nums[i]);
            combine(list, line, nums, remain - nums[i], i + 1);
            line.remove(line.size() - 1);
        }
    }

}
