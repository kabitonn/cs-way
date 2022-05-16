package com.vika.way.pre.algorithm.leetcode.midium.S401_500;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.*;

public class S449SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = preorder(root);
        StringBuilder sb = new StringBuilder();
        for (int n : list) {
            sb.append(n).append(",");
        }
        if (list.size() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    public List<Integer> preorder_1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                list.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }
        return list;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        //int[] preorder = Arrays.stream(data.split(",")).mapToInt(Integer::valueOf).toArray();
        String[] strs = data.split(",");
        int[] preoder = new int[strs.length];
        int n = preoder.length;
        for (int i = 0; i < n; i++) {
            preoder[i] = Integer.valueOf(strs[i]);
        }
        int[] inorder = Arrays.copyOf(preoder, n);
        Arrays.sort(inorder);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, preoder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode buildTree(Map<Integer, Integer> map, int[] preoder, int[] inorder, int p1, int p2, int i1, int i2) {
        if (p1 > p2) {
            return null;
        }
        int val = preoder[p1];
        TreeNode node = new TreeNode(val);
        int index = map.get(val);
        int left = index - i1;
        node.left = buildTree(map, preoder, inorder, p1 + 1, p1 + left, i1, index - 1);
        node.right = buildTree(map, preoder, inorder, p1 + left + 1, p2, index + 1, i2);
        return node;
    }

    public TreeNode deserialize_1(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] strs = data.split(",");
        int[] preoder = new int[strs.length];
        int n = preoder.length;
        for (int i = 0; i < n; i++) {
            preoder[i] = Integer.valueOf(strs[i]);
        }
        int[] inorder = Arrays.copyOf(preoder, n);
        Arrays.sort(inorder);
        return buildTree_1(preoder, inorder);
    }

    public TreeNode buildTree_1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int pre = 0, in = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[pre++]);
        stack.push(root);
        for (; pre < n; pre++) {
            TreeNode curRoot = new TreeNode(preorder[pre]);
            TreeNode back = null;
            while (!stack.isEmpty() && stack.peek().val == inorder[in]) {
                back = stack.pop();
                System.out.println(back.val);
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

    public TreeNode buildTree_2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int pre = 0, in = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[pre++]);
        stack.push(root);
        TreeNode curRoot = root;
        while (pre < n) {
            if (curRoot.val != inorder[in]) {
                curRoot.left = new TreeNode(preorder[pre++]);
                curRoot = curRoot.left;
            } else {
                while (!stack.isEmpty() && curRoot.val == inorder[in]) {
                    in++;
                    curRoot = stack.pop();
                }
                curRoot.right = new TreeNode(preorder[pre++]);
                curRoot = curRoot.right;
            }
            stack.push(curRoot);
        }

        return root;
    }

    public String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode deserialize1(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] strs = data.split(",");
        int[] preoder = new int[strs.length];
        int n = preoder.length;
        for (int i = 0; i < n; i++) {
            preoder[i] = Integer.valueOf(strs[i]);
        }
        int pre = 0;
        TreeNode root = new TreeNode(preoder[pre++]);
        for (; pre < n; pre++) {
            insert(root, preoder[pre]);
        }
        return root;
    }

    public void insert(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        while (true) {
            if (root.val > val) {
                if (root.left == null) {
                    root.left = node;
                    break;
                }
                root = root.left;
            } else {
                if (root.right == null) {
                    root.right = node;
                    break;
                }
                root = root.right;
            }
        }
    }

}
