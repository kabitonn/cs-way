//给你 root1 和 root2 这两棵二叉搜索树。 
//
// 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
//输出：[-10,0,0,1,2,5,7,10]
// 
//
// 示例 3： 
//
// 输入：root1 = [], root2 = [5,1,7,0,2]
//输出：[0,1,2,5,7]
// 
//
// 示例 4： 
//
// 输入：root1 = [0,-10,10], root2 = []
//输出：[-10,0,10]
// 
//
// 示例 5： 
//
// 
//
// 输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树最多有 5000 个节点。 
// 每个节点的值在 [-10^5, 10^5] 之间。 
// 
// Related Topics 排序 树 
// 👍 26 👎 0


//Java：两棵二叉搜索树中的所有元素

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P1305AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P1305AllElementsInTwoBinarySearchTrees().new Solution();
        // TO TEST
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            TreeNode p1 = root1, p2 = root2;
            List<Integer> list = new ArrayList<>();
            while ((p1 != null || !stack1.isEmpty()) && (p2 != null || !stack2.isEmpty())) {
                while (p1 != null) {
                    stack1.push(p1);
                    p1 = p1.left;
                }
                while (p2 != null) {
                    stack2.push(p2);
                    p2 = p2.left;
                }
                if (stack1.peek().val < stack2.peek().val) {
                    p1 = stack1.pop();
                    list.add(p1.val);
                    p1 = p1.right;
                } else {
                    p2 = stack2.pop();
                    list.add(p2.val);
                    p2 = p2.right;
                }
            }
            while (p1 != null || !stack1.isEmpty()) {
                while (p1 != null) {
                    stack1.push(p1);
                    p1 = p1.left;
                }
                p1 = stack1.pop();
                list.add(p1.val);
                p1 = p1.right;
            }
            while (p2 != null || !stack2.isEmpty()) {
                while (p2 != null) {
                    stack2.push(p2);
                    p2 = p2.left;
                }
                p2 = stack2.pop();
                list.add(p2.val);
                p2 = p2.right;
            }
            return list;
        }

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            LinkedList<Integer> l1 = inorder(root1);
            LinkedList<Integer> l2 = inorder(root2);
            List<Integer> list = new ArrayList<>();
            while (!l1.isEmpty() && !l2.isEmpty()) {
                if (l1.getFirst() < l2.getFirst()) {
                    list.add(l1.pollFirst());
                } else {
                    list.add(l2.pollFirst());
                }
            }
            while (!l1.isEmpty()) {
                list.add(l1.pollFirst());
            }
            while (!l2.isEmpty()) {
                list.add(l2.pollFirst());
            }
            return list;
        }

        public LinkedList<Integer> inorder(TreeNode p) {
            Stack<TreeNode> stack = new Stack<>();
            LinkedList<Integer> list = new LinkedList<>();
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
            return list;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}