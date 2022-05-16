package com.vika.way.pre.algorithm.leetcode.easy.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.*;

public class S107LevelOrderBottomTree {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	LinkedList<List<Integer>> lines = new LinkedList<>();
    	if(root==null) {return lines;}
    	Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
        	List<Integer> line = new ArrayList<>();
            int size = queue.size();
        	for(int i=0;i<size;i++) {
        		TreeNode pNode = queue.poll();
        		line.add(pNode.val);
        		if(pNode.left!=null) {	queue.add(pNode.left);}
        		if(pNode.right!=null) {	queue.add(pNode.right);}
        	}
        	//lines.add(line);
        	lines.push(line);
        }
        //Collections.reverse(lines);
        return lines;
    }
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
    	List<List<Integer>> lines = new ArrayList<>();
    	if(root==null) {return lines;}
    	levelOrder(root, lines, 0);
    	Collections.reverse(lines);
    	return lines;
    }
    public void levelOrder(TreeNode p, List<List<Integer>> lines, int depth) {
    	if(p==null) {return;}
    	if(depth+1>lines.size()) {
    		lines.add(new ArrayList<>());
    	}
    	List<Integer> line = lines.get(depth);
    	line.add(p.val);
    	levelOrder(p.left, lines, depth+1);
    	levelOrder(p.right, lines, depth+1);
    	
    }
}
