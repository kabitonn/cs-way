package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S075SortColors {
    public void sortColors(int[] nums) {
        int redNum = 0, whiteNum = 0, blueNum = 0;
        for (int n : nums) {
            if (n == 0) {
                redNum++;
            } else if (n == 1) {
                whiteNum++;
            } else if (n == 2) {
                blueNum++;
            }
        }
        int index = 0;
        for (; index < redNum; index++) {
            nums[index] = 0;
        }
        for (; index < redNum + whiteNum; index++) {
            nums[index] = 1;
        }
        for (; index < nums.length; index++) {
            nums[index] = 2;
        }
    }

    public void sortColors0(int[] nums) {
        int[] colors = new int[3];
        for (int n : nums) {
            colors[n]++;
        }
        int index = 0;
        int sortedNum = 0;
        for (int i = 0; i < colors.length; i++) {
            for (; index < colors[i] + sortedNum; index++) {
                nums[index] = i;
            }
            sortedNum += colors[i];
        }
    }

    public void sortColors1(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        int cur = 0;
        int tmp;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                tmp = nums[p0];
                nums[p0++] = nums[cur];
                nums[cur++] = tmp;
            } else if (nums[cur] == 2) {
                tmp = nums[p2];
                nums[p2--] = nums[cur];
                nums[cur] = tmp;
            } else if (nums[cur] == 1) {
                cur++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int p0 = -1, p1 = -1, p2 = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                p2++;
                nums[p2] = 2;
                p1++;
                nums[p1] = 1;
                p0++;
                nums[p0] = 0;
            } else if (nums[i] == 1) {
                p2++;
                nums[p2] = 2;
                p1++;
                nums[p1] = 1;
            } else if (nums[i] == 2) {
                p2++;
                nums[p2] = 2;
            }
        }
    }
}
