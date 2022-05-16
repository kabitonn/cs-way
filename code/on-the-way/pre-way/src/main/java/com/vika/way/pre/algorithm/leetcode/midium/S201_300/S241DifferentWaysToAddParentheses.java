package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S241DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        return partition(input);
    }

    public List<Integer> partition(String input) {
        List<Integer> list = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            list.add(Integer.valueOf(input));
            return list;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                for (int left : partition(input.substring(0, i))) {
                    for (int right : partition(input.substring(i + 1))) {
                        if (input.charAt(i) == '+') {
                            list.add(left + right);
                        } else if (input.charAt(i) == '-') {
                            list.add(left - right);
                        } else if (input.charAt(i) == '*') {
                            list.add(left * right);
                        }
                    }
                }
            }
        }
        return list;
    }

    public List<Integer> diffWaysToCompute0(String input) {
        return partition0(input, new HashMap<String, List<Integer>>());
    }

    public List<Integer> partition0(String input, Map<String, List<Integer>> map) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                for (int left : partition0(input.substring(0, i), map)) {
                    for (int right : partition0(input.substring(i + 1), map)) {
                        if (input.charAt(i) == '+') {
                            list.add(left + right);
                        } else if (input.charAt(i) == '-') {
                            list.add(left - right);
                        } else if (input.charAt(i) == '*') {
                            list.add(left * right);
                        }
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.valueOf(input));
        }
        map.put(input, list);
        return list;
    }

    public List<Integer> diffWaysToCompute1(String input) {
        String[] numStrs = input.split("[\\+\\-\\*]");
        List<Character> opList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                opList.add(c);
            }
        }
        return partition(numStrs, opList, 0, numStrs.length - 1);
    }

    public List<Integer> partition(String[] nums, List<Character> opList, int start, int end) {
        List<Integer> list = new ArrayList<>();
        if (start == end) {
            list.add(Integer.valueOf(nums[start]));
            return list;
        }
        for (int i = start; i < end; i++) {
            for (int left : partition(nums, opList, start, i)) {
                for (int right : partition(nums, opList, i + 1, end)) {
                    char op = opList.get(i);
                    if (op == '+') {
                        list.add(left + right);
                    } else if (op == '-') {
                        list.add(left - right);
                    } else if (op == '*') {
                        list.add(left * right);
                    }
                }
            }
        }
        return list;
    }

    public List<Integer> diffWaysToCompute2(String input) {
        String[] numStrs = input.split("[\\+\\-\\*]");
        List<Character> opList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                opList.add(c);
            }
        }
        int n = numStrs.length;
        List<Integer>[][] memo = new List[n][n];
        return partition2(numStrs, opList, 0, numStrs.length - 1, memo);
    }

    public List<Integer> partition2(String[] nums, List<Character> opList, int start, int end, List<Integer>[][] memo) {
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        List<Integer> list = new ArrayList<>();
        if (start == end) {
            list.add(Integer.valueOf(nums[start]));
            memo[start][end] = list;
            return list;
        }
        for (int i = start; i < end; i++) {
            for (int left : partition2(nums, opList, start, i, memo)) {
                for (int right : partition2(nums, opList, i + 1, end, memo)) {
                    char op = opList.get(i);
                    if (op == '+') {
                        list.add(left + right);
                    } else if (op == '-') {
                        list.add(left - right);
                    } else if (op == '*') {
                        list.add(left * right);
                    }
                }
            }
        }
        memo[start][end] = list;
        return list;
    }
}
