package com.vika.way.pre.algorithm.leetcode.midium.S101_200;



import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.Stack;

public class S114FlattenBinaryTreeToLinkedList {
    //展开的顺序其实就是二叉树的先序遍历;
    //需要找出左子树最右边的节点以便把右子树接过来
    public void flatten1(TreeNode root) {
        TreeNode p = root;
        while (p != null) {
            if (p.left != null) {
                TreeNode left = p.left;
                while (left.right != null) {
                    left = left.right;
                }
                TreeNode right = p.right;
                left.right = right;
                p.right = p.left;
                p.left = null;
            }
            p = p.right;
        }
    }

    private TreeNode pre = null;

    //变形后序遍历 右左根
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = pre;
        pre = root;
    }

    //变形后序遍历 右左根
    public void flatten2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode preVisited = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.right;
            }
            p = stack.peek();
            if (p.left == null || p.left == preVisited) {
                stack.pop();
                p.right = preVisited;
                p.left = null;
                preVisited = p;
                p = null;
            } else {
                p = p.left;
            }
        }
    }
    //前序遍历转链表
    public void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
                p.left=null;
            }
            if (pre != null) {
                pre.right = p;
            }
            pre = p;
        }
    }

}
