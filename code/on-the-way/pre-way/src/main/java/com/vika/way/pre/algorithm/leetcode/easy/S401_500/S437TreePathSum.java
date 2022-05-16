package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.HashMap;


public class S437TreePathSum {
    public int pathSum(TreeNode root, int sum) {
    	if(root==null) {return 0;}
        return getPathSum(root, sum)+pathSum(root.left,sum)+pathSum(root.right, sum);
    }

    public int getPathSum( TreeNode pNode, int sum) {
		if(pNode==null) {return 0;}
		sum -= pNode.val;
		return (sum==0?1:0)+getPathSum( pNode.left, sum)+getPathSum( pNode.right, sum);
	}
    public int pathSum1(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        return getPathSum1(root, map, sum, 0);
    }
    
    int getPathSum1(TreeNode pNode, HashMap<Integer, Integer> map, int target, int pathSum){
        int paths = 0;
        if(pNode == null) {
            return 0;
        }
        
        pathSum += pNode.val;
        paths += map.getOrDefault(pathSum - target, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        paths = getPathSum1(pNode.left, map, target, pathSum) + getPathSum1(pNode.right, map, target, pathSum) + paths;
        map.put(pathSum, map.get(pathSum) - 1);
        return paths;
    }
}