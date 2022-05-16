package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlideWindowMax {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || num.length < size || size == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, num[i]);
        }
        list.add(max);
        for (int i = 0, j = size; j < num.length; i++, j++) {
            if (max == num[i]) {
                max = Integer.MIN_VALUE;
                for (int k = i + 1; k < j; k++) {
                    max = Math.max(max, num[k]);
                }
            }
            max = Math.max(max, num[j]);
            list.add(max);
        }
        return list;
    }

    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        if (num == null || num.length < size || size == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(size, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < num.length; i++) {
            maxHeap.offer(num[i]);
            if (maxHeap.size() == size) {
                list.add(maxHeap.peek());
                maxHeap.remove(num[i - size + 1]);
            }
        }
        return list;
    }

    @Test
    public void test() {
        int[] num = {10, 14, 12, 11};
        System.out.println(maxInWindows1(num, 2));
    }
}
