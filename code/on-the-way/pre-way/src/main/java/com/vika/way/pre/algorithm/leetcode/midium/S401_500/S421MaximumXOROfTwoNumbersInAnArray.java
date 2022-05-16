package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.HashSet;
import java.util.Set;

public class S421MaximumXOROfTwoNumbersInAnArray {

    public static void main(String[] args) {
        S421MaximumXOROfTwoNumbersInAnArray solution = new S421MaximumXOROfTwoNumbersInAnArray();
        int[] nums = {3, 10, 13, 25, 2, 8};
        System.out.println(solution.findMaximumXOR2(nums));
    }

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                xor = Math.max(xor, nums[i] ^ nums[j]);
            }
        }
        return xor;
    }

    public int findMaximumXOR1(int[] nums) {
        TrieNode tree = buildTrieTree(nums);
        int xor = 0;
        for (int num : nums) {
            xor = Math.max(xor, findMaxXOR(tree, num));
        }
        return xor;
    }

    public int findMaxXOR(TrieNode root, int num) {
        TrieNode cur = root;
        int xor = 0;
        for (int i = 30; i >= 0; i--) {
            int v = (num >>> i) & 1;
            int path = v;
            if (cur.children[1 ^ v] != null) {
                path = 1 ^ v;
            }
            cur = cur.children[path];
            xor |= (path ^ v) << i;
        }
        return xor;
    }

    public TrieNode buildTrieTree(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = 30; i >= 0; i--) {
                int v = (num >>> i) & 1;
                if (cur.children[v] == null) {
                    cur.children[v] = new TrieNode();
                }
                cur = cur.children[v];
            }
            cur.val = num;
        }
        return root;
    }

    class TrieNode {
        int val;
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[2];
        }
    }

    public int findMaximumXOR2(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(prefix ^ tmp)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public int findMaximumXOR3(int[] nums) {
        TreeNode root = buildTree(nums);
        return findMaxXOR(root, root);
    }

    public int findMaxXOR(TreeNode p1, TreeNode p2) {
        while (true) {
            if (p1.left == null && p1.right == null && p2.left == null && p2.right == null) {
                break;
            }
            if (p1.left != null && p1.right != null && p2.left != null && p2.right != null) {
                return Math.max(findMaxXOR(p1.left, p2.right), findMaxXOR(p1.right, p2.left));
            }
            if (p1.left != null && p2.right != null) {
                p1 = p1.left;
                p2 = p2.right;
            } else if (p1.right != null && p2.left != null) {
                p1 = p1.right;
                p2 = p2.left;
            } else if (p1.left != null && p2.left != null) {
                p1 = p1.left;
                p2 = p2.left;
            } else if (p1.right != null && p2.right != null) {
                p1 = p1.right;
                p2 = p2.right;
            }
        }
        return p1.val ^ p2.val;
    }

    public TreeNode buildTree(int[] nums) {
        TreeNode root = new TreeNode();
        for (int num : nums) {
            TreeNode cur = root;
            for (int i = 30; i >= 0; i--) {
                if (((num >>> i) & 1) == 0) {
                    if (cur.left == null) {
                        cur.left = new TreeNode();
                    }
                    cur = cur.left;
                } else {
                    if (cur.right == null) {
                        cur.right = new TreeNode();
                    }
                    cur = cur.right;
                }
            }
            cur.val = num;
        }
        return root;
    }

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

}

