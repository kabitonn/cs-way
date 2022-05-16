package com.vika.way.pre.algorithm.leetcode.easy.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

public class S110BalancedBinaryTree {
    //自顶向下
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode p) {
        if (p == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(p.left), maxDepth(p.right));
    }

    //自底向上
    public boolean isBalanced1(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int left = depth(p.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(p.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}
