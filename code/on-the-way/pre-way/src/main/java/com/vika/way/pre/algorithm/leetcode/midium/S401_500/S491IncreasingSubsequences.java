package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.*;

public class S491IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new HashSet<>());
            }
            boolean hasEqual = false;
            Set<List<Integer>> set = new HashSet<>(map.get(nums[i]));
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] || (!hasEqual && nums[j] == nums[i])) {
                    set.add(Arrays.asList(nums[j], nums[i]));
                    if (!map.containsKey(nums[j])) {
                        continue;
                    }
                    for (List<Integer> list : map.get(nums[j])) {
                        List<Integer> tmp = new ArrayList<>(list);
                        tmp.add(nums[i]);
                        set.add(tmp);
                    }
                    hasEqual = nums[j] == nums[i];
                }
            }
            map.put(nums[i], set);
        }
        List<List<Integer>> listList = new ArrayList<>();
        for (Set<List<Integer>> set : map.values()) {
            listList.addAll(set);
        }
        return listList;

    }

    //待完善
    public List<List<Integer>> findSubsequences0(int[] nums) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            List<List<Integer>> listList = new ArrayList<>(map.get(nums[i]));
            for (int j = 0; j < i; j++) {
                boolean hasEqual = false;
                if (nums[j] <= nums[i]) {
                    for (int k = j + 1; k < i; k++) {
                        if (nums[k] == nums[j]) {
                            hasEqual = true;
                            break;
                        }
                    }
                    if (hasEqual) {
                        continue;
                    }
                    listList.add(Arrays.asList(nums[j], nums[i]));
                    if (!map.containsKey(nums[j])) {
                        continue;
                    }
                    for (List<Integer> list : map.get(nums[j])) {
                        List<Integer> tmp = new ArrayList<>(list);
                        tmp.add(nums[i]);
                        listList.add(tmp);
                    }
                    hasEqual = nums[j] == nums[i];
                }
            }
            map.put(nums[i], listList);
        }
        List<List<Integer>> listList = new ArrayList<>();
        for (List<List<Integer>> list : map.values()) {
            listList.addAll(list);
        }
        return listList;
    }

    public List<List<Integer>> findSubsequences1(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        dfs(nums, 0, new LinkedList<>(), set);
        return new ArrayList<>(set);
    }

    public void dfs(int[] nums, int index, LinkedList<Integer> list, Set<List<Integer>> set) {
        if (list.size() > 1) {
            set.add(new ArrayList<>(list));
        }
        for (int i = index; i < nums.length; i++) {
            if (list.isEmpty() || nums[i] >= list.getLast()) {
                list.addLast(nums[i]);
                dfs(nums, i + 1, list, set);
                list.removeLast();
            }
        }
    }

    public List<List<Integer>> findSubsequences2(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        dfs(nums, 0, Integer.MIN_VALUE, new LinkedList<>(), listList);
        return listList;
    }

    public void dfs(int[] nums, int index, int prev, LinkedList<Integer> list, List<List<Integer>> listList) {
        if (list.size() > 1) {
            listList.add(new ArrayList<>(list));
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] < prev) {
                continue;
            }
            boolean hasEqual = false;
            for (int j = index; j < i; j++) {
                if (nums[j] == nums[i]) {
                    hasEqual = true;
                    break;
                }
            }
            if (!hasEqual) {
                list.addLast(nums[i]);
                dfs(nums, i + 1, nums[i], list, listList);
                list.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        S491IncreasingSubsequences solution = new S491IncreasingSubsequences();
        System.out.println(solution.findSubsequences0(nums));
    }
}
