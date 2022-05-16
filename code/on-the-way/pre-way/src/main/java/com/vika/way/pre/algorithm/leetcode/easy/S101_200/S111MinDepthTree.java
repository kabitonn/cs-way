package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;


public class S111MinDepthTree {
    public int minDepth(TreeNode p) {
    	if(p==null) {return 0;}
		if(p.left==null&&p.right==null) {return 1;}
		if(p.left==null) {return 1+minDepth(p.right);}
		if(p.right==null) {return 1+minDepth(p.left);}
		return 1+Math.min(minDepth(p.left), minDepth(p.right));
    }
    public int minDepth1(TreeNode root) {
    	if(root==null) {return 0;}
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> value = new LinkedList<>();
        stack.push(root);
        value.push(1);
        int depth = Integer.MAX_VALUE;
        while(!stack.isEmpty()) {
        	TreeNode pNode = stack.pop();
        	int curDepth = value.pop();
        	if(pNode.left==null&&pNode.right==null) {
        		depth = Math.min(depth, curDepth);
        	}
        	else {
        		if(pNode.left!=null) {
        			stack.push(pNode.left);
        			value.push(1+curDepth);
        		}
        		if(pNode.right!=null) {
        			stack.push(pNode.right);
        			value.push(1+curDepth);
        		}
			}
        	
        }
        return depth;
    }
    public int minDepth2(TreeNode root) {
    	if(root==null) {return 0;}
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	depth++;
        	for(int i=0;i<size;i++) {
        		TreeNode pNode = queue.poll();
        		if(pNode.left==null&&pNode.right==null) {
        			return depth;
        		}
        		else {
        			if(pNode.left!=null) {queue.add(pNode.left);}
        			if(pNode.right!=null) {queue.add(pNode.right);}
        		}
        	}
        }
        return depth;
    }
}
