package com.vika.way.pre.autumn.exam.alibaba;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Author tangjiawei
 * @Date 2020/8/28
 */
public class TransferString {

    public int minTransferStep(String s, String p) {
        if (s.equals(p)) {
            return 0;
        }
        String r = new StringBuilder(s).reverse().toString();
        int min = Math.min(transferStep(s, p), 1 + transferStep(r, p));
        return min;
    }

    public int transferStep(String s, String p) {
        int zero = 0;
        int one = 0;
        int step = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == p.charAt(i)) {
                continue;
            }
            step++;
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                one++;
            }
        }
        step -= Math.min(zero, one);
        return step;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.nextLine();
        String p = sc.nextLine();
        TransferString solution = new TransferString();
        int result = solution.minTransferStep(s, p);
        System.out.println(result);
    }

    @Test
    public void test() {
        System.out.println(minTransferStep("1111000", "0010011"));
    }
}
