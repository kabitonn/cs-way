package com.vika.way.pre.algorithm.leetcode.easy.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class S112HasPathSum {
    public boolean hasPathSum(TreeNode p, int sum) {
        if (p == null) {
            return false;
        }
        if (p.left == null && p.right == null && sum == p.val) {
            return true;
        } else {
            return hasPathSum(p.left, sum - p.val) || hasPathSum(p.right, sum - p.val);
        }
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> leftSumStack = new LinkedList<>();
        stack.push(root);
        leftSumStack.push(sum);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            int leftSum = leftSumStack.pop();
            if (p.left == null && p.right == null && leftSum == p.val) {
                return true;
            }
            if (p.left != null) {
                stack.push(p.left);
                leftSumStack.push(leftSum - p.val);
            }
            if (p.right != null) {
                stack.push(p.right);
                leftSumStack.push(leftSum - p.val);
            }
        }
        return false;
    }

    //中序DFS
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> leftSumStack = new Stack<>();
        TreeNode p = root;
        int leftSum = sum;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                leftSum -= p.val;
                leftSumStack.push(leftSum);
                p = p.left;
            }
            p = stack.pop();
            leftSum = leftSumStack.pop();
            if (leftSum == 0 && p.left == null && p.right == null) {
                return true;
            }
            p = p.right;
        }
        return false;
    }

    //后序DFS
    public boolean hasPathSum3(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode preVisited = null;
        int leftSum = sum;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                leftSum -= p.val;
                p = p.left;
            }
            p = stack.peek();
            if (leftSum == 0 && p.left == null && p.right == null) {
                return true;
            }
            if (p.right == null || p.right == preVisited) {
                preVisited = p;
                leftSum += p.val;
                stack.pop();
                p = null;
            } else {
                p = p.right;
            }
        }
        return false;
    }
}
