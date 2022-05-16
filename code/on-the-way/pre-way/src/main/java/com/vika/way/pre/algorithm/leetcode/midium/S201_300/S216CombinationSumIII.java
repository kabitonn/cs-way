package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.ArrayList;
import java.util.List;

public class S216CombinationSumIII {
    public static void main(String[] args) {
        S216CombinationSumIII solution = new S216CombinationSumIII();
        System.out.println(solution.combinationSum3(3, 10));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> listList = new ArrayList<>();
        combine(listList, new ArrayList<>(), k, 1, n);
        return listList;
    }

    public void combine(List<List<Integer>> listList, List<Integer> list, int k, int index, int remain) {
        if (list.size() == k) {
            if (remain == 0) {
                listList.add(new ArrayList<>(list));
            }
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = index; i <= 9; i++) {
            list.add(i);
            combine(listList, list, k, i + 1, remain - i);
            list.remove(list.size() - 1);
        }
    }
}
