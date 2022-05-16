//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 123 👎 0


//Java：前K个高频单词

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.*;

public class P692TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new P692TopKFrequentWords().new Solution();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(solution.topKFrequent(words, 3));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> topKFrequent1(String[] words, int k) {
            LinkedHashMap<String, Integer> countMap = new LinkedHashMap<>();
            for (String s : words) {
                countMap.put(s, countMap.getOrDefault(s, 0) + 1);
            }
            List<String> wordList = new ArrayList<>(countMap.keySet());
            Collections.sort(wordList, (o1, o2) -> {
                int value = countMap.get(o2) - countMap.get(o1);
                return value != 0 ? value : o1.compareTo(o2);
            });

            return wordList.subList(0, k);
        }

        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> countMap = new HashMap<>();
            for (String s : words) {
                countMap.put(s, countMap.getOrDefault(s, 0) + 1);
            }
            PriorityQueue<String> maxHeap = new PriorityQueue<>((o1, o2) -> {
                int value = countMap.get(o2) - countMap.get(o1);
                return value != 0 ? value : o1.compareTo(o2);
            });
            maxHeap.addAll(countMap.keySet());
            List<String> list = new ArrayList<>();
            while (!maxHeap.isEmpty() && k-- > 0) {
                list.add(maxHeap.poll());
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}