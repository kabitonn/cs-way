package com.vika.way.pre.autumn.exam.alibaba;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：tangjiawei
 * @date ：2020/9/4 9:34
 */
public class Forest {

    public int maxTreeNum(List<Integer>[] adjacentList, int n) {
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        for (int i = 0; i < n; i++) {
            outDegree[i] = adjacentList[i].size();
            for (int j : adjacentList[i]) {
                inDegree[j]++;
            }
        }
        int total = 0;
        boolean[] removed = new boolean[n];
        while (true) {
            int root = -1;
            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 0 && outDegree[i] > 0) {
                    root = i;
                    break;
                }
            }
            if (root == -1) {
                break;
            }
            int delete = root;
            boolean single = true;
            while (adjacentList[delete].size() > 0) {
                removed[delete] = true;
                outDegree[delete] = 0;
                for (int adj : adjacentList[delete]) {
                    inDegree[adj]--;
                }
                if (adjacentList[delete].size() > 1) {
                    single = false;
                }
                delete = adjacentList[delete].get(0);
                removed[delete] = true;
            }
            if (single) {
                total++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>[] adjacentList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacentList[i] = new ArrayList<>();
        }
        // 7 1 2 1 3  2 4 2 5 3 6 3 7
        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjacentList[u - 1].add(v - 1);
        }
        Forest main = new Forest();
        int result = main.maxTreeNum(adjacentList, n);
        System.out.println(result);
    }

    @Test
    public void test() {
        int n = 7;
        List<Integer>[] adjacentList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacentList[i] = new ArrayList<>();
        }
        adjacentList[0].add(1);
        adjacentList[0].add(2);
        adjacentList[1].add(3);
        adjacentList[1].add(4);
        adjacentList[2].add(5);
        adjacentList[2].add(6);
        int r = maxTreeNum(adjacentList, n);
        System.out.println(r);
    }
}
