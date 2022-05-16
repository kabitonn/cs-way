package com.vika.way.pre.algorithm.alg.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MajSoul {

    public List<Integer> complete(int[] nums) {
        int[] count = new int[10];
        for (int num : nums) {
            count[num]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (count[i] < 4) {
                count[i]++;
                if (isComplete(count, false)) {
                    list.add(i);
                }
                count[i]--;
            }
        }

        return list;
    }

    public boolean isComplete(int[] count, boolean flag) {
        int remain = 0;
        for (int num : count) {
            remain += num;
        }
        if (remain == 0) {
            return true;
        }
        if (!flag) {
            for (int i = 1; i < 10; i++) {
                if (count[i] >= 2) {
                    count[i] -= 2;
                    boolean success = isComplete(count, true);
                    count[i] += 2;
                    if (success) {
                        return true;
                    }
                }
            }
        } else {
            for (int i = 1; i < 10; i++) {
                if (count[i] >= 3) {
                    count[i] -= 3;
                    boolean success = isComplete(count, true);
                    count[i] += 3;
                    if (success) {
                        return true;
                    }
                }
            }
            for (int i = 1; i <= 7; i++) {
                if (count[i] > 0 && count[i + 1] > 0 && count[i + 2] > 0) {
                    count[i]--;
                    count[i + 1]--;
                    count[i + 2]--;
                    boolean success = isComplete(count, true);
                    count[i]++;
                    count[i + 1]++;
                    count[i + 2]++;
                    if (success) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 2, 5, 5, 5, 6, 6, 6, 9};
        MajSoul majSoul = new MajSoul();
        System.out.println(majSoul.complete(array));
        Scanner scanner = new Scanner(System.in);
        final int N = 13;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        List<Integer> list = majSoul.complete(nums);
        if (list.size() == 0) {
            System.out.println(0);
        } else {
            for(int key:list){
                System.out.print(key+" ");
            }
        }
    }

}
