package com.vika.way.pre.autumn.interview.tencent;

import org.junit.Test;

/**
 * @Author tangjiawei
 * @Date 2020/9/1
 */
public class BinarySearch {

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (mid > target) {
                right = mid - 1;
            } else if (mid < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int index = binarySearch(nums, 3);
        System.out.println(index);
    }
}
