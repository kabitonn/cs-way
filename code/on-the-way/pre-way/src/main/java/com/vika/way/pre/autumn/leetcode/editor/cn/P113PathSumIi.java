//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 305 👎 0


//Java：路径总和 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P113PathSumIi {
    public static void main(String[] args) {
        Solution solution = new P113PathSumIi().new Solution();
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
        public List<List<Integer>> pathSum1(TreeNode root, int sum) {
            List<List<Integer>> listList = new ArrayList<>();
            pathSum(listList, new ArrayList<>(), root, sum);
            return listList;
        }

        public void pathSum(List<List<Integer>> listList, List<Integer> list, TreeNode p, int sum) {
            if (p == null) {
                return;
            }
            sum -= p.val;
            list.add(p.val);
            if (p.left == null && p.right == null && sum == 0) {
                listList.add(new ArrayList<>(list));
            }
            pathSum(listList, list, p.left, sum);
            pathSum(listList, list, p.right, sum);
            list.remove(list.size() - 1);
        }

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> listList = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            TreeNode prev = null;
            int leftSum = sum;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    list.add(p.val);
                    leftSum -= p.val;
                    p = p.left;
                }
                p = stack.peek();
                if (p.left == null && p.right == null && leftSum == 0) {
                    listList.add(new ArrayList<>(list));
                }
                if (p.right == null || prev == p.right) {
                    p = stack.pop();
                    prev = p;
                    leftSum += p.val;
                    list.remove(list.size() - 1);
                    p = null;
                } else {
                    p = p.right;
                }
            }
            return listList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}