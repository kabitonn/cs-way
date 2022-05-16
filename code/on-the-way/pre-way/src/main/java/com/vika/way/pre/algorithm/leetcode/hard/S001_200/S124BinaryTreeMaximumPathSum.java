package com.vika.way.pre.algorithm.leetcode.hard.S001_200;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

public class S124BinaryTreeMaximumPathSum {

    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxPath;
    }

    public int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(pathSum(root.left), 0);
        int rightSum = Math.max(pathSum(root.right), 0);

        maxPath = Math.max(maxPath, leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }

}
