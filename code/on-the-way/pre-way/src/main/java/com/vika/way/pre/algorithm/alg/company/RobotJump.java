package com.vika.way.pre.algorithm.alg.company;

import java.util.Scanner;

public class RobotJump {

    public int initValue(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int value = 0;
        for (int i = n - 1; i >= 0; i--) {
            value = (value + nums[i] + 1) / 2;
        }
        return value;
    }

    public static void main(String[] args) {
        int[] array = {
            98417,61639,59941,68033,76628,18375,11190,92249,14287,90647,48643,78379
        };
        RobotJump robotJump = new RobotJump();
        System.out.println(robotJump.initValue(array));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(robotJump.initValue(nums));
    }
}
