package com.vika.way.pre.algorithm.leetcode.midium.S501_600;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S508MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        sumTree(root, map);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int sum : map.keySet()) {
            if (map.get(sum) > max) {
                max = map.get(sum);
                list = new ArrayList<>();
                list.add(sum);
            } else if (map.get(sum) == max) {
                list.add(sum);
            }
        }
        int[] array = new int[list.size()];
        int i = 0;
        for (int n : list) {
            array[i++] = n;
        }
        return array;
    }

    public int sumTree(TreeNode p, Map<Integer, Integer> map) {
        if (p == null) {
            return 0;
        }
        int leftSum = sumTree(p.left, map);
        int rightSum = sumTree(p.right, map);
        int sum = p.val + leftSum + rightSum;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;
    List<Integer> list = new ArrayList<>();

    public int[] findFrequentTreeSum1(TreeNode root) {
        sumTree(root);
        int[] array = new int[list.size()];
        int i = 0;
        for (int n : list) {
            array[i++] = n;
        }
        return array;
    }

    public int sumTree(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int leftSum = sumTree(p.left);
        int rightSum = sumTree(p.right);
        int sum = p.val + leftSum + rightSum;
        int frequence = map.getOrDefault(sum, 0) + 1;
        if (frequence > maxCount) {
            maxCount = frequence;
            list = new ArrayList<>();
            list.add(sum);
        } else if (frequence == maxCount) {
            list.add(sum);
        }
        map.put(sum, frequence);
        return sum;
    }
}
