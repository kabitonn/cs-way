//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder =[3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 192 👎 0


//Java：重建二叉树

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P剑指07重建二叉树 {
    public static void main(String[] args) {
        Solution solution = new P剑指07重建二叉树().new Solution();
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
        public TreeNode buildTree1(int[] preorder, int[] inorder) {
            int n = preorder.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(preorder, 0, n - 1, 0, n - 1, map);
        }

        public TreeNode buildTree(int[] preorder, int preL, int preR, int inL, int inR, Map<Integer, Integer> map) {
            if (preL > preR) {
                return null;
            }
            int root = preorder[preL];
            TreeNode node = new TreeNode(root);
            int index = map.get(root);
            int left = index - inL;
            node.left = buildTree(preorder, preL + 1, preL + left, inL, index - 1, map);
            node.right = buildTree(preorder, preL + left + 1, preR, index + 1, inR, map);
            return node;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) {
                return null;
            }
            int n = preorder.length;
            int in = 0;
            TreeNode root = new TreeNode(preorder[0]);
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            for (int i = 1; i < n; i++) {
                TreeNode node = new TreeNode(preorder[i]);
                TreeNode back = null;
                while (!stack.isEmpty() && stack.peek().val == inorder[in]) {
                    in++;
                    back = stack.pop();
                }
                if (back == null) {
                    stack.peek().left = node;
                } else {
                    back.right = node;
                }
                stack.push(node);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(root);
    }
}