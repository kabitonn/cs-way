package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.HashMap;
import java.util.Map;

public class S525ContiguousArray {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero++;
            }
            count[i + 1] = zero;
        }
        for (int len = n >> 1 << 1; len > 0; len -= 2) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len;
                if (count[j] - count[i] == len >> 1) {
                    return len;
                }
            }
        }
        return 0;
    }

    public int findMaxLength1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

    public int findMaxLength2(int[] nums) {
        int n = nums.length;
        Integer[] map = new Integer[n * 2 + 1];
        int sum = 0;
        int max = 0;
        map[n] = -1;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map[n + sum] != null) {
                max = Math.max(max, i - map[n + sum]);
            } else {
                map[n + sum] = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        S525ContiguousArray solution = new S525ContiguousArray();
        int[] nums = {0, 1, 0, 1};
        System.out.println(solution.findMaxLength(nums));
    }
}
