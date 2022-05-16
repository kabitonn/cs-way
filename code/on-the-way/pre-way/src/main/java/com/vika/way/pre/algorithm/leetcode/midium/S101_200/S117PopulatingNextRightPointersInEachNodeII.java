package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

import java.util.LinkedList;
import java.util.Queue;

public class S117PopulatingNextRightPointersInEachNodeII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect0(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left != null || root.right != null) {
            if (root.left != null) {
                root.left.next = root.right;
            }
            Node pre = root.left;
            if (root.right != null) {
                pre = root.right;
            }
            Node next = root.next, conn = null;
            while (next != null && next.left == null && next.right == null) {
                next = next.next;
            }
            if (next != null) {
                if (next.left != null) {
                    conn = next.left;
                } else {
                    conn = next.right;
                }
            }
            pre.next = conn;
        }
        connect0(root.right);
        connect0(root.left);
        return root;
    }

    //先构造右子树的next,否则父节点的兄弟节点会寻找出错
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = nextNode(root.next);
        } else if (root.left == null && root.right != null) {
            root.right.next = nextNode(root.next);
        } else if (root.left != null && root.right == null) {
            root.left.next = nextNode(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node nextNode(Node next) {
        Node conn = null;
        while (next != null) {
            if (next.left != null) {
                conn = next.left;
                break;
            }
            if (next.right != null) {
                conn = next.right;
                break;
            }
            next = next.next;
        }
        return conn;
    }

    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node pre = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node p = queue.poll();
                if (pre != null) {
                    pre.next = p;
                }
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
                pre = p;
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        Node start = root;
        Node cur = null;
        while (start != null) {
            cur = start;
            while (cur != null) {
                //找到至少有一个孩子的节点
                if (cur.left == null && cur.right == null) {
                    cur = cur.next;
                    continue;
                }
                if (cur.left != null && cur.right != null) {
                    cur.left.next = cur.right;
                }
                Node pre = cur.right == null ? cur.left : cur.right;
                Node next = cur.next, conn = null;
                //找到当前节点的下一个至少有一个孩子的节点
                while (next != null && next.left == null && next.right == null) {
                    next = next.next;
                }
                if (next != null) {
                    if (next.left != null) {
                        conn = next.left;
                    } else {
                        conn = next.right;
                    }
                }
                pre.next = conn;
                cur = next;
            }
            //找到拥有孩子的节点
            while (start != null && start.left == null && start.right == null) {
                start = start.next;
            }
            if (start == null) {
                break;
            }
            //进入下一层
            start = start.left != null ? start.left : start.right;
        }
        return root;
    }

    Node connect3(Node root) {
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node();
            Node tail = dummy;
            //遍历 cur 的当前层
            while (cur != null) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            //更新 cur 到下一层
            cur = dummy.next;
        }
        return root;
    }
}
