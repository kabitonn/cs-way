package com.vika.way.pre.algorithm.leetcode.midium.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S129SumRootToLeafNumbers {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        sumNumber(root, path);
        return sum;
    }

    private void sumNumber(TreeNode p, List<Integer> path) {
        if (p == null) {
            return;
        }
        path.add(p.val);
        if (p.left == null && p.right == null) {
            int s = 0;
            for (int n : path) {
                s *= 10;
                s += n;
            }
            sum += s;
            path.remove(path.size() - 1);
            return;
        }
        sumNumber(p.left, path);
        sumNumber(p.right, path);
        path.remove(path.size() - 1);
    }

    public int sumNumbers1(TreeNode root) {
        sumNumber1(root, 0);
        return sum;
    }

    private void sumNumber1(TreeNode p, int curSum) {
        if (p == null) {
            return;
        }
        curSum = curSum * 10 + p.val;
        if (p.left == null && p.right == null) {
            sum += curSum;
            return;
        }
        sumNumber1(p.left, curSum);
        sumNumber1(p.right, curSum);
    }

    public int sumNumbers2(TreeNode root) {
        return sumNumber2(root, 0);
    }

    private int sumNumber2(TreeNode p, int curSum) {
        if (p == null) {
            return 0;
        }
        curSum = curSum * 10 + p.val;
        if (p.left == null && p.right == null) {
            return curSum;
        }
        int sum = 0;
        sum += sumNumber2(p.left, curSum);
        sum += sumNumber2(p.right, curSum);
        return sum;
    }

}
