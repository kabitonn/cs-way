package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S033SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {3, 1};
        S033SearchInRotatedSortedArray solution = new S033SearchInRotatedSortedArray();
        System.out.println(solution.search2(nums, 1));
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int num;
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                num = nums[mid];
            } else {
                num = nums[0] > target ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (num > target) {
                high = mid - 1;
            } else if (num < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //左半段是有序的
            if (nums[start] <= nums[mid]) {
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            //右半段是有序的
            else {
                if (nums[end] >= target && nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int bias = getBiasByMax(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int trueMid = (mid + bias) % nums.length;
            if (nums[trueMid] == target) {
                return trueMid;
            } else if (nums[trueMid] < target) {
                start = mid + 1;
            } else if (nums[trueMid] > target) {
                end = mid - 1;
            }
        }
        return -1;
    }

    //找出最小值的数组下标
    public int getBiasByMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    //找出最大值的数组下标+1
    public int getBiasByMax(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (nums[mid] > nums[start]) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return (end + 1) % nums.length;
    }

    public int search0(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
