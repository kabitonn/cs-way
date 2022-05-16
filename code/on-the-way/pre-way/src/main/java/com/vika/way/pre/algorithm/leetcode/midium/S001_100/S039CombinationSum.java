package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.*;

public class S039CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combine(list, new LinkedList<>(), candidates, target, 0);
        return list;
    }

    public void combine(List<List<Integer>> list, LinkedList<Integer> line, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            list.add(new ArrayList<>(line));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            line.add(nums[i]);
            combine(list, line, nums, remain - nums[i], i);
            line.removeLast();
        }
    }

    public List<List<Integer>> combinationSum0(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        combine0(list, new LinkedList<>(), candidates, target, 0);
        return list;
    }

    public void combine0(List<List<Integer>> list, LinkedList<Integer> line, int[] nums, int remain, int start) {
        if (remain == 0) {
            list.add(new ArrayList<>(line));
            return;
        }
        for (int i = start; i < nums.length && remain >= nums[i]; i++) {
            line.add(nums[i]);
            combine0(list, line, nums, remain - nums[i], i);
            line.removeLast();
        }
    }


    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.get(0).add(new ArrayList<>());
        //对candidates数组进行排序
        Arrays.sort(candidates);
        int len = candidates.length;
        for (int i = 1; i <= target; i++) {
            //初始化map
            map.put(i, new HashSet<>());
            //对candidates数组进行循环
            for (int candidate : candidates) {
                if (candidate > i) {
                    continue;
                }
                //i-candidate是map的key
                int key = i - candidate;
                //使用迭代器对对应key的set集合进行遍历
                //如果candidates数组不包含这个key值，对应的set集合会为空，故这里不需要做单独判断
                for (List list : map.get(key)) {
                    //set集合里面的每一个list都要加入candidates[j]，然后放入到以i为key的集合中
                    List tempList = new ArrayList<>(list);
                    tempList.add(candidate);
                    //排序是为了通过set集合去重
                    Collections.sort(tempList);
                    map.get(i).add(tempList);
                }
            }
        }
        result.addAll(map.get(target));
        return result;
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>[] dp = new ArrayList[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new ArrayList<>());
        Arrays.sort(candidates);
        for (int n : candidates) {
            for (int sum = n; sum <= target; sum++) {
                int key = sum - n;
                for (List list : dp[key]) {
                    List tempList = new ArrayList(list);
                    tempList.add(n);
                    dp[sum].add(tempList);
                }
            }
        }
        return dp[target];
    }
}
