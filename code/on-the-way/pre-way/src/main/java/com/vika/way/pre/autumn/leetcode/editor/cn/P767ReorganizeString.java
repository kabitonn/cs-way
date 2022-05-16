//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 106 👎 0


//Java：重构字符串

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P767ReorganizeString {
    public static void main(String[] args) {
        Solution solution = new P767ReorganizeString().new Solution();
        String s = "aaabc";
        System.out.println(solution.reorganizeString(s));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorganizeString(String S) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : S.toCharArray()) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
            PriorityQueue<Character> priorityQueue = new PriorityQueue<>((o1, o2) -> countMap.get(o2) - countMap.get(o1));
            priorityQueue.addAll(countMap.keySet());
            if (!priorityQueue.isEmpty()) {
                int max = countMap.get(priorityQueue.peek());
                if (max - 1 > S.length() - max) {
                    return "";
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!priorityQueue.isEmpty()) {
                char moreChar = priorityQueue.poll();
                int moreCount = countMap.get(moreChar);
                sb.append(moreChar);

                if (priorityQueue.isEmpty()) {
                    break;
                }
                char lessChar = priorityQueue.poll();
                int lessCount = countMap.get(lessChar);
                sb.append(lessChar);
                if (--moreCount > 0) {
                    countMap.put(moreChar, moreCount);
                    priorityQueue.add(moreChar);
                }
                if (--lessCount > 0) {
                    countMap.put(lessChar, lessCount);
                    priorityQueue.add(lessChar);
                }

            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}