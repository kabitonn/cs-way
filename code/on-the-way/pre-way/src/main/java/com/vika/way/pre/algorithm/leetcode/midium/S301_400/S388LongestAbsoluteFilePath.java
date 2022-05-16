package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S388LongestAbsoluteFilePath {

    public static void main(String[] args) {
        S388LongestAbsoluteFilePath solution = new S388LongestAbsoluteFilePath();
        System.out.println(solution.lengthLongestPath("a\n\tb.txt\na2\n\tb2.txt"));
    }

    public int lengthLongestPath(String input) {
        input = input.replace("\n    ", "\n\t");
        String[] strs = input.split("\n");
        Integer[] levelStack = new Integer[strs.length];
        int top = 0;
        int max = 0;
        for (String str:strs) {
            int len = str.length();
            int j = 0;
            while (str.charAt(j) == '\t') {
                j++;
            }
            if (j <= top) {
                while (j < top) {
                    top--;
                }
                if (top == 0) {
                    levelStack[top++] = len;
                } else {
                    levelStack[top] = levelStack[top - 1] + len - j;
                    top++;
                }
                if (str.contains(".")) {
                    max = Math.max(max, levelStack[top - 1] + top - 1);
                }
            }

        }
        return max;
    }
}
