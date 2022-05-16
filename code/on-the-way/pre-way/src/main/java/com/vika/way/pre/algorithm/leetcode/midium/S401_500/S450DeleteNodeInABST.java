package com.vika.way.pre.algorithm.leetcode.midium.S401_500;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

public class S450DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode prev = null, right = root.left;
            while (right.right != null) {
                prev = right;
                right = right.right;
            }
            if (prev == null) {
                root.left = right.left;
            } else {
                prev.right = right.left;
            }
            root.val = right.val;
            return root;
            /*
            right.left = root.left;
            right.right = root.right;
            return right;
             */
        }
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode1(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode1(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode right = root.left;
            while (right.right != null) {
                right = right.right;
            }
            right.right = root.right;
            return root.left;
        }
    }
}
