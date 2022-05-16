//给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: 210 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: 9534330 
//
// 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
// Related Topics 排序 
// 👍 364 👎 0


//Java：最大数

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Arrays;

public class P179LargestNumber {
    public static void main(String[] args) {
        Solution solution = new P179LargestNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            String[] strings = Arrays.stream(nums).mapToObj(String::valueOf).sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2)).toArray(String[]::new);

            if (strings[0].charAt(0) == '0') {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            for (String s : strings) {
                sb.append(s);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}