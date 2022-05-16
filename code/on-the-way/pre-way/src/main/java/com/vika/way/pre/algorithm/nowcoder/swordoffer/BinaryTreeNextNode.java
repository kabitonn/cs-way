package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.TreeLinkNode;

public class BinaryTreeNextNode {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            TreeLinkNode node = pNode;
            while (node != null) {
                TreeLinkNode parent = node.next;
                if (parent != null && parent.left == node) {
                    return parent;
                }
                node = parent;
            }
            return node;
        }
    }
}
