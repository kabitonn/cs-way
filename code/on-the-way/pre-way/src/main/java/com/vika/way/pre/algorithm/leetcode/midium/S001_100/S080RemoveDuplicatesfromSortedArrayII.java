package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S080RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int index = 1;
        boolean duplicate = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
                duplicate = false;
            } else if (!duplicate) {
                nums[index++] = nums[i];
                duplicate = true;
            }
        }
        return index;
    }

    public int removeDuplicates1(int[] nums) {
        int slow = 0;
        int fast = 1;
        int count = 1;
        int max = 2;
        for (; fast < nums.length; fast++) {
            //当前遍历的数字和慢指针末尾数字不同，就加到慢指针的末尾
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
                count = 1;
            } else if (count++ < max) {
                nums[++slow] = nums[fast];
            }

        }
        return slow + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 1;
        int fast = 2;
        int max = 2;
        for (; fast < nums.length; fast++) {
            //不相等的话就添加
            if (nums[fast] != nums[slow - max + 1]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
