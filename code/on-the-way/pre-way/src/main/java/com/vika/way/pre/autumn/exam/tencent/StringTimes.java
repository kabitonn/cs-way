package com.vika.way.pre.autumn.exam.tencent;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author tangjiawei
 * @Date 2020/9/6
 */
public class StringTimes {

    public void stringCompare(String[] strs, int k) {
        Map<String, Integer> map = new HashMap<>();
        int n = strs.length;
        for (String s : strs) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        String[] sort = map.keySet().toArray(new String[0]);
        Arrays.sort(sort, (o1, o2) -> map.get(o1).equals(map.get(o2)) ? o1.compareTo(o2) : map.get(o2).compareTo(map.get(o1)));
        for (int i = 0; i < k; i++) {
            String s = sort[i];
            System.out.println(s + " " + map.get(s));
        }

        Arrays.sort(sort, (o1, o2) -> map.get(o1).equals(map.get(o2)) ? o1.compareTo(o2) : map.get(o1).compareTo(map.get(o2)));
        for (int i = 0; i < k; i++) {
            String s = sort[i];
            System.out.println(s + " " + map.get(s));
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }
        StringTimes main = new StringTimes();
        main.stringCompare(strs, k);
    }

    @Test
    public void test() {
        String[] strs = {"1", "1", "2", "3"};
        stringCompare(strs, 2);
    }
}
