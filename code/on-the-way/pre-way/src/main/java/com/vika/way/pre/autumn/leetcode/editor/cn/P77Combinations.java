//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 338 👎 0


//Java：组合

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine1(int n, int k) {
            List<List<Integer>> listList = new ArrayList<>();
            combine(listList, new ArrayList<>(), k, n, 1);
            return listList;
        }

        public void combine(List<List<Integer>> listList, List<Integer> list, int k, int n, int index) {
            if (list.size() == k) {
                listList.add(new ArrayList<>(list));
                return;
            }
            for (int i = index; i <= n && n - i + 1 >= k - list.size(); i++) {
                list.add(i);
                combine(listList, list, k, n, i + 1);
                list.remove(list.size() - 1);
            }
            /*for (int i = index; i <= n; i++) {
                list.add(i);
                combine(listList, list, k, n, i + 1);
                list.remove(list.size() - 1);
            }*/
        }

        public List<List<Integer>> combine(int n, int k) {
            return conquer(n, k);
        }

        public List<List<Integer>> conquer(int n, int k) {
            List<List<Integer>> listList = new ArrayList<>();

            if (k == n || k == 0) {
                List<Integer> list = new ArrayList<>();
                for (int i = 1; i <= k; i++) {
                    list.add(i);
                }
                listList.add(list);
                return listList;
            }
            listList = conquer(n - 1, k - 1);
            listList.forEach(l -> l.add(n));
            listList.addAll(conquer(n - 1, k));
            return listList;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}