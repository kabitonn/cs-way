package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.HashSet;
import java.util.Set;

public class S457CircularArrayLoop {

    public static void main(String[] args) {
        int[] nums = {-2, -3, -9};
        S457CircularArrayLoop solution = new S457CircularArrayLoop();
        System.out.println(solution.circularArrayLoop1(nums));
    }

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int cur = i;
            Set<Integer> subVisted = new HashSet<>();
            while (!visited[cur]) {
                visited[cur] = true;
                subVisted.add(cur);
                int next = (cur + nums[cur]) % n;
                next = next < 0 ? next + n : next;
                if (next == cur || nums[cur] * nums[next] < 0) {
                    break;
                }
                if (subVisted.contains(next)) {
                    return true;
                }
                cur = next;
            }
        }
        return false;
    }

    public boolean circularArrayLoop1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = ((slow + nums[slow]) % n + n) % n;
            while (slow != fast && nums[fast] != 0 && nums[slow] * nums[fast] > 0) {
                slow = ((slow + nums[slow]) % n + n) % n;
                fast = ((fast + nums[fast]) % n + n) % n;
                if (nums[fast] == 0 || nums[slow] * nums[fast] < 0) {
                    break;
                }
                fast = ((fast + nums[fast]) % n + n) % n;
            }
            if (slow == fast && slow != ((slow + nums[slow]) % n + n) % n) {
                return true;
            }
            int start = i;
            while (start != fast) {
                int step = nums[start];
                nums[start] = 0;
                start = ((start + step) % n + n) % n;
            }
        }
        return false;
    }

}
