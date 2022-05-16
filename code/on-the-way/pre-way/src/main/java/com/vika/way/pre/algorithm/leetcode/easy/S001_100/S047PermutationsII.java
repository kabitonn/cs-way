package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S047PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listList = new ArrayList<>();
        permute(nums, 0, listList);
        return listList;
    }

    public void permute(int[] nums, int start, List<List<Integer>> listList) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            listList.add(list);
        }
        for (int i = start; i < nums.length; i++) {
            int j = i - 1;
            while (j >= start && nums[j] != nums[i]) {
                j--;
            }
            if (j != start - 1) {
                continue;
            }
            swap(nums, i, start);
            permute(nums, start + 1, listList);
            swap(nums, i, start);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<List<Integer>> permuteUnique1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listList = new ArrayList<>();
        permute(nums, new boolean[nums.length], listList, new ArrayList<>());
        return listList;
    }

    public void permute(int[] nums, boolean[] visited, List<List<Integer>> listList, List<Integer> list) {
        if (list.size() == nums.length) {
            listList.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            permute(nums, visited, listList, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

}
