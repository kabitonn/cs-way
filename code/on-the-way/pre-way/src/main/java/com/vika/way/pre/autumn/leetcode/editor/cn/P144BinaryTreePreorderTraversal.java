//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 322 👎 0


//Java：二叉树的前序遍历

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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

    class Solution {
        public List<Integer> preorderTraversal1(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            preOrder(root, list);
            return list;
        }

        void preOrder(TreeNode r, List<Integer> list) {
            if (null == r) {
                return;
            }
            list.add(r.val);
            preOrder(r.left, list);
            preOrder(r.right, list);
        }

        public List<Integer> preorderTraversal2(TreeNode root) {
            if (null == root) {
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode p = stack.pop();
                list.add(p.val);
                if (null != p.right) {
                    stack.push(p.right);
                }
                if (null != p.left) {
                    stack.push(p.left);
                }
            }
            return list;
        }

        public List<Integer> preorderTraversal(TreeNode root) {
            if (null == root) {
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            while (null != p || !stack.isEmpty()) {
                while (null != p) {
                    list.add(p.val);
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                p = p.right;
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}