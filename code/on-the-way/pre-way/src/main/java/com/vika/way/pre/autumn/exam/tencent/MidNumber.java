package com.vika.way.pre.autumn.exam.tencent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author tangjiawei
 * @Date 2020/9/6
 */

class Node {
    public int val;
    public int index;

}

public class MidNumber {

    public void remainMid(Node[] nums) {
        int n = nums.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[nums[i].index] = i;
        }
        for (int i = 0; i < n; i++) {
            int mid = findRemainMid(nums, n, index[i]);
            System.out.println(mid);
        }
    }

    public void remainCopyMid(int[] nums) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(nums);
        int left = nums[n / 2 - 1];
        int right = nums[n / 2];
        for (int i = 0; i < n; i++) {
            int mid;
            if (copy[i] < left) {
                mid = right;
            } else {
                mid = left;
            }
            System.out.println(mid);
        }
    }


    public int findRemainMid(Node[] nums, int n, int d) {
        if (n % 2 != 0) {
            return -1;
        }
        if (d < n / 2) {
            return nums[n / 2].val;
        } else {
            return nums[n / 2 - 1].val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nums = new Node[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new Node();
            nums[i].val = scanner.nextInt();
            nums[i].index = i;
        }
        Arrays.sort(nums, Comparator.comparingInt(o -> o.val));
        MidNumber main = new MidNumber();
        main.remainMid(nums);
    }
}
