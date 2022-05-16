//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法 
// 👍 180 👎 0


//Java：无重叠区间

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Arrays;

public class P435NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new P435NonOverlappingIntervals().new Solution();
        int[][] intervals = {{1, 2}};
        System.out.println(solution.eraseOverlapIntervals(intervals));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals1(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
            int delete = 0;
            int prev = 0;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < intervals[prev][1]) {
                    if (intervals[i][1] <= intervals[prev][1]) {
                        prev = i;
                    }
                    delete++;
                } else {
                    prev = i;
                }
            }
            return delete;
        }

        public int eraseOverlapIntervals2(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
            int n = intervals.length;
            int remain = 1;
            int prev = 0;
            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= intervals[prev][1]) {
                    prev = i;
                    remain++;
                } else if (intervals[i][1] <= intervals[prev][1]) {
                    prev = i;
                }
            }
            return n - remain;
        }

        public int eraseOverlapIntervals3(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
            int n = intervals.length;
            int remain = 1;
            int prev = 0;
            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= intervals[prev][1]) {
                    remain++;
                    prev = i;
                }
            }
            return n - remain;
        }

        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
            int n = intervals.length;
            int delete = 0;
            int prev = 0;
            for (int i = 1; i < n; i++) {
                if (intervals[i][0] < intervals[prev][1]) {
                    delete++;
                } else {
                    prev = i;
                }
            }
            return delete;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}