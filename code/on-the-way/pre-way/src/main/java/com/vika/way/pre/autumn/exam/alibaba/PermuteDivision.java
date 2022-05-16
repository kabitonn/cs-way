package com.vika.way.pre.autumn.exam.alibaba;

import org.junit.Test;

import java.util.*;

/**
 * @Author tangjiawei
 * @Date 2020/8/28
 */
public class PermuteDivision {

    public List<Long> permute(long n) {
        char[] num = String.valueOf(n).toCharArray();
        Arrays.sort(num);
        List<Long> integerList = new ArrayList<>();
        backtrack(integerList, new boolean[num.length], new ArrayList<>(), num);
        return integerList;
    }

    public void backtrack(List<Long> stringList, boolean[] visited, List<Character> list, char[] num) {
        if (list.size() == num.length) {
            if (list.get(0) != '0') {
                StringBuilder sb = new StringBuilder();
                for (char c : list) {
                    sb.append(c);
                }
                stringList.add(Long.valueOf(sb.toString()));
            }
        }
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                list.add(num[i]);
                visited[i] = true;
                backtrack(stringList, visited, list, num);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public void permute(List<Long> longList, char[] num, int start) {
        if (start == num.length) {
            if (num[0] != '0') {
                longList.add(Long.valueOf(String.valueOf(num)));
            }
        }
        Set<Character> set = new HashSet<>();
        for (int i = start; i < num.length; i++) {
            if (set.contains(num[i])) {
                continue;
            }
            set.add(num[i]);
            swap(num, start, i);
            permute(longList, num, start + 1);
            swap(num, start, i);
        }
    }

    public void swap(char[] num, int i, int j) {
        char t = num[i];
        num[i] = num[j];
        num[j] = t;
    }

    public int countFit(long n, int m) {
        int count = 0;
        List<Long> nums = permute(n);
        for (long num : nums) {
            if (num % m == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();
        PermuteDivision solution = new PermuteDivision();
        System.out.println(solution.countFit(n, m));
    }

    @Test
    public void test() {
        System.out.println(countFit(322, 2));
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while(n/5!=0) {
            count += n/5;
            n/=5;
        }
        return count;
    }

    @Test
    public void test1(){
        System.out.println(trailingZeroes(10000));
    }

    @Test
    public void test2(){
        System.out.println(Math.pow(2,100)%7);
    }
}
