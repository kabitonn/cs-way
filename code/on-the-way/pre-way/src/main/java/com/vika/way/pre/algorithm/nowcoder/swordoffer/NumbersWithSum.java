package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer max = null;
        for (int n : array) {
            if (map.containsKey(sum - n)) {
                max = n;
            }
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        if (max == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(sum - max, max));
    }

    public ArrayList<Integer> FindNumbersWithSum1(int[] array, int sum) {
        if (array == null || array.length < 2) {
            return new ArrayList<>();
        }
        int low = 0, high = array.length - 1;
        while (low < high) {
            int s = array[low] + array[high];
            if (s < sum) {
                low++;
            } else if (s > sum) {
                high--;
            } else {
                return new ArrayList<>(Arrays.asList(array[low], array[high]));
            }
        }
        return new ArrayList<>();
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 4, 7, 11, 15};
        System.out.println(FindNumbersWithSum1(arr, 15));
    }
}
