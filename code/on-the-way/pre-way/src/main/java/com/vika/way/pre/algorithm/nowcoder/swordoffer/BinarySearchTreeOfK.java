package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.TreeNode;

import java.util.Stack;

public class BinarySearchTreeOfK {

    int K = 0;
    TreeNode kth;

    TreeNode KthNode(TreeNode pRoot, int k) {
        K = k;
        inorder(pRoot);
        return kth;
    }

    public void inorder(TreeNode p) {
        if (p == null) {
            return;
        }
        inorder(p.left);
        if (--K == 0) {
            kth = p;
        }
        inorder(p.right);
    }

    TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRoot;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (--k == 0) {
                return p;
            }
            p = p.right;
        }
        return null;
    }
}
