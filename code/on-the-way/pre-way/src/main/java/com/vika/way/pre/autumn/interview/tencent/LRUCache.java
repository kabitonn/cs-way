package com.vika.way.pre.autumn.interview.tencent;

/**
 * @author ：tangjiawei
 * @date ：2020/9/12 22:27
 */

/**
 * 2.实现一个基于Hash的全内存LRU cache，插入时，发现节点个数超过阈值，则按照全局最近最少使用淘汰节点。
 * 采用链地址法解决Hash冲突：Hash桶个数固定为1千万，最多只能存储1亿个的节点，每个节点的key和value都为uint32_t。
 * Struct Node｛
 * uint32_t iKey;
 * uint32_t iElem;
 * 其它字段 ...
 * };
 * 请分别实现Insert，Get接口。
 */
public class LRUCache {

    class Node {
        int key;
        int value;
        Node after;
        Node before;
        Node next;
        Node prev;

        public Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    int capacity = 10000000;
    Node[] bucket = new Node[capacity];
    int thresh = 100000000;
    int size = 0;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public LRUCache() {
        head.next = tail;
        tail.prev = head;
    }

    public void insert(int k, int v) {
        int key = indexFor(k);
        Node node = new Node(k, v);
        Node p = bucket[key];
        if (p == null) {
            bucket[key] = node;
            if (size == thresh) {
                removeLast();
            }
        } else if (p.key == key) {
            removeNode(p);
            p.after.before = node;
            node.after = p.after;
            bucket[key] = node;
        } else {
            while (p.after != null && p.after.key != key) {
                p = p.after;
            }
            if (p.after != null) {
                removeNode(p.after);
                p.after.before = node;
                node.after = p.after.after;
            } else if (size == thresh) {
                removeLast();
            }
            p.after = node;
            node.before = p;
        }
        addNode(node);
    }

    public int get(int k) {
        int key = indexFor(k);
        Node p = bucket[k];

        while (p != null && p.key != key) {
            p = p.after;
        }
        if (p != null) {
            moveToHead(p);
            return p.value;
        }
        return -1;

    }

    public void moveToHead(Node p) {
        removeNode(p);
        addNode(p);
    }

    public void removeNode(Node p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        size--;
    }

    public void addNode(Node p) {
        p.next = head.next;
        p.prev = head;
        head.next.prev = p;
        head.next = p;
        size++;
    }

    public Node removeLast() {
        Node p = tail.prev;
        if (p.before == null) {
            int key = indexFor(p.key);
            bucket[key] = p.after;
        } else {
            p.before.after = p.after;
        }
        return p;
    }

    public int indexFor(int key) {
        return hash(key) % capacity;
    }

    public int hash(int key) {
        return key ^ (key >> 16);
    }
}
