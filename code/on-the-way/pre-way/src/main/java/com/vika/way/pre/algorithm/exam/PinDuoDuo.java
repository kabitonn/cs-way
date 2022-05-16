package com.vika.way.pre.algorithm.exam;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PinDuoDuo {

    public long minCost(int[] num) {
        Arrays.sort(num);
        int n = num.length;
        int high = n - 1;
        long cost = 0;
        for (; high >= 1; high -= 3) {
            cost += num[high] + num[high - 1];
        }
        if (high == 0) {
            cost += num[high];
        }
        return cost;
    }

    @Test
    public void test1() {
        int[] num = {1, 2, 3, 4, 5, 5, 5, 5, 5, 5};
        long count = minCost(num);
        System.out.println(count);
    }

    public int countInterval(int[] num, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = num.length;
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += num[i];
            sum = sum % m;
            if (map.containsKey(sum)) {
                count += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }

    @Test
    public void test2() {
        int[] num = {1, 2, 3, 4, 5};
        int count = countInterval(num, 2);
        System.out.println(count);
    }

    static String result;

    public static int lucky(int k, String s) {
        char[] ss = s.toCharArray();
        int[][] diff = new int[s.length()][s.length()];
        int minLoss = Integer.MAX_VALUE;
        int minIndex = Integer.MIN_VALUE;
        int count = 0;
        int sum = 0;
        int[] arr = new int[s.length()];

        char a;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                diff[i][j] = Math.abs(ss[i] - ss[j]);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            arr = diff[i];
            Arrays.sort(arr);
            sum = 0;
            count = 0;
            for (int j = 0; count < k && j < ss.length; j++) {
                sum += arr[j];
                count++;
            }
            if (sum < minLoss) {
                minLoss = sum;
                minIndex = i;
            }
        }

        final int[] arr1 = new int[ss.length];
        for (int i = 0; i < s.length(); i++) {
            arr1[i] = Math.abs(ss[minIndex] - ss[i]);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {
            if (arr1[o1] == arr1[o2]) return o1 - o2;
            else return arr1[o1] - arr1[o2];
        }));
        for (int i = 0; i < arr.length; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < k; i++) {
            int index = queue.poll();
            ss[index] = ss[minIndex];
        }

        result = new String(ss);
        return minLoss;

    }

    public int maxSameLength(int[] num, int k) {
        int n = num.length;
        int max = 0;
        int i = 0, j = 0;
        int deleteCount = 0;
        int next = -1;
        while (j < n) {
            if (num[i] == num[j]) {
                j++;
            } else if (deleteCount < k) {
                if (deleteCount == 0) {
                    next = j;
                }
                deleteCount++;
                j++;
            } else {
                max = Math.max(max, j - i - deleteCount);
                deleteCount = 0;
                i = next != -1 ? next : j;
                j = i + 1;
            }
        }
        max = Math.max(max, j - i - deleteCount);
        return max;
    }

    @Test
    public void test4() {
        //int[] num = {1, 1, 2, 1, 1, 3, 1, 3, 1, 3, 1};
        int[] num = {1};
        int count = maxSameLength(num, 4);
        System.out.println(count);
    }
}
