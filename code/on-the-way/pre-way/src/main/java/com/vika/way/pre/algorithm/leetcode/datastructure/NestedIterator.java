package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

/**
 * 341. 扁平化嵌套列表迭代器
 *
 * @author tokabi
 * @date 2019/10/29 15:35
 */
public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        dfs(nestedList);
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                queue.add(nested.getInteger());
            } else {
                dfs(nested.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
