package com.vika.way.pre.algorithm.leetcode.midium.S501_600;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S513FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int prev = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                if (i == 0) {
                    prev = p.val;
                }
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return prev;
    }


    public int findBottomLeftValue1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list.get(list.size() - 1);
    }

    public void dfs(TreeNode p, List<Integer> list, int depth) {
        if (p == null) {
            return;
        }
        if (depth == list.size()) {
            list.add(p.val);
        }
        dfs(p.left, list, depth + 1);
        dfs(p.right, list, depth + 1);
    }
}
