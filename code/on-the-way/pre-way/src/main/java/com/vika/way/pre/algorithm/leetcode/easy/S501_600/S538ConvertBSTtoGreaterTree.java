package com.vika.way.pre.algorithm.leetcode.easy.S501_600;



import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.Stack;

public class S538ConvertBSTtoGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int sum = 0;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.right;
            }
            p = stack.pop();
            sum += p.val;
            p.val = sum;
            p = p.left;
        }
        return root;
    }

    int sum = 0;

    public TreeNode convertBST1(TreeNode root) {
        reverseInorder(root);
        return root;
    }

    public void reverseInorder(TreeNode p) {
        if (p == null) {
            return;
        }
        reverseInorder(p.right);
        sum += p.val;
        p.val = sum;
        reverseInorder(p.left);
    }

}
