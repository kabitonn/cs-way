//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法 
// 👍 268 👎 0


//Java：移掉K位数字

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Stack;

public class P402RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new P402RemoveKDigits().new Solution();
        System.out.println(solution.removeKdigits("1432219", 3));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits1(String num, int k) {
            if (null == num || num.length() == 0) {
                return "0";
            }
            while (k-- > 0) {
                int i = 0;
                for (; i < num.length() - 1; i++) {
                    if (num.charAt(i) > num.charAt(i + 1)) {
                        break;
                    }
                }
                num = num.substring(0, i) + num.substring(i + 1);
                int j = 0;
                while (j < num.length() && num.charAt(j) == '0') {
                    j++;
                }
                num = num.substring(j);
                if (num.length() <= k) {
                    return "0";
                }
            }
            return num;
        }

        public String removeKdigits(String num, int k) {
            Stack<Character> stack = new Stack<>();
            for (char c : num.toCharArray()) {
                while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                    stack.pop();
                    k--;
                }
                stack.push(c);
            }
            while (!stack.isEmpty() && k-- > 0) {
                stack.pop();
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.length() == 0 ? "0" : sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}