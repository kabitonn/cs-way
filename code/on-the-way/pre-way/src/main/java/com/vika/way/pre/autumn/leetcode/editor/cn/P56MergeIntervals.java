//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组 
// 👍 538 👎 0


//Java：合并区间

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
            List<int[]> list = new ArrayList<>();
            int i = 0;
            int n = intervals.length;
            while (i < n) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                i++;
                for (; i < n && intervals[i][0] <= right; i++) {
                    right = Math.max(right, intervals[i][1]);
                }
                list.add(new int[]{left, right});
            }
            return list.toArray(new int[0][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}