package com.vika.way.pre.algorithm.leetcode.easy.S501_600;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.*;

public class S501FindModeInBinarySearchTree {

    //中序+遍历计数
    public int[] findMode0(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            list.add(p.val);
            p = p.right;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                count = 1;
            }
            else if (list.get(i).equals(list.get(i - 1))) {
                count++;
            } else {
                if (!map.containsKey(count)) {
                    map.put(count, new ArrayList<>());
                }
                map.get(count).add(list.get(i - 1));
                max = Math.max(max, count);
                count = 1;
            }
        }
        if (!map.containsKey(count)) {
            map.put(count, new ArrayList<>());
        }
        map.get(count).add(list.get(list.size() - 1));
        max = Math.max(max, count);
        int[] mode = new int[map.get(max).size()];
        int i = 0;
        for (int n : map.get(max)) {
            mode[i++] = n;
        }
        return mode;
    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        Integer prev = null;
        int count = 0, max = 0;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (prev == null || p.val != prev) {
                count = 1;
                prev = p.val;
            } else {
                count++;
            }
            if (count > max) {
                max = count;
                list = new ArrayList<>();
                list.add(prev);
            } else if (count == max) {
                list.add(prev);
            }
            p = p.right;
        }
        int[] mode = new int[list.size()];
        int i = 0;
        for (int n : list) {
            mode[i++] = n;
        }
        return mode;
    }


    public int[] findMode1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        List<Integer> modeList = new ArrayList<>();
        Integer prev = null;
        int count = 0, max = 0;
        for (int n : list) {
            if (prev == null || n != prev) {
                count = 1;
                prev = n;
            } else {
                count++;
            }
            if (count > max) {
                max = count;
                modeList = new ArrayList<>();
                modeList.add(prev);
            } else if (count == max) {
                modeList.add(prev);
            }
        }
        int[] mode = new int[modeList.size()];
        int i = 0;
        for (int n : modeList) {
            mode[i++] = n;
        }
        return mode;
    }

    public void inorder(TreeNode p, List<Integer> list) {
        if (p == null) {
            return;
        }
        inorder(p.left, list);
        list.add(p.val);
        inorder(p.right, list);
    }

    Integer prev = null;
    int count = 0, maxCount = 0;
    List<Integer> list = new ArrayList<>();

    public int[] findMode2(TreeNode root) {
        inorder(root);
        int[] mode = new int[list.size()];
        int i = 0;
        for (int n : list) {
            mode[i++] = n;
        }
        return mode;
    }

    public void inorder(TreeNode p) {
        if (p == null) {
            return;
        }
        inorder(p.left);
        if (prev == null || p.val != prev) {
            count = 1;
            prev = p.val;
        } else {
            count++;
        }
        if (count > maxCount) {
            maxCount = count;
            list = new ArrayList<>();
            list.add(prev);
        } else if (count == maxCount) {
            list.add(prev);
        }
        inorder(p.right);
    }
}
