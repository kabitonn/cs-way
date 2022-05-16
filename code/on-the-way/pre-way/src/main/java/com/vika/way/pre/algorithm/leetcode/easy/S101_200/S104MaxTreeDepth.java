package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;


public class S104MaxTreeDepth {
    public int maxDepth(TreeNode p) {
    	if(p==null) {return 0;}
        return 1+Math.max(maxDepth(p.left),maxDepth(p.right));
    }
    public int maxDepth1(TreeNode root) {
    	if(root==null) {return 0;}
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	depth++;
        	for(int i=0;i<size;i++) {
        		TreeNode pNode = queue.poll();
        		if(pNode.left!=null) {queue.add(pNode.left);}
        		if(pNode.right!=null) {queue.add(pNode.right);}
        	}
        }
        return depth;
    }
    public int maxDepth2(TreeNode root) {
    	if(root==null) {return 0;}
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<Integer> value = new LinkedList<>();
        queue.push(root);
        value.push(1);
        int depth = 0;
        while(!queue.isEmpty()) {
        	TreeNode pNode = queue.pop();
        	int curDepth = value.pop();
        	depth = Math.max(depth, curDepth);
        	if(pNode.left!=null) {
        		queue.push(pNode.left);
        		value.push(1+curDepth);
        	}
        	if(pNode.right!=null) {
        		queue.push(pNode.right);
        		value.push(1+curDepth);
        	}
        	
        }
        return depth;
    }
}
