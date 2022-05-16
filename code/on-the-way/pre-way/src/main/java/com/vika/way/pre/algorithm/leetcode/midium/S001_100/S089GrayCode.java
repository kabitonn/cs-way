package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S089GrayCode {
    public static void main(String[] args) {
        S089GrayCode solution = new S089GrayCode();
        System.out.println(solution.grayCode(3));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int[] code = new int[n];
        for (int i = 0; i < n; i++) {
            code[i] = 1 << i;
        }
        int num = 1 << n;
        Set<Integer> set = new HashSet<>();
        list.add(0);
        set.add(0);
        while (list.size() != num) {
            int last = list.get(list.size() - 1);
            for (int i = 0; i < n; i++) {
                int cur = last ^ code[i];
                if (!set.contains(cur)) {
                    list.add(cur);
                    set.add(cur);
                    break;
                }
            }
        }
        return list;
    }

    //公式
    public List<Integer> grayCode1(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        for (int binary = 0; binary < 1 << n; binary++) {
            gray.add(binary ^ binary >> 1);
        }
        return gray;
    }

    //规律
    public List<Integer> grayCode2(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        //初始化 n = 0 的解
        gray.add(0);
        for (int i = 0; i < n; i++) {
            //要加的数
            int add = 1 << i;
            //倒序遍历，并且加上一个值添加到结果中
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }

    //格雷码生成规律
    public List<Integer> grayCode3(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        gray.add(0);
        for (int i = 1; i < 1 << n; i++) {
            int last = gray.get(i - 1);
            if ((i & 1) == 1) {
                //第一项改变上一项最右边的位元
                gray.add(last ^ 1);
            } else {
                //第二项改变上一项右起第一个为 1 的位元的左边位
                int tmp = last;
                for (int bit = 0; bit < n; bit++) {
                    if ((tmp & 1) == 1) {
                        gray.add(last ^ (1 << (bit + 1)));
                        break;
                    }
                    tmp >>= 1;
                }
            }
        }
        return gray;
    }

}
