package com.vika.way.pre.algorithm.alg.sort;



import com.vika.way.pre.algorithm.alg.common.RandomArray;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int n = right - left + 1;
        int mid = (left + right) >>> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int[] sorted = new int[n];
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                sorted[k++] = nums[i++];
            } else {
                sorted[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            sorted[k++] = nums[i++];
        }
        while (j <= right) {
            sorted[k++] = nums[j++];
        }
        for (i = left, k = 0; k < n; i++, k++) {
            nums[i] = sorted[k];
        }
    }

    public void mergeSort1(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >>> 1;
        mergeSort1(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    public void merge(int[] nums, int left, int right, int mid) {
        int n = right - left + 1;
        int[] sorted = new int[n];
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                sorted[k++] = nums[i++];
            } else {
                sorted[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            nums[--j] = nums[mid--];
        }
        while (k > 0) {
            nums[--j] = sorted[--k];
        }
    }

    public void mergeSortNonRecur(int[] nums) {
        int n = nums.length;
        int left, right, mid;
        for (int step = 1; step < n; step <<= 1) {
            for (left = 0; left < n - step; left = right + 1) {
                mid = left + step - 1;
                right = mid + step;
                right = right >= n ? n - 1 : right;
                merge(nums, left, right, mid);
            }
        }
    }

    public void merge(int[] nums, int[] copy, int left, int right, int mid) {
        int i = left, j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                copy[k++] = nums[i++];
            } else {
                copy[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            copy[k++] = nums[i++];
        }
        while (j <= right) {
            copy[k++] = nums[j++];
        }
    }

    public void mergeSortNonRecur1(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        int left, right, mid;
        boolean is = true;
        for (int step = 1; step < n; step <<= 1) {
            for (left = 0; left < n - step * 2; left = right + 1) {
                mid = left + step - 1;
                right = mid + step;
                if (is) {
                    merge(nums, copy, left, right, mid);
                } else {
                    merge(copy, nums, left, right, mid);
                }
            }
            mid = left + step - 1;
            if (mid >= n) {
                mid = n - 1;
            }
            right = mid + step;
            if (right >= n) {
                right = n - 1;
            }
            if (is) {
                merge(nums, copy, left, right, mid);
            } else {
                merge(copy, nums, left, right, mid);
            }
            is = !is;
            /*System.out.println(left);
            if (is) {
                System.out.println("step " + step + ":" + Arrays.toString(nums));
            } else {
                System.out.println("step " + step + ":" + Arrays.toString(copy));
            }*/
        }
        if (!is) {
            for (int i = 0; i < n; i++) {
                nums[i] = copy[i];
            }
        }
    }

    public void mergeSortNonRecur2(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        int left, right, mid;
        boolean is = true;
        for (int step = 1; step < n; step <<= 1) {
            for (left = 0; left < n; left = right + 1) {
                mid = left + step - 1;
                mid = mid >= n ? n - 1 : mid;
                right = mid + step;
                right = right >= n ? n - 1 : right;
                if (is) {
                    merge(nums, copy, left, right, mid);
                } else {
                    merge(copy, nums, left, right, mid);
                }
            }
            is = !is;
        }
        if (!is) {
            for (int i = 0; i < n; i++) {
                nums[i] = copy[i];
            }
        }
    }


    public static void main(String[] args) {
        int n = 1000000;
        int[] nums = RandomArray.randomArray(n, n);
        int[] copy = nums.clone();
        //System.out.println(Arrays.toString(nums));
        MergeSort mergeSort = new MergeSort();
        //mergeSort.mergeSort1(nums, 0, nums.length - 1);
        mergeSort.mergeSortNonRecur2(nums);
        //System.out.println(Arrays.toString(nums));
        Arrays.sort(copy);
        //System.out.println(Arrays.toString(copy));
        for (int i = 0; i < n; i++) {
            if (nums[i] != copy[i]) {
                System.out.println(i + " " + false + " " + nums[i] + " " + copy[i]);
            }
        }
        System.out.println(true);
    }
}
