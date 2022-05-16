package com.vika.way.pre.algorithm.leetcode.easy.S501_600;



import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class S530MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorder(root, list);
        if (list.size() < 2) {
            return 0;
        }
        int prev = -1;
        int min = Integer.MAX_VALUE;
        for (int num : list) {
            if (prev >= 0) {
                min = Math.min(min, (num - prev));
            }
            prev = num;
        }
        return min;
    }

    public void inorder(TreeNode p, List<Integer> list) {
        if (p == null) {
            return;
        }
        inorder(p.left, list);
        list.add(p.val);
        inorder(p.right, list);
    }

    public int getMinimumDifference1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int prev = -1;
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (prev >= 0) {
                min = Math.min(min, (p.val - prev));
            }
            prev = p.val;
            p = p.right;
        }
        return min;
    }

    int prev = -1;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference2(TreeNode root) {
        inorder(root);
        return min;
    }


    public void inorder(TreeNode p) {
        if (p == null) {
            return;
        }
        inorder(p.left);
        if (prev >= 0) {
            min = Math.min(min, (p.val - prev));
        }
        prev = p.val;
        inorder(p.right);
    }
}
