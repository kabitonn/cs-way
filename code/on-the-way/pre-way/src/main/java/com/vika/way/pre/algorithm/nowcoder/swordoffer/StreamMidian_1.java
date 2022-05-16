package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMidian_1 {

    PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    PriorityQueue<Integer> right = new PriorityQueue<>();
    int count = 0;

    public void Insert(Integer num) {
        if ((count & 1) == 0) {
            left.offer(num);
            int max = left.poll();
            right.offer(max);
        } else {
            right.offer(num);
            int min = right.poll();
            left.offer(min);
        }
        count++;
    }

    @Test
    public void test() {
        int[] stream = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int n : stream) {
            Insert(n);
            System.out.println(GetMedian());
        }
    }

    public Double GetMedian() {
        double n2 = right.peek();
        if ((count & 1) == 0) {
            double n1 = left.peek();
            return (n1 + n2) / 2;
        } else {
            return n2;
        }
    }


}
