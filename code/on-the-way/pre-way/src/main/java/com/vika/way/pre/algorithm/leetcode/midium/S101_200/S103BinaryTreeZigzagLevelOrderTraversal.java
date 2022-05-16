package com.vika.way.pre.algorithm.leetcode.midium.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.*;

public class S103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return listList;
        }
        queue.add(root);
        int level = 0;
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
            if ((level & 1) == 1) {
                Collections.reverse(list);
            }
            level++;
            listList.add(list);
        }
        return listList;
    }

    public List<List<Integer>> zigzagLevelOrder0(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return listList;
        }
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                if (level % 2 == 1) {
                    list.addFirst(p.val);
                } else {
                    list.add(p.val);
                }
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
            level++;
            listList.add(list);
        }
        return listList;
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        zigzagLevelOrder(listList, root, 0);
        return listList;
    }

    private void zigzagLevelOrder(List<List<Integer>> listList, TreeNode p, int depth) {
        if (p == null) {
            return;
        }
        if (depth + 1 > listList.size()) {
            listList.add(new ArrayList<>());
        }
        List<Integer> list = listList.get(depth);
        if ((depth & 1) == 0) {
            list.add(0, p.val);
        } else {
            list.add(p.val);
        }
        zigzagLevelOrder(listList, p.left, depth + 1);
        zigzagLevelOrder(listList, p.right, depth + 1);
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) {
            return listList;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode p = root;
        s1.push(p);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!s1.isEmpty()) {
                p = s1.pop();
                list.add(p.val);
                if (p.left != null) {
                    s2.push(p.left);
                }
                if (p.right != null) {
                    s2.push(p.right);
                }
            }
            listList.add(list);
            list = new ArrayList<>();
            while (!s2.isEmpty()) {
                p = s2.pop();
                list.add(p.val);
                if (p.right != null) {
                    s1.push(p.right);
                }
                if (p.left != null) {
                    s1.push(p.left);
                }
            }
            if (!list.isEmpty()) {
                listList.add(list);
            }
        }
        return listList;
    }
}
