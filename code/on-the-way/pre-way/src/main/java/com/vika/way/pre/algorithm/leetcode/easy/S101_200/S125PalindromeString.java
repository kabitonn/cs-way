package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

public class S125PalindromeString {
    public static void main(String[] args) {
        S125PalindromeString solution = new S125PalindromeString();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome1(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] str = s.toUpperCase().toCharArray();
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(str[i])) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(str[j])) {
                j--;
            }
            if (str[i] != str[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] str = s.toCharArray();
        while (i < j) {
            if (!isLetterOrDigit(str[i])) {
                i++;
                continue;
            }
            if (!isLetterOrDigit(str[j])) {
                j--;
                continue;
            }
            if (!equal(str[i], str[j])) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isLetterOrDigit(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public boolean equal(char c1, char c2) {
        if (c1 == c2) {
            return true;
        }
        if (((c1 >= 'a' && c1 <= 'z' || c1 >= 'A' && c1 <= 'Z') && (c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z')) && (c1 - c2 == 'A' - 'a' || c1 - c2 == 'a' - 'A')) {
            return true;
        }
        return false;
    }

}
