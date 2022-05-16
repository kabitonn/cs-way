package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.Arrays;

public class S416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        Arrays.sort(nums);
        sum >>= 1;
        if (nums[n - 1] > sum) {
            return false;
        }
        return combine(nums, n - 1, sum);
    }

    public boolean combine(int[] nums, int index, int sum) {
        if (sum < 0) {
            return false;
        } else if (sum == 0) {
            return true;
        }
        for (int i = index; i >= 0; i--) {
            if (combine(nums, i - 1, sum - nums[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        sum >>= 1;
        Integer[][] memo = new Integer[n][sum + 1];
        return combine1(nums, n - 1, sum, memo);
    }

    public boolean combine1(int[] nums, int index, int sum, Integer[][] memo) {
        if (sum < 0 || index < 0) {
            return false;
        } else if (sum == 0) {
            return true;
        }
        if (memo[index][sum] != null) {
            return memo[index][sum] == 1;
        }
        memo[index][sum] = combine1(nums, index - 1, sum - nums[index], memo) || combine1(nums, index - 1, sum, memo) ? 1 : 0;
        return memo[index][sum] == 1;
    }

    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        sum >>= 1;
        boolean[][] dp = new boolean[n][sum + 1];
        dp[0][0] = true;
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][sum];
    }

    public boolean canPartition3(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        sum >>= 1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        if (nums[0] <= sum) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            if (dp[sum]) {
                return true;
            }
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        S416PartitionEqualSubsetSum solution = new S416PartitionEqualSubsetSum();
        System.out.println(solution.canPartition3(nums));
    }

    public void stringtest(){
        String str1 = "str";
        String str2 = "ing";
        String str = str1 + str2; //在堆上创建的新的对象
        String s = str.intern();
        String str3 = "string";
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(str));
        System.out.println(s == str);
        System.out.println(str == str3);
        String s1 = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        System.out.println(s2);//计算机
        System.out.println(s1 == s2);//false，因为一个是堆内存中的 String 对象一个是常量池中的 String 对象，
        System.out.println(s3 == s2);//true，因为两个都是常量池中的 String 对象
    }
}
