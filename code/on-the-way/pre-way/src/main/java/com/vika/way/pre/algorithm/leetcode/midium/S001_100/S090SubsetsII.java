package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S090SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        combine(listList, new ArrayList<>(), nums, 0);
        return listList;
    }

    //回溯
    private void combine(List<List<Integer>> listList, List<Integer> list, int[] nums, int index) {
        listList.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            combine(listList, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    //位运算

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int num = 1 << len;
        for (int i = 0; i < num; i++) {
            int bit = i;
            boolean illegal = false;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if ((bit & 1) == 1) {
                    if (j > 0 && nums[j] == nums[j - 1] && (i >> (j - 1) & 1) == 0) {
                        illegal = true;
                        break;
                    }
                    list.add(nums[j]);
                }
                bit >>= 1;
            }
            if (!illegal) {
                listList.add(list);
            }
        }
        return listList;
    }

    //迭代遍历
    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        listList.add(new ArrayList<>());
        Arrays.sort(nums);
        int newStart = 1;
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmpList = new ArrayList<>();
            //遍历之前的所有结果
            for (int j = 0; j < listList.size(); j++) {
                if (i > 0 && nums[i] == nums[i - 1] && j < newStart) {
                    continue;
                }
                List<Integer> tmp = new ArrayList<>(listList.get(j));
                tmp.add(nums[i]);
                tmpList.add(tmp);
            }
            newStart = listList.size();
            listList.addAll(tmpList);
        }
        return listList;
    }

    public List<List<Integer>> subsetsWithDup4(int[] nums) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<>();
        listList.add(empty);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int dupCount = 0;
            //判断当前是否是重复数字，并且记录重复的次数
            while (((i + 1) < nums.length) && nums[i + 1] == nums[i]) {
                dupCount++;
                i++;
            }
            int prevNum = listList.size();
            //遍历之前几个结果的每个解
            for (int j = 0; j < prevNum; j++) {
                List<Integer> element = new ArrayList<>(listList.get(j));
                //每次在上次的结果中多加 1 个重复数字
                for (int t = 0; t <= dupCount; t++) {
                    element.add(nums[i]);
                    listList.add(new ArrayList<>(element));
                }
            }
        }
        return listList;
    }
}
