package com.vika.way.pre.algorithm.leetcode.midium.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class S105ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9,3, 15, 20, 7};
        S105ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new S105ConstructBinaryTreeFromPreorderAndInorderTraversal();
        System.out.println(solution.buildTree2(preorder, inorder));
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR) {
            return null;
        }
        int rootVal = preorder[preL];
        TreeNode rootNode = new TreeNode(rootVal);
        int index = inL;
        for (; index <= inR; index++) {
            if (inorder[index] == rootVal) {
                break;
            }
        }
        int leftNum = index - inL;
        rootNode.left = buildTree(preorder, preL + 1, preL + leftNum, inorder, inL, index - 1);
        rootNode.right = buildTree(preorder, preL + leftNum + 1, preR, inorder, index + 1, inR);
        return rootNode;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode buildTree(Map<Integer, Integer> map, int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR) {
            return null;
        }
        int rootVal = preorder[preL];
        TreeNode rootNode = new TreeNode(rootVal);
        int index = map.get(rootVal);
        int leftNum = index - inL;
        rootNode.left = buildTree(map, preorder, preL + 1, preL + leftNum, inorder, inL, index - 1);
        rootNode.right = buildTree(map, preorder, preL + leftNum + 1, preR, inorder, index + 1, inR);
        return rootNode;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, (long) Integer.MAX_VALUE + 1);
    }

    int pre = 0;
    int in = 0;

    private TreeNode buildTree(int[] preorder, int[] inorder, long stop) {
        //到达末尾返回 null
        if (pre == preorder.length) {
            return null;
        }
        //到达停止点返回 null
        //当前停止点已经用了，in 后移
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int rootVal = preorder[pre++];
        TreeNode root = new TreeNode(rootVal);
        //左子树的停止点是当前的根节点
        root.left = buildTree(preorder, inorder, rootVal);
        //右子树的停止点是当前树的停止点(上层根节点)
        root.right = buildTree(preorder, inorder, stop);
        return root;
    }

    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        int pre = 0, in = 0;
        Stack<TreeNode> stack = new Stack<>();
        int rootVal = preorder[pre++];
        TreeNode root = new TreeNode(rootVal);
        TreeNode curRoot = root;
        stack.push(curRoot);
        while (pre < n) {
            if (curRoot.val != inorder[in]) {
                curRoot.left = new TreeNode(preorder[pre++]);
                curRoot = curRoot.left;
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[in]) {
                    curRoot = stack.pop();
                    in++;
                }
                curRoot.right = new TreeNode(preorder[pre++]);
                curRoot = curRoot.right;
            }
            stack.push(curRoot);
        }
        return root;
    }

    public TreeNode buildTree4(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        int pre = 0, in = 0;
        Stack<TreeNode> stack = new Stack<>();
        int rootVal = preorder[pre++];
        TreeNode root = new TreeNode(rootVal);
        stack.push(root);
        for (; pre < n; pre++) {
            TreeNode curRoot = new TreeNode(preorder[pre]);
            TreeNode back = null;
            while (!stack.isEmpty() && stack.peek().val == inorder[in]) {
                back = stack.pop();
                in++;
            }
            if (back == null) {
                stack.peek().left = curRoot;
            } else {
                back.right = curRoot;
            }
            stack.push(curRoot);
        }
        return root;
    }
}
