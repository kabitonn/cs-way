package com.vika.way.pre.algorithm.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscapeFarm {

    int sum = 0;
    private static final int mod = 1000000007;

    public void bactrack(List<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            int s = 0;
            for (int num : list) {
                s += num;
            }
            if (s % n == 0) {
                sum++;
                sum %= mod;
            }
        }
        for (int i = index; i < n; i++) {
            list.add(i);
            bactrack(list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public int countSum(int n, int k) {
        if (k == 0) {
            return sum;
        }
        bactrack(new ArrayList<Integer>(), n, k, 0);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        EscapeFarm escapeFarm = new EscapeFarm();
        int count = escapeFarm.countSum(n, k);
        System.out.println(count);
    }

}
