package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S077Combinations {

    public static void main(String[] args) {
        S077Combinations solution = new S077Combinations();
        System.out.println(solution.combine5(4,2));
    }
    public List<List<Integer>> combine0(int n, int k) {
        List<List<Integer>> listList = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return listList;
        }
        backtrack(listList, new ArrayList<>(), n, k, 1);
        return listList;
    }

    private void backtrack(List<List<Integer>> listList, List<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index + 1; i <= n; i++) {
            list.add(i);
            backtrack(listList, list, n, k, i);
            list.remove(list.size() - 1);
        }
    }

    private void backtrack1(List<List<Integer>> listList, List<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtrack1(listList, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            temp.add(0);
        }
        int i = 0;
        while (i >= 0) {
            //当前数字加 1
            temp.set(i, temp.get(i) + 1);
            //当前数字大于 n，对应回溯法的 i == n + 1，然后回到上一层
            //优化为剩余未选数量(k-i-1)不够，回溯
            if (temp.get(i) > n - (k - i - 1)) {
                i--;
            } else if (i == k - 1) {
                // 当前数字个数够了
                listList.add(new ArrayList<>(temp));
                //进入更新下一个数字
            } else {
                i++;
                //把下一个数字置为上一个数字，类似于回溯法中的 start
                temp.set(i, temp.get(i - 1));
            }
        }
        return listList;
    }


    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if (n == 0 || k == 0 || k > n) {
            return listList;
        }
        //个数为 1 的所有可能
        for (int i = 1; i <= n + 1 - k; i++) {
            listList.add(Arrays.asList(i));
        }
        //第一层循环，从 2 到 k
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            //第二层循环，遍历之前所有的结果
            for (List<Integer> list : listList) {
                //第三次循环，对每个结果进行扩展
                //从最后一个元素加 1 开始，然后不是到 n ，而是和解法一的优化一样
                //(k - (i - 1)) 代表剩余未选的个数，最后再加 1 是因为取了 n
                for (int m = list.get(list.size() - 1) + 1; m <= n - (k - (i - 1)) + 1; m++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(m);
                    tmp.add(newList);
                }
            }
            listList = tmp;
        }
        return listList;
    }


    //C ( n, k ) = C ( n - 1, k - 1) + C ( n - 1, k )
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> listList = new ArrayList<>();
        if (k == n || k == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= k; ++i) {
                list.add(i);
            }
            listList.add(list);
            return listList;
        }
        // n - 1 里边选 k - 1 个
        listList = combine(n - 1, k - 1);
        //每个结果加上 n
        for (List list : listList) {
            list.add(n);
        }
        //listList.forEach(e -> e.add(n));
        //把 n - 1 个选 k 个的结果也加入
        listList.addAll(combine(n - 1, k));
        return listList;
    }

    public List<List<Integer>> combine4(int n, int k) {
        List<List<Integer>>[][] dp = new List[n + 1][k + 1];
        //更新 k = 0 的所有情况
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new ArrayList<>();
            dp[i][0].add(new ArrayList<>());
        }
        // i 从 1 到 n
        for (int i = 1; i <= n; i++) {
            // j 从 1 到 i 或者 k
            for (int j = 1; j <= i && j <= k; j++) {
                dp[i][j] = new ArrayList<>();
                //判断是否可以从 i - 1 里边选 j 个
                if (i > j) {
                    dp[i][j].addAll(dp[i - 1][j]);
                }
                //把 i - 1 里边选 j - 1 个的每个结果加上 i
                for (List<Integer> list : dp[i - 1][j - 1]) {
                    List<Integer> tmpList = new ArrayList<>(list);
                    tmpList.add(i);
                    dp[i][j].add(tmpList);
                }
            }
        }
        return dp[n][k];
    }

    public List<List<Integer>> combine5(int n, int k) {
        List<List<Integer>>[] dp = new List[k + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            List<List<Integer>> temp = new ArrayList<>(dp[0]);
            for (int j = 1; j <= i && j <= k; j++) {
                List<List<Integer>> last = temp;
                if(dp[j]!=null){
                    temp = new ArrayList<>(dp[j]);
                }
                // 判断是否可以从 i - 1 里边选 j 个
                if (i <= j) {
                    dp[j] = new ArrayList<>();
                }
                //把 i - 1 里边选 j - 1 个的每个结果加上 i
                for (List<Integer> list : last) {
                    List<Integer> tmpList = new ArrayList<>(list);
                    tmpList.add(i);
                    dp[j].add(tmpList);
                }
            }
        }
        return dp[k];
    }

}
