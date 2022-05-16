//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 657 👎 0


//Java：从前序与中序遍历序列构造二叉树

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
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
                TreeNode node = new TreeNode(preorder[pre]);
                TreeNode back = null;
                while (!stack.isEmpty() && stack.peek().val == inorder[in]) {
                    back = stack.pop();
                    in++;
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

    }
}