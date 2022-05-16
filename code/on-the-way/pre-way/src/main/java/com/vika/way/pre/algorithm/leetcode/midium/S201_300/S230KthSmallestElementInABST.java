package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.Stack;

public class S230KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (--k == 0) {
                return p.val;
            }
            p = p.right;
        }
        return -1;
    }

    int index = 0;
    int val = -1;

    public int kthSmallest1(TreeNode root, int k) {
        inorderTraversal(root, k);
        return val;
    }


    public void inorderTraversal(TreeNode root, int k) {
        if (root == null || index >= k) {
            return;
        }
        inorderTraversal(root.left, k);
        if (++index == k) {
            val = root.val;
            return;
        }
        inorderTraversal(root.right, k);
    }
}
