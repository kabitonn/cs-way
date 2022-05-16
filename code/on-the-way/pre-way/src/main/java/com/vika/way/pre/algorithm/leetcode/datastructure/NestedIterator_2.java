package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 *
 * @author tokabi
 * @date 2019/10/29 15:35
 */
public class NestedIterator_2 implements Iterator<Integer> {

    LinkedList<Iterator<NestedInteger>> stack;
    Integer num = null;

    public NestedIterator_2(List<NestedInteger> nestedList) {
        stack = new LinkedList<>();
        stack.push(nestedList.iterator());
    }


    @Override
    public Integer next() {
        while (!stack.isEmpty() && num == null) {
            Iterator<NestedInteger> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
            } else {
                NestedInteger next = iterator.next();
                if (next.isInteger()) {
                    num = next.getInteger();
                    iterator.remove();
                    break;
                } else {
                    stack.push(next.getList().iterator());
                    iterator.remove();
                }
            }
        }
        Integer tmp = num;
        num = null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
            } else {
                NestedInteger next = iterator.next();
                if (next.isInteger()) {
                    num = next.getInteger();
                    iterator.remove();
                    break;
                } else {
                    stack.push(next.getList().iterator());
                    iterator.remove();
                }
            }
        }
        return num != null;
    }
}
