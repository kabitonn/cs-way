//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1275 👎 0


//Java：括号生成

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis1(int n) {
            List<String> list = new ArrayList<>();
            generateParenthesis(list, "", n, 0, 0);
            return list;
        }

        public void generateParenthesis(List<String> list, String str, int n, int left, int right) {
            if (str.length() == n * 2) {
                list.add(str);
                return;
            }
            if (left < n) {
                generateParenthesis(list, str + "(", n, left + 1, right);
            }
            if (left > right) {
                generateParenthesis(list, str + ")", n, left, right + 1);
            }
        }

        public List<String> generateParenthesis(int n) {
            return generateBracket(n);
        }

        public List<String> generateBracket(int n) {
            if (n == 0) {
                return Arrays.asList("");
            }
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                List<String> left = generateBracket(i - 1);
                List<String> right = generateBracket(n - i);
                for (String l : left) {
                    for (String r : right) {
                        list.add("(" + l + ")" + r);
                    }
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}