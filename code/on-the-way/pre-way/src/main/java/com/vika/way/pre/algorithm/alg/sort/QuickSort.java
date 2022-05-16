package com.vika.way.pre.algorithm.alg.sort;



import com.vika.way.pre.algorithm.alg.common.RandomArray;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {

    public void quickSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int temp = nums[i];
        int low = i;
        int high = j;
        while (low < high) {
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        quickSort(nums, i, low - 1);
        quickSort(nums, low + 1, j);
    }

    public void quickPassSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int pivot = quickPass(nums, i, j);
        quickPassSort(nums, i, pivot - 1);
        quickPassSort(nums, pivot + 1, j);
    }

    public void quickSortRandom(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int pivot = partitionRandom(nums, i, j);
        quickPassSort(nums, i, pivot - 1);
        quickPassSort(nums, pivot + 1, j);
    }

    public void quickSortMidOfThree(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int pivot = partitionMidOfThree(nums, i, j);
        quickPassSort(nums, i, pivot - 1);
        quickPassSort(nums, pivot + 1, j);
    }

    public void quickSortInsert(int[] nums, int i, int j) {
        if (j - i <= 20) {
            insertSort(nums, i, j);
        }
        int pivot = partitionRandom(nums, i, j);
        quickPassSort(nums, i, pivot - 1);
        quickPassSort(nums, pivot + 1, j);
    }

    public void quickSortThreeWay(int[] nums, int left, int right) {
        if (right - left <= 20) {
            insertSort(nums, left, right);
            return;
        }
        int temp = nums[left];
        int lt = left;
        int i = left + 1;
        int gt = right + 1;
        while (i < gt) {
            if (nums[i] < temp) {
                swap(nums, i++, ++lt);
            } else if (nums[i] > temp) {
                swap(nums, i, --gt);
            } else {
                i++;
            }
        }
        swap(nums, left, lt);
        quickSortThreeWay(nums, left, lt - 1);
        quickSortThreeWay(nums, gt, right);
    }

    public void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= left && nums[j] > temp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }


    public int quickPass(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }

    public int partitionRandom(int[] nums, int low, int high) {
        int random = (int) (Math.random() * (high - low)) + low;
        swap(nums, low, random);
        return quickPass(nums, low, high);
    }

    public int partitionMidOfThree(int[] nums, int low, int high) {
        int mid = (low + high) >>> 1;
        if (nums[mid] > nums[high]) {
            swap(nums, mid, high);
        }
        if (nums[low] > nums[high]) {
            swap(nums, low, high);
        }
        if (nums[low] < nums[mid]) {
            swap(nums, low, mid);
        }
        return quickPass(nums, low, high);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void quickSortNonRecur0(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int low = i, high = j;
        int pivot = quickPass(nums, low, high);
        if (pivot - low > 1) {
            stack.push(low);
            stack.push(pivot - 1);
        }
        if (high - pivot > 1) {
            stack.push(pivot + 1);
            stack.push(high);
        }
        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            pivot = quickPass(nums, low, high);
            if (pivot - low > 1) {
                stack.push(low);
                stack.push(pivot - 1);
            }
            if (high - pivot > 1) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }

    public void quickSortNonRecur(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int low = i, high = j;
        int pivot;
        int left, right;
        while (low < high) {
            pivot = quickPass(nums, low, high);
            left = pivot - low;
            right = high - pivot;
            if (left > 1) {
                if (right > 1) {
                    stack.push(high);
                    stack.push(pivot + 1);
                }
                high = pivot - 1;
            } else if (right > 1) {
                low = pivot + 1;
            } else if (!stack.isEmpty()) {
                low = stack.pop();
                high = stack.pop();
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        int n = 100;
        int[] nums = RandomArray.randomArray(n, n);
        System.out.println(Arrays.toString(nums));
        QuickSort quickSort = new QuickSort();
        quickSort.quickSortThreeWay(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }
}
