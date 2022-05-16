package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.ArrayList;
import java.util.List;

public class S228SummaryRanges {
    public List<String> summaryRanges0(int[] nums) {
        List<String> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int start = nums[i];
            int end = nums[i];
            for (i = i + 1; i < len; i++) {
                if (nums[i] == nums[i - 1] + 1) {
                    end = nums[i];
                } else {
                    i--;
                    break;
                }
            }
            String s = String.valueOf(start);
            if (start != end) {
                s = s + "->" + String.valueOf(end);
            }
            list.add(s);
        }
        return list;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; ) {
            int start = nums[i++];
            while (i < len && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int end = nums[i - 1];
            String s = String.valueOf(start);
            if (start != end) {
                s = s + "->" + String.valueOf(end);
            }
            list.add(s);
        }
        return list;
    }

    public List<String> summaryRanges1(int[] nums) {
        List<String> list = new ArrayList<>();
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int j = i;
            while (j < len - 1 && nums[j + 1] == nums[j] + 1) {
                j++;
            }
            String s = String.valueOf(nums[i]);
            if (i != j) {
                s = s + "->" + String.valueOf(nums[j]);
            }
            list.add(s);
            i = j + 1;
        }
        return list;
    }
}
