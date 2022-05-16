package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

public class S220ContainsDuplicateIII {
    public static void main(String[] args) {
        S220ContainsDuplicateIII solution = new S220ContainsDuplicateIII();
        int[] nums = {2, 3, 3, 4, 5};
        System.out.println(solution.containsNearbyAlmostDuplicate1(nums, 3, 0));

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j <= i + k && j < len; j++) {
                long diff = Math.abs((long) nums[j] - (long) nums[i]);
                if (diff <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k <= 0) {
            return false;
        }
        int i = 0, j = i + 1;
        int len = nums.length;
        while (i < len - 1) {
            long diff = Math.abs((long) nums[j] - (long) nums[i]);
            if (diff <= t && j - i <= k) {
                return true;
            }
            if (j - i < k && j < len - 1) {
                j++;
            } else {
                i++;
                j = i + 1;
            }
        }
        return false;
    }
    // 逻辑有漏洞
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k <= 0) {
            return false;
        }
        int i = 0, j = i + 1;
        int len = nums.length;
        while (i < len - 1) {
            long diff = Math.abs((long) nums[j] - (long) nums[i]);
            if (diff <= t && j - i <= k) {
                return true;
            }
            if (j - i < k && j < len - 1) {
                j++;
            } else {
                i++;
                if (t != 0) {
                    j = i + 1;
                }
            }
        }
        return false;
    }


}
