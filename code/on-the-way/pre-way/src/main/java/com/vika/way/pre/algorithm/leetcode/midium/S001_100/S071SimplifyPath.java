package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S071SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!strs[i].equals("") && !strs[i].equals(".")) {
                stack.push(strs[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/" + s);
        }
        return sb.toString();
    }
    public String simplifyPath1(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        String[] strs = path.split("/");
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("..")) {
                if (!wordList.isEmpty()) {
                    wordList.remove(wordList.size()-1);
                }
            } else if (!strs[i].equals("") && !strs[i].equals(".")) {
                wordList.add(strs[i]);
            }
        }
        if (wordList.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : wordList) {
            sb.append("/" + s);
        }
        return sb.toString();
    }
}
