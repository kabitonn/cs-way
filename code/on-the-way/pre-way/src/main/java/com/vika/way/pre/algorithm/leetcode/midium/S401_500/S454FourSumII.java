package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S454FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (A[i] + B[j] + C[k] + D[l] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int fourSumCount_1(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        Arrays.sort(D);
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int left = 0, right = n - 1;
                    while (left <= right) {
                        int l = (left + right) >>> 1;
                        int sum = A[i] + B[j] + C[k] + D[l];
                        if (sum < 0) {
                            left++;
                        } else if (sum > 0) {
                            right--;
                        } else {
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countSum1 = new HashMap<>();
        Map<Integer, Integer> countSum2 = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum1 = A[i] + B[j];
                if (!countSum1.containsKey(sum1)) {
                    countSum1.put(sum1, 0);
                }
                countSum1.put(sum1, countSum1.get(sum1) + 1);
                int sum2 = C[i] + D[j];
                if (!countSum2.containsKey(sum2)) {
                    countSum2.put(sum2, 0);
                }
                countSum2.put(sum2, countSum2.get(sum2) + 1);
            }
        }
        int count = 0;
        for (int sum1 : countSum1.keySet()) {
            if (countSum2.containsKey(-sum1)) {
                count += countSum1.get(sum1) * countSum2.get(-sum1);
            }
        }
        return count;
    }

    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countSum1 = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum1 = A[i] + B[j];
                if (!countSum1.containsKey(sum1)) {
                    countSum1.put(sum1, 0);
                }
                countSum1.put(sum1, countSum1.get(sum1) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum2 = C[i] + D[j];
                if (countSum1.containsKey(-sum2)) {
                    count += countSum1.get(-sum2);
                }
            }
        }
        return count;
    }
}
