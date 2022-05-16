//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 555 👎 0


//Java：实现 strStr()

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P28ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr1(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            char[] s = haystack.toCharArray();
            char[] p = needle.toCharArray();
            int m = s.length, n = p.length;
            for (int i = 0; i <= m - n; i++) {
                int j = 0;
                while (j < n && s[i + j] == p[j]) {
                    j++;
                }
                if (j == n) {
                    return i;
                }
            }
            return -1;
        }

        public int strStr2(String haystack, String needle) {
            char[] hayArr = haystack.toCharArray();
            char[] needArr = needle.toCharArray();
            int m = hayArr.length, n = needArr.length;
            for (int i = 0; ; i++) {
                for (int j = 0; ; j++) {
                    if (j == n) {
                        return i;
                    }
                    if (i + j == m) {
                        return -1;
                    }
                    if (hayArr[i + j] != needArr[j]) {
                        break;
                    }
                }
            }
        }

        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            int[] next = getNextVal(needle);
            char[] s = haystack.toCharArray();
            char[] p = needle.toCharArray();
            int m = s.length, n = p.length;
            int i = 0, j = 0;
            while (i < m && j < n) {
                if (j == -1 || s[i] == p[j]) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            if (j == n) {
                return i - j;
            } else {
                return -1;
            }
        }

        public int[] getNext(String p) {
            int n = p.length();
            int[] next = new int[n];
            next[0] = -1;
            int i = 0, j = -1;
            while (i < n - 1) {
                if (j == -1 || p.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                    next[i] = j;
                } else {
                    j = next[j];
                }
            }
            return next;
        }

        public int[] getNextVal(String p) {
            int n = p.length();
            int[] next = new int[n];
            next[0] = -1;
            int i = 0, j = -1;
            while (i < n - 1) {
                if (j == -1 || p.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                    if (p.charAt(i) == p.charAt(j)) {
                        next[i] = next[j];
                    } else {
                        next[i] = j;
                    }
                } else {
                    j = next[j];
                }
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}