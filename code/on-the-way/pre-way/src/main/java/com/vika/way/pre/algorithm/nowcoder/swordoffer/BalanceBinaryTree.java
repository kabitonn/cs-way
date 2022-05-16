package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.TreeNode;

public class BalanceBinaryTree {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int depth(TreeNode p) {
        if (p == null) {
            return 0;
        }
        return 1 + Math.max(depth(p.left), depth(p.right));

    }

    public boolean IsBalanced(TreeNode root) {
        return depthDiff(root) != -1;
    }

    public int depthDiff(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int left = depthDiff(p.left);
        if (left == -1) {
            return -1;
        }
        int right = depthDiff(p.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) <= 1) {
            return 1 + Math.max(left, right);
        } else {
            return -1;
        }
    }
}