package com.vika.way.pre.algorithm.exam;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/**
 * 4.3
 */
public class AliBaba {

    /**
     * 对一个数组，求每个数左边比他大的数的最小值，右边比他小的数的最大值，若这两个数成倍数关系，则该数有价值。
     * 求有价值树的总数量
     *
     * @param num
     * @return
     */
    public int getValueNumber(long[] num) {
        int n = num.length;
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            Long min = null;
            for (int j = 0; j < i; j++) {
                if (num[j] > num[i] && (min == null || num[j] < min)) {
                    min = num[j];
                }
            }
            Long max = null;
            for (int j = i + 1; j < n; j++) {
                if (num[j] < num[i] && (max == null || num[j] > max)) {
                    max = num[j];
                }
            }
            if (min != null && max != null && max != 0 && min % max == 0) {
                count++;
            }
        }
        return count;
    }

    public int getValidCount(long[] num) {
        int n = num.length;
        int count = 0;
        Long[] leftMin = new Long[n];
        Long[] rightMax = new Long[n];

        TreeSet<Long> treeSet = new TreeSet<>();
        Long min;
        for (int i = 0; i < n; i++) {
            min = treeSet.higher(num[i]);
            if (min != null) {
                leftMin[i] = min;
            }
            treeSet.add(num[i]);
        }
        treeSet.clear();
        Long max;
        for (int i = n - 1; i >= 0; i--) {
            max = treeSet.lower(num[i]);
            if (max != null) {
                rightMax[i] = max;
            }
            treeSet.add(num[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (leftMin[i] == null || rightMax[i] == null) {
                continue;
            }
            if (rightMax[i] != 0 && leftMin[i] % rightMax[i] == 0) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void testValid() {
        Random random = new Random();
        int n = random.nextInt(10000);
        System.out.println(n);
        long[] num = new long[n];
        for (int i = 0; i < n; i++) {
            num[i] = random.nextInt(n);
        }
        int count = getValueNumber(num);
        System.out.println(count);
        count = getValidCount(num);
        System.out.println(count);
    }

    /**
     * 一个矩阵，每个元素代表经过其的代价。每一次可以上下左右方向走一步，
     * 求从最上行任意列，到最下行任意列的最小代价
     *
     * @param matrix
     * @return
     */
    public int getRemain(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n];
        for (int i = 1; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int k = 0; k < 2; k++) {
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + matrix[i - 1][j]);
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + matrix[i - 1][j]);
                }
                for (int j = n - 1; j >= 0; j--) {
                    if (j < n - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + matrix[i - 1][j]);
                    }
                }
            }
            for (int i = m - 1; i >= 1; i--) {
                for (int j = 0; j < n; j++) {
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + matrix[i - 1][j]);
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + matrix[i - 1][j]);
                }
                for (int j = n - 1; j >= 0; j--) {
                    if (j < n - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + matrix[i - 1][j]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[m][j]);
        }
        return min;

    }

    public void dfs(int[][] matrix, int[][] dp, int cur, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return;
        }
        if (matrix[i][j] + cur >= dp[i][j]) {
            return;
        }
        dp[i][j] = cur + matrix[i][j];
        dfs(matrix, dp, dp[i][j], i + 1, j);
        dfs(matrix, dp, dp[i][j], i - 1, j);
        dfs(matrix, dp, dp[i][j], i, j + 1);
        dfs(matrix, dp, dp[i][j], i, j - 1);
    }

    public int getMinCost(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, dp, 0, 0, j);
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[m - 1][j]);
        }
        return min;
    }


    @Test
    public void test() {
        //int[][] matrix = {{3, 1, 3}, {3, 1, 0}, {3, 1, 3}};
        int[][] matrix = {{9, 9, 1, 1}, {9, 1, 1, 9}, {1, 1, 9, 9}};
        System.out.println(getRemain(matrix));
        System.out.println(getMinCost(matrix));
    }
}
