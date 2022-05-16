package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.ArrayList;
import java.util.List;

public class S078Subsets {

    public static void main(String[] args) {
        S078Subsets solution = new S078Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(solution.subsets1(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        combine(listList, new ArrayList<>(), nums, 0);
        return listList;
    }

    //回溯
    private void combine(List<List<Integer>> listList, List<Integer> list, int[] nums, int index) {
        listList.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            combine(listList, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    //位运算
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        int len = nums.length;
        int num = 1 << len;
        for (int i = 0; i < num; i++) {
            int bit = i;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if ((bit & 1) == 1) {
                    list.add(nums[j]);
                }
                bit >>= 1;
            }
            listList.add(list);
        }
        return listList;
    }

    //迭代遍历
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        listList.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmpList = new ArrayList<>();
            //遍历之前的所有结果
            for (List<Integer> list : listList) {
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(nums[i]);
                tmpList.add(tmp);
            }
            listList.addAll(tmpList);
        }
        return listList;
    }
}
