package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.ArrayList;
import java.util.List;

public class S060PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int num = fabric(n);
        while (n > 0) {
            num /= n--;
            int groupNum = k / num;
            k %= num;
            if (k == 0) {
                sb.append(list.get(groupNum - 1));
                list.remove(groupNum - 1);
                break;
            } else {
                sb.append(list.get(groupNum));
                list.remove(groupNum);
            }
        }
        //Collections.reverse(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public String getPermutation1(int n, int k) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int num = fabric(n);
        k--;
        while (n > 0) {
            num /= n--;
            int groupNum = k / num;
            k %= num;
            sb.append(list.get(groupNum));
            list.remove(groupNum);
        }
        return sb.toString();
    }

    private int fabric(int n) {
        int fab = 1;
        while (n != 0) {
            fab *= n--;
        }
        return fab;
    }
}
