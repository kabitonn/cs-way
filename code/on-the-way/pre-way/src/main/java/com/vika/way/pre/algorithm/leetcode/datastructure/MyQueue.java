package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * @author tokabi
 * @date 2019/10/25 17:06
 */
public class MyQueue {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	/** Initialize your data structure here. */
	public MyQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	/** Push element x to the back of list. */
	public void push(int x) {
		stack1.push(x);
	}

	/** Removes the element from in front of list and returns that element. */
	public int pop() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	/** Get the front element. */
	public int peek() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	/** Returns whether the list is empty. */
	public boolean empty() {
		return stack1.isEmpty()&&stack2.isEmpty();
	}
}
