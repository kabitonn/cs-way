package com.vika.way.pre.algorithm.alg.company;

import java.util.Scanner;

public class Ambush {

    final int mod = 99997867;

    public long ambush(int d, int[] nums) {
        return backtrack(d, nums, 0, new int[3], 0);
    }

    public long backtrack(int d, int[] nums, int pos, int[] array, int k) {
        if (k == 3) {
            if (array[2] - array[0] <= d) {
                return 1;
            }
            return 0;
        }
        int sum = 0;
        for (int i = pos; i < nums.length; i++) {
            array[k] = nums[i];
            sum += backtrack(d, nums, i + 1, array, k + 1) % mod;
        }
        return sum % mod;
    }


    public long ambush1(int d, int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[j] - nums[i] > d) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] - nums[i] > d) {
                        continue;
                    }
                    sum++;
                }
            }
        }
        return sum % mod;
    }

    public long ambush2(int d, int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j < n; j++) {
                if (nums[j] - nums[i] > d) {
                    continue;
                }
                sum += (j - i - 1);
                sum %= mod;
            }
        }
        return sum % mod;
    }

    public long ambush3(int d, int[] nums) {
        int n = nums.length;
        long sum = 0;
        int i = 0;
        int j = i + 2;
        for (; i < n - 2; i++) {
            while (j < n && nums[j] - nums[i] <= d) {
                j++;
            }
            if (j - i > 2) {
                int num = j - i - 1;
                sum += computeCn2(num) % mod;
            }
        }
        return sum % mod;
    }

    public long ambush4(int d, int[] nums) {
        int n = nums.length;
        long sum = 0;
        int i = 0;
        int j = i + 2;
        for (; j < n; j++) {
            while (nums[j] - nums[i] > d) {
                i++;
            }
            if (j - i >= 2) {
                int num = j - i;
                sum += computeCn2(num);
            }
        }
        return sum % mod;
    }

    public long computeCn2(long n) {
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Ambush ambush = new Ambush();
        System.out.println(ambush.ambush3(10, nums));
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        scanner.nextLine();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(ambush.ambush(D, array));
        scanner.close();
    }
}
