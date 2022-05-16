package com.vika.way.pre.autumn.interview.tencent;

import java.util.Arrays;

/**
 * @author ：tangjiawei
 * @date ：2020/9/7 19:48
 */
public class MinHeap {

    int[] heap;
    int size;

    public MinHeap(int n) {
        heap = new int[n];
        size = 0;
    }

    public void add(int v) {
        heap[size++] = v;
        adjustUpMin(size - 1);
    }

    public int pop() {
        if (size <= 0) {
            return -1;
        }
        int min = heap[0];
        swap(0, --size);
        adjustDownMin(0);
        return min;
    }

    public void adjustDownMin(int node) {
        int left = node * 2 + 1;
        int right, min;
        while (left < size) {
            right = left + 1;
            min = right < size && heap[right] < heap[left] ? right : left;
            if (heap[min] >= heap[node]) {
                break;
            }
            swap(min, node);
            node = min;
            left = node * 2 + 1;
        }
    }

    public void adjustUpMin(int node) {
        int root;
        while (node > 0) {
            root = (node - 1) / 2;
            if (heap[root] < heap[node]) {
                break;
            }
            swap(node, root);
            node = root;
        }
    }

    public void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "heap=" + Arrays.toString(heap) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.add(7);
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(0);
        minHeap.add(4);
        minHeap.add(5);
        System.out.println(minHeap);
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
    }
}
