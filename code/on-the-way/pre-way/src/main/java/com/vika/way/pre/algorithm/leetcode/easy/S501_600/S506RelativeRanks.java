package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S506RelativeRanks {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        S506RelativeRanks solution = new S506RelativeRanks();
        System.out.println(Arrays.toString(solution.findRelativeRanks(nums)));
    }

    public String[] findRelativeRanks(int[] nums) {
        String[] rankString = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int n = nums.length;
        int[] scores = Arrays.copyOf(nums, n);
        Arrays.sort(scores);
        Map<Integer, String> rankMap = new HashMap<>(n);
        for (int i = n - 1; i >= 0; i--) {
            if (i >= n - 3) {
                rankMap.put(scores[i], rankString[n - i - 1]);
            } else {
                rankMap.put(scores[i], Integer.toString(n - i));
            }
        }
        String[] ranks = new String[n];
        for (int i = 0; i < n; i++) {
            ranks[i] = rankMap.get(nums[i]);
        }
        return ranks;
    }

    public String[] findRelativeRanks1(int[] nums) {
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        Integer[] rankMap = new Integer[max + 1];
        for (int i = 0; i < nums.length; i++) {
            rankMap[nums[i]] = i;
        }
        String[] rankString = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] ranks = new String[nums.length];
        int rank = 1;
        for (int i = max; i >= 0; i--) {
            if (rankMap[i] == null) {
                continue;
            }
            if (rank <= 3) {
                ranks[rankMap[i]] = rankString[rank - 1];
            } else {
                ranks[rankMap[i]] = Integer.toString(rank);
            }
            rank++;
        }
        return ranks;
    }
}
