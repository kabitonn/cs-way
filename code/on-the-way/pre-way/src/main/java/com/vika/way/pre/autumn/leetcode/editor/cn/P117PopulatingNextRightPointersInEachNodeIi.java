//给定一个二叉树 
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 195 👎 0


//Java：填充每个节点的下一个右侧节点指针 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class P117PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        Solution solution = new P117PopulatingNextRightPointersInEachNodeIi().new Solution();
        // TO TEST
    }

    /**
     * Definition for a Node.
     */
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public Node connect(Node root) {
            return connectNext(root);
        }

        public Node connectNext(Node p) {
            if (p == null) {
                return p;
            }
            if (p.left != null && p.right != null) {
                p.left.next = p.right;
                p.right.next = nextChild(p.next);
            } else if (p.left == null && p.right != null) {
                p.right.next = nextChild(p.next);
            } else if (p.left != null && p.right == null) {
                p.left.next = nextChild(p.next);
            }
            connectNext(p.right);
            connectNext(p.left);

            return p;
        }

        public Node nextChild(Node next) {
            while (next != null) {
                if (next.left != null) {
                    return next.left;
                } else if (next.right != null) {
                    return next.right;
                } else {
                    next = next.next;
                }
            }
            return null;
        }

        public Node connect2(Node root) {
            if (root == null) {
                return root;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                Node prev = null;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node p = queue.poll();
                    if (prev != null) {
                        prev.next = p;
                    }
                    if (p.left != null) {
                        queue.offer(p.left);
                    }
                    if (p.right != null) {
                        queue.offer(p.right);
                    }
                    prev = p;
                }
            }
            return root;
        }

        public Node connect3(Node root) {
            Node node = root;
            while (node != null) {
                Node dummy = new Node();
                Node tail = dummy;
                while (node != null) {
                    if (node.left != null) {
                        tail.next = node.left;
                        tail = tail.next;
                    }
                    if (node.right != null) {
                        tail.next = node.right;
                        tail = tail.next;
                    }
                    node = node.next;
                }
                node = dummy.next;
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