package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

public class S402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k > num.length()) {
            return "0";
        }
        for (int i = 0; i < k && num.length() > 0; i++) {
            boolean remove = false;
            for (int j = 0; j < num.length() - 1; j++) {
                if (num.charAt(j) > num.charAt(j + 1)) {
                    num = num.substring(0, j) + num.substring(j + 1);
                    remove = true;
                    break;
                }
            }
            if (!remove) {
                num = num.substring(0, num.length() - (k - i));
                break;
            }
            int j = 0;
            while (j < num.length() && num.charAt(j) == '0') {
                j++;
            }
            num = num.substring(j);
        }
        return num.length() == 0 ? "0" : num;
    }

    public String removeKdigits1(String num, int k) {
        char[] stack = new char[num.length()];
        int top = 0;
        for (char c : num.toCharArray()) {
            while (top > 0 && k > 0 && stack[top - 1] > c) {
                top--;
                k--;
            }
            stack[top++] = c;
        }
        while (top > 0 && k > 0) {
            top--;
            k--;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < top && stack[i] == '0') {
            i++;
        }
        while (i < top) {
            sb.append(stack[i++]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        S402RemoveKDigits solution = new S402RemoveKDigits();
        System.out.println(solution.removeKdigits("11222", 5));
    }
}
