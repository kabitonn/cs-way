package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinaryTreeSumPath {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        getPathSum(listArrayList, list, root, target);
        ArrayList<ArrayList<Integer>> arrayListsLeft = FindPath(root.left, target);
        ArrayList<ArrayList<Integer>> arrayListsRight = FindPath(root.right, target);
        listArrayList.addAll(arrayListsLeft);
        listArrayList.addAll(arrayListsRight);
        Collections.sort(listArrayList, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return listArrayList;
    }

    public void getPathSum(ArrayList<ArrayList<Integer>> listList, List<Integer> list, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        list.add(node.val);
        if (sum == 0) {
            listList.add(new ArrayList<Integer>(list));
        }
        getPathSum(listList, list, node.left, sum);
        getPathSum(listList, list, node.right, sum);
        list.remove(list.size() - 1);
    }

}
