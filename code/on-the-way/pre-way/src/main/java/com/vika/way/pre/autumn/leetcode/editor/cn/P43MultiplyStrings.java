//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 470 👎 0


//Java：字符串相乘

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new P43MultiplyStrings().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            char[] f1 = num1.toCharArray();
            char[] f2 = num2.toCharArray();
            int n1 = f1.length, n2 = f2.length;
            int[] pos = new int[n1 + n2];
            for (int i = n1 - 1; i >= 0; i--) {
                for (int j = n2 - 1; j >= 0; j--) {
                    int num = (f1[i] - '0') * (f2[j] - '0');
                    num += pos[i + j + 1];
                    pos[i + j] += num / 10;
                    pos[i + j + 1] = num % 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            boolean head = false;
            for (int i = 0; i < pos.length; i++) {
                if (!head && pos[i] == 0) {
                    continue;
                }
                head = true;
                sb.append(pos[i]);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();
        String s = solution.multiply("2", "3");
        System.out.println(s);
    }
}