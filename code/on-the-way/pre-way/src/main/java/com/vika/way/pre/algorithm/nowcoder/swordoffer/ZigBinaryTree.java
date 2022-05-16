package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.TreeNode;

import java.util.*;

public class ZigBinaryTree {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();
        queue.add(pRoot);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>(size);
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
            if ((level & 1) == 0) {
                Collections.reverse(list);
            }
            listArrayList.add(list);
            level++;
        }
        return listArrayList;
    }

    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(pRoot);
        while (!s1.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode p = s1.pop();
                list.add(p.val);
                if (p.left != null) {
                    s2.push(p.left);
                }
                if (p.right != null) {
                    s2.push(p.right);
                }
            }
            listArrayList.add(list);
            list = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode p = s2.pop();
                list.add(p.val);
                if (p.right != null) {
                    s1.push(p.right);
                }
                if (p.left != null) {
                    s1.push(p.left);
                }
            }
            if (!list.isEmpty()) {
                listArrayList.add(list);
            }
        }
        return listArrayList;
    }


}
