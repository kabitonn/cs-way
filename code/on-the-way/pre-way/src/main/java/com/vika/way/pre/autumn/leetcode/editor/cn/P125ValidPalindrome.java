//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 267 👎 0


//Java：验证回文串

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // TO TEST
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("1b1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null) {
                return true;
            }
            s = s.trim().toLowerCase();
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                while (i < j && !(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))) {
                    i++;
                }
                while (i < j && !(Character.isLetter(s.charAt(j)) || Character.isDigit(s.charAt(j)))) {
                    j--;
                }
                if (s.charAt(i++) != s.charAt(j--)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}