package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 284. 顶端迭代器
 *
 * @author tokabi
 * @date 2019/10/27 20:23
 */
public class PeekingIterator_1 implements Iterator<Integer> {

    Integer[] elementData;
    int capacity;
    int size;
    int top = 0;

    public PeekingIterator_1(Iterator<Integer> iterator) {
        // initialize any member here.
        capacity = 2 << 4;
        elementData = new Integer[capacity];
        size = 0;
        while (iterator.hasNext()) {
            elementData[size++] = iterator.next();
            if (size == capacity) {
                grow();
            }
        }


    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return elementData[top];
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return elementData[top++];
    }

    @Override
    public boolean hasNext() {
        return top != size;
    }

    private void grow() {
        capacity = capacity << 2;
        elementData = Arrays.copyOf(elementData, capacity);
    }
}
