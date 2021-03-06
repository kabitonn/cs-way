package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 225. 用队列实现栈
 * @author tokabi
 * @date 2019/10/25 17:06
 */
public class MyStack {

	
	private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        while(size-->1){
        	queue.offer(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
        
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}