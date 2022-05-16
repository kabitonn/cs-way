package com.vika.way.pre.algorithm.leetcode.midium.S001_100;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class S098ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            TreeNode right = root.left;
            while (right.right != null) {
                right = right.right;
            }
            if (right.val >= root.val) {
                return false;
            }
        }
        if (root.right != null) {
            TreeNode left = root.right;
            while (left.left != null) {
                left = left.left;
            }
            if (left.val <= root.val) {
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (pre != null && pre.val >= p.val) {
                return false;
            }
            pre = p;
            p = p.right;

        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode t, Integer min, Integer max) {
        if (t == null) {
            return true;
        }
        if (min != null && min >= t.val) {
            return false;
        }
        if (max != null && max <= t.val) {
            return false;
        }
        return isValid(t.left, min, t.val) && isValid(t.right, t.val, max);
    }

    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> minValue = new Stack<>();
        Stack<Integer> maxValue = new Stack<>();
        pushStack(stack, minValue, maxValue, root, null, null);
        TreeNode p = null;
        Integer min, max;
        while (!stack.isEmpty()) {
            p = stack.pop();
            min = minValue.pop();
            max = maxValue.pop();
            if (p == null) {
                continue;
            }
            if (min != null && p.val <= min) {
                return false;
            }
            if (max != null && p.val >= max) {
                return false;
            }
            pushStack(stack, minValue, maxValue, p.right, p.val, max);
            pushStack(stack, minValue, maxValue, p.left, min, p.val);

        }
        return true;
    }

    private void pushStack(Stack s1, Stack s2, Stack s3, TreeNode t1, Integer m2, Integer m3) {
        s1.push(t1);
        s2.push(m2);
        s3.push(m3);
    }

    public boolean isValidBST4(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        //利用三个队列来保存对应的节点和区间
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> minValues = new LinkedList<>();
        Queue<Integer> maxValues = new LinkedList<>();
        //头结点入队列
        TreeNode pNode = root;
        queue.offer(pNode);
        minValues.offer(null);
        maxValues.offer(null);
        while (!queue.isEmpty()) {
            //判断队列的头元素是否符合条件并且出队列
            Integer minValue = minValues.poll();
            Integer maxValue = maxValues.poll();
            pNode = queue.poll();
            if (minValue != null && pNode.val <= minValue) {
                return false;
            }
            if (maxValue != null && pNode.val >= maxValue) {
                return false;
            }
            //左孩子入队列
            if (pNode.left != null) {
                queue.offer(pNode.left);
                minValues.offer(minValue);
                maxValues.offer(pNode.val);
            }
            //右孩子入队列
            if (pNode.right != null) {
                queue.offer(pNode.right);
                minValues.offer(pNode.val);
                maxValues.offer(maxValue);
            }
        }
        return true;
    }

}
