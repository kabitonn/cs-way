//给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
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
// 示例： 
//
// 
//
// 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"ri
//ght":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right
//":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left"
//:null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":nu
//ll,"next":null,"right":null,"val":7},"val":3},"val":1}
//
//输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4
//","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next"
//:null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":
//null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":
//"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"va
//l":1}
//
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
// 
//
// 
//
// 提示： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
// Related Topics 树 深度优先搜索 
// 👍 233 👎 0


//Java：填充每个节点的下一个右侧节点指针

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class P116PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new P116PopulatingNextRightPointersInEachNode().new Solution();
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
        public Node connect1(Node root) {
            return connectNext(root);
        }

        public Node connectNext(Node r) {
            if (r == null) {
                return r;
            }
            if (r.left != null) {
                r.left.next = r.right;
                if (r.next != null) {
                    r.right.next = r.next.left;
                }
            }
            connectNext(r.left);
            connectNext(r.right);
            return r;
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

        public Node connect(Node root) {
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