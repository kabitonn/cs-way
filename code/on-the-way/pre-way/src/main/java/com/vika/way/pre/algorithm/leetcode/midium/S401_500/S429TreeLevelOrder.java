package com.vika.way.pre.algorithm.leetcode.midium.S401_500;


import com.vika.way.pre.algorithm.leetcode.common.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S429TreeLevelOrder {
	public List<List<Integer>> levelOrder(Node root) {
		Deque<Node> queue = new LinkedList<>();
		List<List<Integer>> lists = new ArrayList<>();
		if(root==null) {return lists;}
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<size;i++) {
				Node node = queue.poll();
				list.add(node.val);
				for(Node n:node.children) {
					queue.add(n);
				}
			}
			lists.add(list);
		}
		return lists;
	}
	public List<List<Integer>> levelOrder1(Node root) {
		List<List<Integer>> lists = new ArrayList<>();
		if(root==null) {return lists;}
		getLists(lists,0,root);
		return lists;
	}
	public void getLists(List<List<Integer>> lists, int depth, Node pNode) {
		if(depth==lists.size()) {
			lists.add(new ArrayList<>());
		}
		lists.get(depth).add(pNode.val);
		for(Node n:pNode.children) {
			getLists(lists, depth+1, n);
		}
	}
	
}
