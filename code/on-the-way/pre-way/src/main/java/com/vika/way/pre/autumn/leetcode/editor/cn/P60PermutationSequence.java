//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法 
// 👍 312 👎 0


//Java：第k个排列

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P60PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new P60PermutationSequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getPermutation1(int n, int k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            int factor = factorial(n);
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                factor /= n--;
                int group = k / factor;
                k %= factor;
                if (k == 0) {
                    sb.append(list.remove(group - 1));
                    break;
                } else {
                    sb.append(list.remove(group));
                }
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                sb.append(list.get(i));
            }
            return sb.toString();
        }

        public int factorial(int n) {
            int factor = n;
            while (--n > 0) {
                factor *= n;
            }
            return factor;
        }

        public String getPermutation(int n, int k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            int factor = factorial(n);
            StringBuilder sb = new StringBuilder();
            k--;
            while (n > 0) {
                factor /= n--;
                int group = k / factor;
                k %= factor;
                sb.append(list.remove(group));
            }
            return sb.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();
        String r = solution.getPermutation(3, 3);
        System.out.println(r);
    }
}