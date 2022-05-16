package com.vika.way.pre.autumn.exam.alibaba;

import org.junit.Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ：tangjiawei
 * @date ：2020/9/4 9:05
 */
public class SightTable {

    public final int mod = 998244353;

    public int permute(int[] nums, int index) {
        if (index == nums.length) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            swap(nums, index, i);
            sum += permute(nums, index + 1);
            sum %= mod;
            swap(nums, index, i);
        }
        return sum;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int possible(int n, int[] count) {
        int[] nums = new int[n * n];
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[k++] = i + 1;
            }
        }
        return permute(nums, 0);
    }

    public int possibleCount(int n, int[] count) {
        n = n * n;
        long total = 1;
        for (int i = 0; i < count.length; i++) {
            total *= combineNumber(n, count[i]) % mod;
            n -= count[i];
        }
        return (int) (total % mod);
        //n!/a!/b!/c!/d!
    }

    public int combineNumber(int n, int k) {
        k = Math.min(k, n - k);
        long p = 1;
        for (int i = 0; i < k; i++) {
            p = (p * (n - i) / (i + 1));
        }
        return (int) p;
    }


    public long factorial(int n) {
        long factor = n;
        while (--n > 0) {
            factor *= n;
        }
        return factor;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] count = new int[4];
        for (int i = 0; i < 4; i++) {
            count[i] = sc.nextInt();
        }
        SightTable main = new SightTable();
        int result = main.possible(n, count);
        System.out.println(result);

    }

    @Test
    public void test() {
        int n = 3;
        int[] count = {3, 2, 2, 2};
        int result = possible(n, count);
        int r = possibleCount(n, count);
        System.out.println(result);
        System.out.println(r);

    }
}
