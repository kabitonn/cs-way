package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;


public class S226InvertTree {
    public TreeNode invertTree(TreeNode p) {
        if(p==null) {return null;}
        if(p.left==null&&p.right==null) {return p;}
        TreeNode left = p.left;
        TreeNode right = p.right;
        p.right = invertTree(left);
        p.left = invertTree(right);
        return p;
    }
    public TreeNode invertTree1(TreeNode root) {
    	Deque<TreeNode> queue = new LinkedList<>();
    	if(root!=null) {queue.add(root);}
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		for(int i=0;i<size;i++) {
    			TreeNode p = queue.poll();
    			TreeNode left = p.left;
    			TreeNode right = p.right;
    			p.left = right;
    			p.right = left;
    			if(left!=null) {queue.add(left);}
    			if(right!=null) {queue.add(right);}
    		}
    	}
        return root;
    }
}
