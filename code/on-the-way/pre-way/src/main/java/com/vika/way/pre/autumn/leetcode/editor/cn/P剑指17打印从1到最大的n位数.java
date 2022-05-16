//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 49 👎 0


//Java：打印从1到最大的n位数

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P剑指17打印从1到最大的n位数 {
    public static void main(String[] args) {
        Solution solution = new P剑指17打印从1到最大的n位数().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] printNumbers1(int n) {
            int count = 9;
            List<Integer> list = new ArrayList<>((int) Math.pow(10, n));
            int num = 0;
            while (n-- > 0) {
                for (int i = 0; i < count; i++) {
                    list.add(++num);
                }
                count *= 10;
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        public int[] printNumbers(int n) {
            int end = (int) Math.pow(10, n);
            int[] nums = new int[end - 1];
            for (int i = 1; i < end; i++) {
                nums[i - 1] = i;
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}