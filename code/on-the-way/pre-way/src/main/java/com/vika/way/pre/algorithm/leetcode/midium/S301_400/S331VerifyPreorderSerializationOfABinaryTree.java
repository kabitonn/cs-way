package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class S331VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        int n = strs.length;
        if (n == 0) {
            return false;
        }
        int[] visited = new int[n];
        int[] stack = new int[n + 1];
        int top = 0;
        int index = 0;
        stack[top++] = index++;
        while (index <= n) {
            int node = stack[top - 1];
            if ("#".equals(strs[node]) || visited[node] == 2) {
                if (--top == 0) {
                    break;
                }
                visited[stack[top - 1]]++;
            } else {
                stack[top++] = index++;
            }

        }
        return index == n;
    }

    public boolean isValidSerialization_0(String preorder) {
        String[] strs = preorder.split(",");
        int n = strs.length;
        if (n == 0) {
            return false;
        }
        String[] stack = new String[n + 1];
        int top = 0;
        for (String s : strs) {
            while (top > 0 && "#".equals(stack[top - 1]) && "#".equals(s)) {
                if (--top == 0) {
                    return false;
                }
                top--;
            }
            stack[top++] = s;
        }
        return top == 1 && "#".equals(stack[top - 1]);
    }

    public boolean isValidSerialization0(String preorder) {
        String[] strs = preorder.split(",");
        int n = strs.length;
        if (n == 0) {
            return false;
        }
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.push(index++);
        while (index <= n) {
            int node = stack.peek();
            if ("#".equals(strs[node]) || visited[node] == 2) {
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                visited[stack.peek()]++;
            } else {
                stack.push(index++);
            }
        }
        return index == n;
    }

    static final Pattern pattern = Pattern.compile("[^,#]+,#,#");

    public boolean isValidSerialization1(String preorder) {
        Matcher matcher = pattern.matcher(preorder);
        while (!"#".equals(preorder) && matcher.find()) {
            preorder = matcher.replaceAll("#");
            matcher = pattern.matcher(preorder);
        }
        return "#".equals(preorder);
    }

    //读取到的结构只要符合二叉树性质而且不会在未读完之前就满足leaves = nodes + 1（完整的二叉树）即可
    public boolean isValidSerialization2(String preorder) {
        String[] strs = preorder.split(",");
        int n = strs.length;
        if (n == 0) {
            return false;
        }
        int leaves = 0;
        int nodes = 0;
        int i = 0;
        for (String s : strs) {
            if ("#".equals(s)) {
                leaves++;
            } else {
                nodes++;
            }
            i++;
            if (leaves > nodes + 1 || (i < n && leaves == nodes + 1)) {
                break;
            }
        }
        if (i == n && leaves == nodes + 1) {
            return true;
        } else {
            return false;
        }
    }
}
