//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索 
// 👍 430 👎 0


//Java：字符串解码

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Stack;

public class P394DecodeString {
    public static void main(String[] args) {
        Solution solution = new P394DecodeString().new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString1(String s) {
            Stack<Integer> numStack = new Stack<>();
            Stack<String> stringStack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int num = 0;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                } else if (c == '[') {
                    numStack.push(num);
                    stringStack.push(sb.toString());
                    num = 0;
                    sb = new StringBuilder();
                } else if (c == ']') {
                    String tmp = sb.toString();
                    StringBuilder str = new StringBuilder(stringStack.pop());
                    int k = numStack.pop();
                    for (int i = 0; i < k; i++) {
                        str.append(tmp);
                    }
                    sb = new StringBuilder(str.toString());
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        public String decodeString(String s) {
            return dfs(s.toCharArray());
        }

        int i = 0;

        String dfs(char[] s) {
            StringBuilder sb = new StringBuilder();
            int num = 0;
            for (; i < s.length; ) {
                if (s[i] >= '0' && s[i] <= '9') {
                    num = num * 10 + s[i++] - '0';
                    continue;
                }
                if (s[i] == '[') {
                    i++;
                    String tmp = dfs(s);
                    for (int j = 0; j < num; j++) {
                        sb.append(tmp);
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
//leetcode submit region end(Prohibit modification and deletion)

}