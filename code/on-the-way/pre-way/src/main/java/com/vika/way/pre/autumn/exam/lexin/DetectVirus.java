package com.vika.way.pre.autumn.exam.lexin;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author ：tangjiawei
 * @date ：2020/9/9 10:42
 */
public class DetectVirus {

    public int detectNumber(int n, int m, int k) {
        int count = 0;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        DetectVirus main = new DetectVirus();
        System.out.println(main.detectNumber(n, m, k));
    }

    @Test
    public void test() {
        System.out.println(detectNumber(10000, 2, 2));
    }
}
