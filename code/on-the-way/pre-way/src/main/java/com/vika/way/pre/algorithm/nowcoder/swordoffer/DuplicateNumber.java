package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class DuplicateNumber {

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            while (numbers[numbers[i]] != numbers[i]) {
                swap(numbers, numbers[i], i);
            }
        }
        boolean valid = false;
        int k = 0;
        for (int i = 0; i < length; i++) {
            if (i != numbers[i]) {
                valid = true;
                duplication[k++] = numbers[i];
            }
        }
        return valid;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
