package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BinaryTreeConstruct {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        int len = pre.length;
        TreeNode root = buildTree(map, pre, in, 0, len - 1, 0, len - 1);
        return root;
    }

    public TreeNode buildTree(Map<Integer, Integer> map, int[] pre, int[] in, int preL, int preR, int inL, int inR) {
        if (preL > preR) {
            return null;
        }
        int rootVal = pre[preL];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        int left = index - inL;
        root.left = buildTree(map, pre, in, preL + 1, preL + left, inL, index - 1);
        root.right = buildTree(map, pre, in, preL + 1 + left, preR, index + 1, inR);
        return root;
    }

    public TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        int len = pre.length;
        if (len == 0) {
            return null;
        }
        int p = 0;
        int i = 0;
        TreeNode root = new TreeNode(pre[p++]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (; p < len; p++) {
            TreeNode node = new TreeNode(pre[p]);
            TreeNode back = null;
            while (!stack.isEmpty() && stack.peek().val == in[i]) {
                back = stack.pop();
                i++;
            }
            if (back != null) {
                back.right = node;
            } else {
                stack.peek().left = node;
            }
            stack.push(node);
        }
        return root;
    }

    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        int len = pre.length;
        if (len == 0) {
            return null;
        }
        int p = 0;
        int i = 0;
        TreeNode root = new TreeNode(pre[p++]);
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        for (; p < len; p++) {
            TreeNode node = new TreeNode(pre[p]);
            if(cur.val!=in[i]){
                cur.left=node;
                cur=cur.left;
            }else {
                while (!stack.isEmpty()&&stack.peek().val==in[i]){
                    cur=stack.pop();
                    i++;
                }
                cur.right=node;
                cur=cur.right;
            }
            stack.push(node);
        }
        return root;
    }

}
