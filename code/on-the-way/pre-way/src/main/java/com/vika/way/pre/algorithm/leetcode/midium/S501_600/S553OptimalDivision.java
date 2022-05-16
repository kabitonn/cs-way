package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

public class S553OptimalDivision {

    public String optimalDivision(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return "";
        } else if (length == 1) {
            return nums[0] + "";
        } else if (length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        sb.append("/(");
        for (int i = 1; i < length - 1; i++) {
            sb.append(nums[i]);
            sb.append("/");
        }
        sb.append(nums[length - 1]);
        sb.append(")");
        return sb.toString();
    }

}
