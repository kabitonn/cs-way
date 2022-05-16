package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    DoubleListNode head, tail;
    Map<Integer, DoubleListNode> cache;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>();
        head = new DoubleListNode(-1, -1);
        tail = new DoubleListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        if (cache.containsKey(key)) {
            DoubleListNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        DoubleListNode node = new DoubleListNode(key, value);
        if (cache.containsKey(key)) {
            removeNode(cache.get(key));
        } else {
            if (size == capacity) {
                DoubleListNode last = removeLast();
                cache.remove(last.key);
            }
        }
        addNode(node);
        cache.put(key, node);
    }

    public void addNode(DoubleListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void removeNode(DoubleListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public void moveToHead(DoubleListNode node) {
        removeNode(node);
        addNode(node);
    }

    public DoubleListNode removeLast() {
        if (tail.prev == null) {
            return null;
        }
        DoubleListNode last = tail.prev;
        removeNode(last);
        return last;
    }

    class DoubleListNode {
        public int key;
        public int value;
        public DoubleListNode prev;
        public DoubleListNode next;

        public DoubleListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
