package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S394DecodeString {

    public static void main(String[] args) {
        S394DecodeString solution = new S394DecodeString();
        System.out.println(solution.decodeString2("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        int[] nums = new int[s.length() / 3];
        String[] strs = new String[s.length() / 3];
        int top = 0;
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                strs[top] = "";
                nums[top] = num;
                top++;
                num = 0;
            } else if (c == ']') {
                top--;
                int k = nums[top];
                String str = strs[top];
                String tmp = str;
                for (int i = 1; i < k; i++) {
                    str += tmp;
                }
                if (top == 0) {
                    sb.append(str);
                } else {
                    strs[top - 1] = strs[top - 1] + str;
                }
            } else {
                if (top == 0) {
                    sb.append(c);
                } else {
                    strs[top - 1] = strs[top - 1] + c;
                }
            }
        }
        return sb.toString();
    }

    public String decodeString1(String s) {
        int[] nums = new int[s.length() / 3];
        String[] strs = new String[s.length() / 3];
        int top = 0;
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                nums[top] = num;
                strs[top] = sb.toString();
                top++;
                num = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                top--;
                int k = nums[top];
                String str = strs[top];
                String tmp = sb.toString();
                for (int i = 0; i < k; i++) {
                    str += tmp;
                }
                sb = new StringBuilder(str);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String decodeString2(String s) {
        return dfs(s.toCharArray());
    }

    int i = 0;

    public String dfs(char[] s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (i < s.length) {
            if (s[i] >= '0' && s[i] <= '9') {
                num = num * 10 + s[i++] - '0';
            } else if (s[i] == '[') {
                i++;
                String str = dfs(s);
                for (int k = 0; k < num; k++) {
                    sb.append(str);
                }
                num = 0;
            } else if (s[i] == ']') {
                i++;
                return sb.toString();
            } else {
                sb.append(s[i++]);
            }
        }
        return sb.toString();
    }
}
