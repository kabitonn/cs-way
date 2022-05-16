package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

public class S477TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sum += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return sum;
    }

    public int totalHammingDistance1(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int[] count = new int[2];
            int s = 0;
            for (int num : nums) {
                int tmp = num >> i;
                count[(tmp & 1)]++;
                s += tmp;
            }
            if (s == 0) {
                break;
            }
            sum += count[0] * count[1];
        }
        return sum;
    }

    public int totalHammingDistance2(int[] nums) {
        int sum = 0;
        int[] countOne = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                countOne[i] += num & 1;
                num >>= 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            sum += (nums.length - countOne[i]) * countOne[i];
        }
        return sum;
    }
}
