package com.vika.way.pre.algorithm.leetcode.easy.S501_600;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

public class S563BinaryTreeTilt {

    public int findTilt(TreeNode root) {
        return getDiffSumTree(root)[0];
    }

    public int[] getDiffSumTree(TreeNode p) {
        if (p == null) {
            return new int[]{0, 0};
        }
        int[] left = getDiffSumTree(p.left);
        int[] right = getDiffSumTree(p.right);
        int[] root = new int[2];
        root[0] = Math.abs(left[1] - right[1]) + left[0] + right[0];
        root[1] = left[1] + right[1] + p.val;
        return root;
    }

    public int findTilt1(TreeNode root) {
        travleSum(root);
        return getSum(root);
    }

    public int getSum(TreeNode p) {
        if (p == null) {
            return 0;
        }
        return p.val + getSum(p.left) + getSum(p.right);
    }

    public int travleSum(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int val = p.val;
        int left = travleSum(p.left);
        int right = travleSum(p.right);
        p.val = Math.abs(left - right);
        return val + left + right;
    }

    int sum = 0;

    public int findTilt2(TreeNode root) {
        sumTree(root);
        return sum;
    }

    public int sumTree(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int left = sumTree(p.left);
        int right = sumTree(p.right);
        sum += Math.abs(left - right);
        return p.val + left + right;
    }

}
