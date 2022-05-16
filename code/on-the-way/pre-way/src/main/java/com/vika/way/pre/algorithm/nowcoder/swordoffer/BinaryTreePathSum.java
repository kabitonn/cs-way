package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinaryTreePathSum {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        sumPath(listArrayList, list, root, target);
        Collections.sort(listArrayList, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return listArrayList;
    }

    public void sumPath(ArrayList<ArrayList<Integer>> listList, List<Integer> list, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            listList.add(new ArrayList<>(list));
        } else {
            sumPath(listList, list, node.left, sum - node.val);
            sumPath(listList, list, node.right, sum - node.val);
        }
        list.remove(list.size() - 1);
    }
}
