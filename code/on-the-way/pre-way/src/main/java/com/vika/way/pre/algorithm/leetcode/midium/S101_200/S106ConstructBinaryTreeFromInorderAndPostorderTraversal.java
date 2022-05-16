package com.vika.way.pre.algorithm.leetcode.midium.S101_200;



import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class S106ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        int[] inorder = {4, 5, 2, 1, 3};
        int[] postorder = {4,1,2,5,3};
        S106ConstructBinaryTreeFromInorderAndPostorderTraversal solution = new S106ConstructBinaryTreeFromInorderAndPostorderTraversal();
        System.out.println(solution.buildTree(inorder, postorder));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, inorder, 0, n - 1, postorder, 0, n - 1);
    }

    private TreeNode buildTree(Map<Integer, Integer> map, int[] inorder, int inL, int inR, int[] postorder, int postL, int postR) {
        if (postL > postR) {
            return null;
        }
        int rootVal = postorder[postR];
        TreeNode rootNode = new TreeNode(rootVal);
        int index = map.get(rootVal);
        int rightNum = inR - index;
        int leftNum = index - inL;
        //rootNode.right = buildTree(map, inorder, index + 1, inR, postorder, postR - rightNum, postR - 1);
        //rootNode.left = buildTree(map, inorder, inL, index - 1, postorder, postL, postR - rightNum - 1);
        rootNode.right = buildTree(map, inorder, index + 1, inR, postorder, postL + leftNum, postR - 1);
        rootNode.left = buildTree(map, inorder, inL, index - 1, postorder, postL, postL + leftNum - 1);
        return rootNode;
    }

    private int in;
    private int post;

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        int n = inorder.length;
        in = n - 1;
        post = n - 1;
        return buildTree(inorder, postorder, (long) Integer.MIN_VALUE - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, long stop) {
        if (post < 0) {
            return null;
        }
        if (inorder[in] == stop) {
            in--;
            return null;
        }
        int rootVal = postorder[post--];
        TreeNode root = new TreeNode(rootVal);
        root.right = buildTree(inorder, postorder, rootVal);
        root.left = buildTree(inorder, postorder, stop);

        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        int in = n - 1;
        int post = n - 1;
        int rootVal = postorder[post--];
        TreeNode root = new TreeNode(rootVal);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curRoot = root;
        while (post >= 0) {
            if (curRoot.val != inorder[in]) {
                curRoot.right = new TreeNode(postorder[post--]);
                curRoot = curRoot.right;
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[in]) {
                    in--;
                    curRoot = stack.pop();
                }
                curRoot.left = new TreeNode(postorder[post--]);
                curRoot = curRoot.left;
            }
            stack.push(curRoot);
        }
        return root;
    }

    public TreeNode buildTree3(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        int in = n - 1;
        int post = n - 1;
        int rootVal = postorder[post--];
        TreeNode root = new TreeNode(rootVal);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (; post >= 0; post--) {
            TreeNode curRoot = new TreeNode(postorder[post]);
            TreeNode back = null;
            while (!stack.isEmpty() && stack.peek().val == inorder[in]) {
                in--;
                back = stack.pop();
            }
            if (back == null) {
                stack.peek().right = curRoot;
            } else {
                back.left = curRoot;
            }
            stack.push(curRoot);
        }
        return root;
    }
}
