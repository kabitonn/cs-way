//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法 
// 👍 423 👎 0


//Java：根据身高重建队列

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P406QueueReconstructionByHeight {
    public static void main(String[] args) {
        Solution solution = new P406QueueReconstructionByHeight().new Solution();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(solution.reconstructQueue(people));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue1(int[][] people) {
            Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
            List<int[]> list = new ArrayList<>();
            for (int[] p : people) {
                list.add(p[1], p);
            }
            return list.toArray(new int[0][]);
        }

        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);
            int[][] queue = new int[people.length][];
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < people.length; i++) {
                list.add(i);
            }
            for (int[] p : people) {
                int index = list.get(p[1]);
                queue[index] = p;
                list.remove(p[1]);
            }
            return queue;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}