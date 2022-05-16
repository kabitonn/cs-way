package com.vika.way.pre.autumn.exam.tencent;

import java.util.Scanner;

/**
 * @Author tangjiawei
 * @Date 2020/9/6
 */
public class RedBlack {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int[] nums = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(n * 2 - 1);
    }
}
