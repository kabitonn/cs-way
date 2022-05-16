package com.vika.way.pre.autumn.interview.tencent;

import com.vika.way.pre.algorithm.leetcode.common.TreeNode;
import org.junit.Test;

/**
 * @Author tangjiawei
 * @Date 2020/9/1
 */
public class BinaryTreeReverse {

    public TreeNode reverseTree(TreeNode p) {
        if (p == null) {
            return null;
        }
        TreeNode left = p.left;
        TreeNode right = p.right;
        p.left = reverseTree(right);
        p.right = reverseTree(left);
        return p;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode p = root.left;
        p.left = new TreeNode(4);
        TreeNode r = reverseTree(root);
        System.out.println(root);
    }
}
