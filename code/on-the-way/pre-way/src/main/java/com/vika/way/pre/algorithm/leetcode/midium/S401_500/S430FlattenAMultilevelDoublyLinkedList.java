package com.vika.way.pre.algorithm.leetcode.midium.S401_500;


import java.util.Stack;

public class S430FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        Node node = head;
        while (node != null) {
            Node next = node.next;
            if (node.child != null) {
                node.next = flatten(node.child);
                node.child = null;
                node.next.prev = node;
                while (node.next != null) {
                    node = node.next;
                }
                node.next = next;
                if (next != null) {
                    next.prev = node;
                }
            }
            node = next;
        }
        return head;
    }

    public Node flatten2(Node head) {
        Node node = head;
        while (node != null) {
            if (node.child != null) {
                Node next = node.next;
                node.next = node.child;
                node.next.prev = node;
                node.child = null;
                Node last = node.next;
                while (last.next != null) {
                    last = last.next;
                }
                if (next != null) {
                    last.next = next;
                    next.prev = last;
                }
            }
            node = node.next;
        }
        return head;
    }

    public Node flatten_1(Node head) {
        if (head == null) {
            return null;
        }
        dfs(head);
        head.prev = null;
        return head;
    }

    public Node dfs(Node head) {
        Node node = head;
        while (node != null) {
            head.prev = node;
            Node next = node.next;
            if (node.child != null) {
                Node newHead = dfs(node.child);
                Node tail = newHead.prev;
                node.child = null;
                node.next = newHead;
                newHead.prev = node;
                tail.next = next;
                if (next != null) {
                    next.prev = tail;
                }
                head.prev = tail;
            }
            node = next;
        }
        return head;
    }


    /**
     * 前序遍历列表化
     *
     * @param head
     * @return midium.S401_500.S430FlattenAMultilevelDoublyLinkedList.Node
     * @date 2019/11/12 10:45
     */
    public Node flatten1(Node head) {
        if (head == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node node = head;
        Node prev = null;
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (prev != null) {
                prev.next = node;
                node.prev = prev;
            }
            prev = node;
            if (node.next != null) {
                stack.push(node.next);
            }
            if (node.child != null) {
                stack.push(node.child);
                node.child = null;
            }
        }

        return head;
    }


}
