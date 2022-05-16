package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S028StrStr {

    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            boolean isExist = true;
            for (int j = 0; j < needle.length(); j++) {
                if (i + j < haystack.length()) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        isExist = false;
                        break;
                    }
                } else {
                    isExist = false;
                    break;
                }
            }
            if (isExist) {
                return i;
            }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        char[] hayArr = haystack.toCharArray();
        char[] needArr = needle.toCharArray();
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needArr.length) {
                    return i;
                }
                if (i + j == hayArr.length) {
                    return -1;
                }
                if (hayArr[i + j] != needArr[j]) {
                    break;
                }
            }
        }
    }

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr3(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public int strStr4(String haystack, String needle) {
        char[] hayArr = haystack.toCharArray();
        char[] needArr = needle.toCharArray();
        int i = 0; //主串(haystack)的位置
        int j = 0; //模式串(needle)的位置
        while (i < hayArr.length && j < needArr.length) {
            if (hayArr[i] == needArr[j]) { // 当两个字符相等则比较下一个
                i++;
                j++;
            } else {
                i = i - j + 1; // 一旦不匹配，i后退
                j = 0; // j归零
            }
        }
        if (j == needArr.length) { //说明完全匹配
            return i - j;
        } else {
            return -1;
        }
    }

    public int strStr5(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNextVal(needle, next);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public void getNext(String t, int[] next) {
        next[0] = -1;
        int i = 0, j = -1;
        while (i < t.length() - 1) {
            if (j == -1 || t.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    public void getNextVal(String t, int[] next) {
        next[0] = -1;
        int i = 0, j = -1;
        while (i < t.length() - 1) {
            if (j == -1 || t.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                if (t.charAt(i) == t.charAt(j)) {
                    next[i] = next[j];
                } else {
                    next[i] = j;
                }
            } else {
                j = next[j];
            }
        }
    }
}
