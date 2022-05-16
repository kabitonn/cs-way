package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.ArrayList;
import java.util.List;

public class S442FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        S442FindAllDuplicatesInAnArray solution = new S442FindAllDuplicatesInAnArray();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution.findDuplicates2(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[nums[i] - 1]++;
            if (arr[nums[i] - 1] >= 2) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = (nums[i] - 1) % n;
            nums[index] += n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > n * 2) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i + 1 != nums[i]) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}
