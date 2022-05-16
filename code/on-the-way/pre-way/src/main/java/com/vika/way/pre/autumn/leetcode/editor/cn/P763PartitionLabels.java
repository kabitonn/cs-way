//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针 
// 👍 189 👎 0


//Java：划分字母区间

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P763PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new P763PartitionLabels().new Solution();
        String s = "eaaaabaaec";
        System.out.println(solution.partitionLabels(s));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels1(String S) {
            if (S.length() == 0) {
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            int n = S.length();
            int left = 0;
            while (left < n) {
                int right = left;
                Set<Character> set = new HashSet<>();
                set.add(S.charAt(left));
                for (int i = left + 1; i < n; i++) {
                    if (set.contains(S.charAt(i))) {
                        right = i;
                        for (int j = left + 1; j < right; j++) {
                            set.add(S.charAt(j));
                        }
                    }
                }
                list.add(right - left + 1);
                left = right + 1;
            }
            return list;
        }

        public List<Integer> partitionLabels(String S) {
            if (S.length() == 0) {
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            int n = S.length();
            int left = 0;
            while (left < n) {
                int right = S.lastIndexOf(S.charAt(left));
                for (int i = left + 1; i < right; i++) {
                    right = Math.max(right, S.lastIndexOf(S.charAt(i)));
                }
                list.add(right - left + 1);
                left = right + 1;
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}