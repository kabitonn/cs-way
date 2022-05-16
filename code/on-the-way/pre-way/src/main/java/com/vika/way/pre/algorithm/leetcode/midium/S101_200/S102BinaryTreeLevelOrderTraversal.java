package com.vika.way.pre.algorithm.leetcode.midium.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return listList;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                list.add(p.val);
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
            listList.add(list);
        }
        return listList;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        levelOrder(root, listList, 0);
        return listList;
    }

    public void levelOrder(TreeNode p, List<List<Integer>> lines, int depth) {
        if (p == null) {
            return;
        }
        if (depth + 1 > lines.size()) {
            lines.add(new ArrayList<>());
        }
        List<Integer> line = lines.get(depth);
        line.add(p.val);
        levelOrder(p.left, lines, depth + 1);
        levelOrder(p.right, lines, depth + 1);

    }
}
