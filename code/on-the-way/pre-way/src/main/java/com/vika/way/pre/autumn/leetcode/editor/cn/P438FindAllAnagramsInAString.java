//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 360 👎 0


//Java：找到字符串中所有字母异位词

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 61, 67, 71, 73, 79, 83, 89, 101, 103, 107, 113};

        /**
         * 素数key 乘积越界结果错误
         *
         * @param s
         * @param p
         * @return
         */
        public List<Integer> findAnagrams1(String s, String p) {
            long prime = 1;
            for (char c : p.toCharArray()) {
                prime *= primes[c - 'a'];
            }
            int k = p.length();
            int l = 0, r = 0;
            long product = 1;
            List<Integer> list = new ArrayList<>();
            while (r < s.length()) {
                product *= primes[s.charAt(r++) - 'a'];
                if (r - l == k) {
                    if (product == prime) {
                        list.add(l);
                    }
                    product /= primes[s.charAt(l++) - 'a'];
                }
            }
            return list;
        }

        public List<Integer> findAnagrams(String s, String p) {
            int[] map = new int[26];
            for (char c : p.toCharArray()) {
                map[c - 'a']++;
            }
            int k = p.length();
            int l = 0, r = 0;
            int count = 0;
            List<Integer> list = new ArrayList<>();

            while (r < s.length()) {
                if (map[s.charAt(r++) - 'a']-- > 0) {
                    count++;
                }
                if (r - l == k) {
                    if (count == k) {
                        list.add(l);
                    }
                    if (++map[s.charAt(l++) - 'a'] > 0) {
                        count--;
                    }
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}