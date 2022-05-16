package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 *
 * @author tokabi
 * @date 2019/10/29 15:35
 */
public class NestedIterator_1 implements Iterator<Integer> {

    Integer[] elementData;
    int capacity;
    int size;
    int top;

    public NestedIterator_1(List<NestedInteger> nestedList) {
        capacity = 2 << 4;
        elementData = new Integer[capacity];
        dfs(nestedList);
        top = 0;
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                elementData[size++] = nested.getInteger();
                if (size == capacity) {
                    grow();
                }
            } else {
                dfs(nested.getList());
            }
        }
    }

    private void grow() {
        capacity = capacity << 2;
        elementData = Arrays.copyOf(elementData, capacity);
    }

    @Override
    public Integer next() {
        return elementData[top++];
    }

    @Override
    public boolean hasNext() {
        return top != size;
    }
}
