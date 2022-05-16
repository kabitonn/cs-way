package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.Stack;


public class S404SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		if(root==null) {return 0;}
		if(root.left!=null&&root.left.left==null&&root.left.right==null) {return root.left.val+sumOfLeftLeaves(root.right);}
		return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
	}
	public int sumOfLeftLeaves1(TreeNode root) {
        if(root==null) {return 0;}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		int sum = 0;
		while(!stack.isEmpty()) {
			TreeNode pNode = stack.pop();
			if(pNode==null) {continue;}
			if(pNode.left!=null&&pNode.left.left==null&&pNode.left.right==null) {
				sum+=pNode.left.val;
				stack.push(pNode.right);
			}
			else {
				stack.push(pNode.left);
				stack.push(pNode.right);
			}

		}
		return sum;
    }
	public int sumOfLeftLeaves2(TreeNode root) {
		if(root==null) {return 0;}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		int sum = 0;
		while(!stack.isEmpty()) {
			TreeNode pNode = stack.pop();
			if(pNode.left!=null) {
				if(pNode.left.left==null&&pNode.left.right==null) {
					sum+=pNode.left.val;
				}
				else {
					stack.push(pNode.left);
				}
			}
			if(pNode.right!=null) {
				stack.push(pNode.right);
			}

		}
		return sum;
	}
}
