package com.vika.way.pre.algorithm.leetcode.easy.S201_300;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

public class S235LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node != null) {
            int val = node.val;
            if (pVal < val && qVal < val) {
                node = node.left;
            } else if (pVal > val && qVal > val) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }
}
