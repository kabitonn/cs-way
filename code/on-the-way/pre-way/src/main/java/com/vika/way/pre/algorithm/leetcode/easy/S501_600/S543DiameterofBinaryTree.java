package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

public class S543DiameterofBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max((left + right), Math.max(leftDiameter, rightDiameter));
    }

    public int getDepth(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int left = getDepth(p.left);
        int right = getDepth(p.right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree1(TreeNode root) {
        return getDiameter(root)[0];
    }

    public int[] getDiameter(TreeNode p) {
        if (p == null) {
            return new int[]{0, 0};
        }
        int[] left = getDiameter(p.left);
        int[] right = getDiameter(p.right);
        int[] root = new int[2];
        root[0] = Math.max(left[1] + right[1], Math.max(left[0], right[0]));
        root[1] = Math.max(left[1], right[1]) + 1;
        return root;
    }

    int max = 0;

    public int diameterOfBinaryTree2(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int left = depth(p.left);
        int right = depth(p.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
