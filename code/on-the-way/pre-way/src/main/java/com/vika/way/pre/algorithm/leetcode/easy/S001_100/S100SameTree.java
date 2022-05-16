package com.vika.way.pre.algorithm.leetcode.easy.S001_100;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class S100SameTree {

	public static void main(String[] args) {
		S100SameTree solution = new S100SameTree();
		System.out.println(solution.isSameTree1(null, null));
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null) {return true;}
		else if(p==null||q==null) {return false;}
		//else if(p==null&&q!=null) {return false;}
		//else if(p!=null&&q==null) {return false;}
        if(p.val!=q.val) {return false;}
        else {return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);}
    }
	public boolean isSameTree1(TreeNode p, TreeNode q) {
		Deque<TreeNode> stackP = new LinkedList<>();
		Deque<TreeNode> stackQ = new LinkedList<>();
		stackP.push(p);
		stackQ.push(q);
		while(!stackP.isEmpty()&&!stackQ.isEmpty()) {
			p = stackP.pop();
			q = stackQ.pop();
			if(p==null&q==null) {continue;}
			if(!isSame(p, q)) {return false;}
			stackP.push(p.left);
			stackP.push(p.right);
			stackQ.push(q.left);
			stackQ.push(q.right);
		}
        return stackP.isEmpty()&&stackQ.isEmpty();
    }
	public boolean isSame(TreeNode p, TreeNode q) {
		if(p==null&&q==null) {return true;}
		else if(p==null||q==null) {return false;}
        if(p.val!=q.val) {return false;}
        return true;
	}
}
