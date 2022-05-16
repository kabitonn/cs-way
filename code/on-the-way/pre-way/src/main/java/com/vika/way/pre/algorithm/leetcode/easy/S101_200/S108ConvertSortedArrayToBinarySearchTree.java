package com.vika.way.pre.algorithm.leetcode.easy.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

public class S108ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        S108ConvertSortedArrayToBinarySearchTree solution = new S108ConvertSortedArrayToBinarySearchTree();
        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(solution.sortedArrayToBST(nums));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        //int mid = start + (end - start) / 2;
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }

}
