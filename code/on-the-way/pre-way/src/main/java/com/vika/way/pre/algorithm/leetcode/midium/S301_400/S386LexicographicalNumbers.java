package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class S386LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = String.valueOf(i + 1);
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (String num : nums) {
            list.add(Integer.valueOf(num));
        }
        return list;
    }

    public List<Integer> lexicalOrder1(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            lexicalOrder1(n, i, list);
        }
        return list;
    }

    public void lexicalOrder1(int n, int min, List<Integer> list) {
        if (min > n) {
            return;
        }
        list.add(min);
        for (int i = 0; i <= 9; i++) {
            lexicalOrder1(n, min * 10 + i, list);
        }
    }

    public List<Integer> lexicalOrder2(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = Math.min(n, 9); i >= 1; i--) {
            stack.push(i);
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            int num = stack.pop();
            list.add(num);
            for (int i = 9; i >= 0; i--) {
                int tmp = num * 10 + i;
                if (tmp <= n) {
                    stack.push(tmp);
                }
            }
        }
        return list;
    }

    public List<Integer> lexicalOrder3(int n) {
        List<Integer> list = new ArrayList<>(n);
        int num = 1;
        for (int i = 0; i < n; i++) {
            list.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                if (num >= n) {
                    num /= 10;
                }
                num++;
                while (num % 10 == 0) {
                    num /= 10;
                }
            }
        }
        return list;
    }
}
