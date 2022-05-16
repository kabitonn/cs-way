package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.Iterator;

/**
 * 284. 顶端迭代器
 *
 * @author tokabi
 * @date 2019/10/25 16:55
 */
public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer top = null;


    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            top = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return top;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer r = top;
        if (iterator.hasNext()) {
            top = iterator.next();
        } else {
            top = null;
        }
        return r;
    }

    @Override
    public boolean hasNext() {
        return top != null;
    }
}

