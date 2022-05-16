//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 39 👎 0


//Java：替换空格

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P剑指05替换空格 {
    public static void main(String[] args) {
        Solution solution = new P剑指05替换空格().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Pattern pattern = Pattern.compile("\\s");

        public String replaceSpace1(String s) {
            String str = s;
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                str = matcher.replaceAll("%20");
                matcher = pattern.matcher(str);
            }
            return str;
        }

        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}