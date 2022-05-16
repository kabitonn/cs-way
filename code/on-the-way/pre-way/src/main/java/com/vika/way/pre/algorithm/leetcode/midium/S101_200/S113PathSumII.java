package com.vika.way.pre.algorithm.leetcode.midium.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> listList = new ArrayList<>();
        pathSum(listList, new ArrayList<>(), root, sum);
        return listList;
    }

    public void pathSum(List<List<Integer>> listList, List<Integer> list, TreeNode p, int sum) {
        if (p == null) {
            return;
        }
        list.add(p.val);
        if (sum == p.val && p.left == null && p.right == null) {
            listList.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        pathSum(listList, list, p.left, sum - p.val);
        pathSum(listList, list, p.right, sum - p.val);
        list.remove(list.size() - 1);
    }
    //后序DFS
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode preVisited = null;
        int leftSum = sum;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                list.add(p.val);
                leftSum -= p.val;
                p = p.left;
            }
            p = stack.peek();
            if (leftSum == 0 && p.left == null && p.right == null) {
                listList.add(new ArrayList<>(list));
            }
            if (p.right == null || p.right == preVisited) {
                preVisited = p;
                leftSum += p.val;
                list.remove(list.size() - 1);
                stack.pop();
                p = null;
            } else {
                p = p.right;
            }
        }
        return listList;
    }
}
