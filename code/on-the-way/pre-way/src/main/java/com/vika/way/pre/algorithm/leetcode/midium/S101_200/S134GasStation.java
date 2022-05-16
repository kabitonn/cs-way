package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

public class S134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int start = -1;
        for (int i = 0; i < len; i++) {
            int remain = 0;
            for (int j = 0; j < len; j++) {
                int k = (i + j) % len;
                remain += (gas[k] - cost[k]);
                if (remain < 0) {
                    break;
                }
            }
            if (remain >= 0) {
                start = i;
                break;
            }
        }
        return start;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int j = i;
            int remain = gas[j];
            while (remain - cost[j] >= 0) {
                remain -= cost[j];
                j = (j + 1) % len;
                remain += gas[j];
                if (j == i) {
                    return i;
                }
            }
            if (j < i) {
                return -1;
            }
            i = j;
        }
        return -1;
    }
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;

        int totalTank = 0;
        int currTank = 0;
        int start = 0;
        for (int i = 0; i < n; ++i) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            // If one couldn't get here,
            if (currTank < 0) {
                // Pick up the next station as the starting one.
                start = i + 1;
                // Start with an empty tank.
                currTank = 0;
            }
        }
        return totalTank >= 0 ? start : -1;
    }

}
