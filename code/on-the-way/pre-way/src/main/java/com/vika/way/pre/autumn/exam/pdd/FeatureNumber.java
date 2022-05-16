package com.vika.way.pre.autumn.exam.pdd;

import java.util.*;

public class FeatureNumber {

    public int countFeature(int n, int[] M) {
        int m = M.length;
        Arrays.sort(M);
        List<Integer> list = simplifyFeature(M);
        Set set = new HashSet();
        for (int y : list) {
            int count = 1;
            while (count * y <= n) {
                int v = y * count++;
                set.add(v);
            }
        }
        return set.size();
    }

    public List<Integer> simplifyFeature(int[] M) {
        List<Integer> list = new ArrayList<>();
        for (int num : M) {
            if (list.size() == 0) {
                list.add(num);
                continue;
            }
            boolean found = false;
            for (int y : list) {
                if (num % y == 0) {
                    found = true;
                }
            }
            if (!found) {
                list.add(num);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] set = new int[m];
        for (int i = 0; i < m; i++) {
            set[i] = sc.nextInt();
        }
        FeatureNumber solution = new FeatureNumber();
        int result = solution.countFeature(n, set);
        System.out.println(result);
    }
}
