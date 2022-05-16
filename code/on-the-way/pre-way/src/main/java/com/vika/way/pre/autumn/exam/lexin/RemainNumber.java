package com.vika.way.pre.autumn.exam.lexin;

import java.util.Scanner;

/**
 * @author ：tangjiawei
 * @date ：2020/9/9 10:34
 */
public class RemainNumber {

    public int minNumber(int[] m, int[] r, int k) {
        int d = 1;
        for (int f : m) {
            d *= f;
        }
        for (int x = 1; x <= d * 2; x++) {
            int i = 0;
            for (; i < k; i++) {
                if ((x - r[i]) % m[i] != 0) {
                    break;
                }
            }
            if (i == k) {
                return x;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] m = new int[k];
        int[] r = new int[k];
        for (int i = 0; i < k; i++) {
            m[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }
    }
}
