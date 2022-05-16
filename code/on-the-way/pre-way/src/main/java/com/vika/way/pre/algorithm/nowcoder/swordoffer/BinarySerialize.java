package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.TreeNode;

public class BinarySerialize {
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        return root.val + "!" + Serialize(root.left) + Serialize(root.right);

    }

    int index = 0;

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] strs = str.split("!");
        return deserialize(strs);
    }

    TreeNode deserialize(String[] strs) {
        if (strs[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(strs[index++]));
        root.left = deserialize(strs);
        root.right = deserialize(strs);
        return root;
    }
}
