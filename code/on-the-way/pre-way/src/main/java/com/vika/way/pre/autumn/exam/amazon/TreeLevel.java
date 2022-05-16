package com.vika.way.pre.autumn.exam.amazon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：tangjiawei
 * @date ：2020/9/10 19:31
 */
public class TreeLevel {

    public List<List<Integer>> levelAccess(int[] nums, int l1, int l2) {
        int n = nums.length;
        int start = (int) Math.pow(2, l1 - 1);
        int size = (int) Math.pow(2, l1);
        List<List<Integer>> listList = new ArrayList<>();
        for (int l = l1; l <= l2; l++, start += size, size *= 2) {
            List<Integer> list = new ArrayList<>();
            for (int i = start, j = 0; j < size && i < n; i++, j++) {
                if (nums[i] == -1) {
                    continue;
                }
                list.add(nums[i]);
            }
            listList.add(list);
        }
        return listList;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, -1, -1, 4, 5, -1, -1};
        List<List<Integer>> listList = levelAccess(nums, 1, 3);
        System.out.println(listList);
    }

}
