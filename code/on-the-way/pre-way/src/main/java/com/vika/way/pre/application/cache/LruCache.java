package com.vika.way.pre.application.cache;


import org.junit.Test;

/**
 * 实现一个基于Hash的全内存LRU cache，
 * 插入时，发现节点个数超过阈值，则按照全局最近最少使用淘汰节点。
 * 采用链地址法解决Hash冲突：Hash桶个数固定为1千万，最多只能存储1亿个的节点，
 */
public class LruCache {

    class Node {
        int key;
        int value;
        Node before;
        Node after;
        Node next;
        Node prev;

        public Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    Node head, tail;
    final int capacity = 10;
    final int total = 5;
    int size = 0;
    Node[] bucket = new Node[capacity];

    public LruCache() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        int k = hash(key);
        Node p;
        if ((p = bucket[k]) == null) {
            bucket[k] = node;
            if (size == total) {
                removeLast();
            }
        } else if (p.key == key) {
            removeNode(p);
            node.after = p.after;
            p.after.before = node;
            bucket[k] = node;
        } else {
            while (p.after != null && p.after.key != key) {
                p = p.after;
            }
            if (p.after != null) {
                node.after = p.after.after;
                p.after.before = node;
                removeNode(p.after);
            } else if (size == total) {
                removeLast();
            }
            p.after = node;
            node.before = p;
        }
        addNode(node);
    }

    public Integer get(int key) {
        int index = hash(key);
        Node p = bucket[index];
        while (p != null && p.key != key) {
            p = p.after;
        }
        if (p != null) {
            moveToHead(p);
            return p.value;
        } else {
            return null;
        }
    }

    public void removeLast() {
        Node remove = tail.prev;
        if (remove.before != null) {
            remove.before.after = remove.after;
        } else {
            int k = hash(remove.key);
            bucket[k] = remove.after;
        }
        removeNode(remove);
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    public void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public int hash(int key) {
        return key ^ (key >>> 16);
    }

    @Test
    public void test() {
        put(1, 1);
        put(2, 2);
        put(3, 3);
        put(4, 4);
        put(5, 5);
        System.out.println(get(1));
        put(6, 6);
        put(7, 7);
        System.out.println(get(2));
        System.out.println(get(3));
        System.out.println(get(1));


    }
}
