package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S219ContainsNearbyDuplicate {

    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i])) {
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return false;
        }
        int i = 0, j = i + 1;
        int len = nums.length;
        while (i < len - 1) {
            if (i < j && nums[j] == nums[i] && j - i <= k) {
                return true;
            }
            if (j - i < k && j < len - 1) {
                j++;
            } else {
                i++;
            }
        }
        return false;
    }
}
