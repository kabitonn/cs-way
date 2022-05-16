//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。 
//
// 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
// Related Topics 栈 设计 
// 👍 131 👎 0


//Java：扁平化嵌套列表迭代器

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class P341FlattenNestedListIterator {
    public static void main(String[] args) {
        // TO TEST
    }

    interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return null if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    //leetcode submit region begin(Prohibit modification and deletion)

    public class NestedIterator implements Iterator<Integer> {
        /*
        Queue<Integer> queue = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    queue.offer(nestedInteger.getInteger());
                } else {
                    dfs(nestedInteger, queue);
                }
            }
        }

        void dfs(NestedInteger nestedInteger, Queue<Integer> queue) {
            for (NestedInteger integer : nestedInteger.getList()) {
                if (integer.isInteger()) {
                    queue.offer(integer.getInteger());
                } else {
                    dfs(integer, queue);
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
        */
        Stack<Iterator<NestedInteger>> stack;
        Integer num = null;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            if (null != nestedList) {
                stack.push(nestedList.iterator());
            }
        }

        @Override
        public Integer next() {
            while (null == num && !stack.isEmpty()) {
                Iterator<NestedInteger> iterator = stack.peek();
                if (!iterator.hasNext()) {
                    stack.pop();
                } else {
                    NestedInteger nestedInteger = iterator.next();
                    if (nestedInteger.isInteger()) {
                        num = nestedInteger.getInteger();
                        iterator.remove();
                        break;
                    } else {
                        stack.push(nestedInteger.getList().iterator());
                        iterator.remove();
                    }
                }
            }
            int value = num;
            num = null;
            return value;
        }

        @Override
        public boolean hasNext() {
            while (null == num && !stack.isEmpty()) {
                Iterator<NestedInteger> iterator = stack.peek();
                if (!iterator.hasNext()) {
                    stack.pop();
                } else {
                    NestedInteger nestedInteger = iterator.next();
                    if (nestedInteger.isInteger()) {
                        num = nestedInteger.getInteger();
                        iterator.remove();
                        break;
                    } else {
                        stack.push(nestedInteger.getList().iterator());
                        iterator.remove();
                    }
                }
            }
            return null != num;
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}