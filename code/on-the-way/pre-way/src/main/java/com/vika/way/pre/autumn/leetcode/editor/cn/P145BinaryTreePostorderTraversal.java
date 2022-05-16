//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 353 👎 0


//Java：二叉树的后序遍历

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class P145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal1(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            postOrder(root, list);
            return list;
        }

        void postOrder(TreeNode r, List<Integer> list) {
            if (null == r) {
                return;
            }
            postOrder(r.left, list);
            postOrder(r.right, list);
            list.add(r.val);
        }

        public List<Integer> postorderTraversal2(TreeNode root) {
            if (null == root) {
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode p = stack.pop();
                list.add(p.val);
                if (null != p.left) {
                    stack.push(p.left);
                }
                if (null != p.right) {
                    stack.push(p.right);
                }
            }
            Collections.reverse(list);
            return list;
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            if (null == root) {
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            TreeNode p = root;
            while (null != p || !stack.isEmpty()) {
                while (null != p) {
                    stack.push(p);
                    p = p.left;
                }
                p = stack.peek();
                if (null == p.right || pre == p.right) {
                    list.add(p.val);
                    pre = p;
                    stack.pop();
                    p = null;
                } else {
                    p = p.right;
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}