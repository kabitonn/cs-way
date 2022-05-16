package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

public class S526BeautifulArrangement {

    public int countArrangement(int N) {
        return backtrack(N, 1, 0);
    }

    public int backtrack(int N, int pos, int visited) {
        if (pos > N) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if ((1 << i & visited) != 0) {
                continue;
            }
            if (pos % i != 0 && i % pos != 0) {
                continue;
            }
            visited ^= 1 << i;
            count += backtrack(N, pos + 1, visited);
            visited ^= 1 << i;
        }
        return count;
    }

    public int countArrangement1(int N) {
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = i;
        }
        return arrange(nums, 1);
    }

    public int arrange(int[] nums, int pos) {
        if (pos == nums.length) {
            return 1;
        }
        int count = 0;
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] % pos == 0 || pos % nums[i] == 0) {
                swap(nums, i, pos);
                count += arrange(nums, pos + 1);
                swap(nums, i, pos);
            }
        }
        return count;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void xorSwap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        S526BeautifulArrangement solution = new S526BeautifulArrangement();
        System.out.println(solution.countArrangement1(2));
    }
}
