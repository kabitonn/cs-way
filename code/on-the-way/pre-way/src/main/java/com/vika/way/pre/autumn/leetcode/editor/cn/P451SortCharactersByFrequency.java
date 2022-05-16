//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 堆 哈希表 
// 👍 144 👎 0


//Java：根据字符出现频率排序

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.*;

public class P451SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new P451SortCharactersByFrequency().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort1(String s) {
            Map<Character, Integer> countMap = new HashMap<>(26 * 2);
            for (char c : s.toCharArray()) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
            List<Character> list = new ArrayList<>(countMap.keySet());
            list.sort((o1, o2) -> (countMap.get(o2) - countMap.get(o1)));
            StringBuilder sb = new StringBuilder();
            for (char c : list) {
                for (int i = 0; i < countMap.get(c); i++) {
                    sb.append(c);
                }
            }
            return sb.toString();

        }

        public String frequencySort2(String s) {
            int[] countMap = new int[128];
            for (char c : s.toCharArray()) {
                countMap[c]++;
            }
            PriorityQueue<Character> maxHeap = new PriorityQueue<>((o1, o2) -> countMap[o2] - countMap[o1]);
            for (int i = 0; i < countMap.length; i++) {
                if (countMap[i] == 0) {
                    continue;
                }
                maxHeap.add((char) i);
            }
            StringBuilder sb = new StringBuilder();
            while (!maxHeap.isEmpty()) {
                char c = maxHeap.poll();
                for (int i = 0; i < countMap[c]; i++) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        public String frequencySort(String s) {
            int[] countMap = new int[128];
            int max = 0;
            for (char c : s.toCharArray()) {
                countMap[c]++;
                max = Math.max(max, countMap[c]);
            }
            List<Character>[] charBucket = new List[max + 1];
            for (int i = 0; i < countMap.length; i++) {
                int n = countMap[i];
                if (null == charBucket[n]) {
                    charBucket[n] = new LinkedList<>();
                }
                charBucket[n].add((char) i);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = max; i > 0; i--) {
                if (null == charBucket[i]) {
                    continue;
                }
                for (char c : charBucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}