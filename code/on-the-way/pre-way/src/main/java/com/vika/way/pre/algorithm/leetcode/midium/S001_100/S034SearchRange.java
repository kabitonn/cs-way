package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S034SearchRange {

    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int position = binarySearch(nums, target);
        if (position != -1) {
            int start = position;
            int end = position;
            while (start > 0 && nums[start - 1] == target) {
                start--;
            }
            while (end < nums.length - 1 && nums[end + 1] == target) {
                end++;
            }
            return new int[]{start, end};
        }
        return new int[]{-1, -1};
    }

    public int[] searchRange1(int[] nums, int target) {
        int left = binarySearchMin(nums, target);
        if (left != -1) {
            int start = left;
            int end = start;
            while (end < nums.length - 1 && nums[end + 1] == target) {
                end++;
            }
            return new int[]{start, end};
        }
        return new int[]{-1, -1};
    }

    public int[] searchRange2(int[] nums, int target) {
        int right = binarySearchMin(nums, target);
        if (right != -1) {
            int start = right;
            int end = start;
            while (start > 0 && nums[start - 1] == target) {
                start--;
            }
            return new int[]{start, end};
        }
        return new int[]{-1, -1};
    }

    public int[] searchRange3(int[] nums, int target) {
        int left = binarySearchMin(nums, target);
        int right = binarySearchMax(nums, target);

        return new int[]{left, right};
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;    //注意
        while (left <= right) {    //注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchMin(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //right最大值是取不到的,搜索区间左闭右开
        while (left < right) {
            //由分支确定左中点
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
                //搜索区间右移
            } else if (nums[mid] >= target) {
                right = mid;
            }
        }
        //若left == length,则必然不存在目标元素，且所有元素都小于目标元素
        //其次，也可能不存在目标元素
        left = (left < nums.length && nums[left] == target) ? left : -1;
        return left;
    }

    public int binarySearchMax(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //right最大值是取不到的,搜索区间左闭右开
        while (left < right) {
            //由分支逻辑确定左中点
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
                //搜索区间右移
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        //若left == 0,则必然不存在目标元素，且所有元素都大于目标元素
        //其次，也可能不存在目标元素，返回的left为第一个大于目标元素的下标
        left = (left > 0 && nums[left - 1] == target) ? left - 1 : -1;
        return left;
    }

    public int binarySearchLowBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 根据分支逻辑，这里选择左中位数
            int mid = (left + right) >>> 1;
            // 因为找大于等于 target 的第 1 个数，因此小于一定不符合要求
            // 把它写在分支的前面
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 因为有可能不存在目标元素，最后一定要单独判断一下
        if (nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int binarySearchUpBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 根据分支逻辑，这里选择右中位数
            int mid = (left + right + 1) >>> 1;
            // 因为找小于等于 target 的最后 1 个数，因此大于一定不符合要求
            // 把它写在分支的前面
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为有可能不存在目标元素，最后一定要单独判断一下
        if (nums[left] != target) {
            return -1;
        }
        return left;
    }

}
