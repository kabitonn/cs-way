package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class S406QueueReconstructionByHeight {


    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //h降序 k升序
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[0][]);
    }

    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //h升序 k降序
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        List<Integer> unusedIndex = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            unusedIndex.add(i);
        }
        int[][] queue = new int[people.length][2];
        for (int[] p : people) {
            Integer index = unusedIndex.get(p[1]);
            queue[index] = p;
            unusedIndex.remove(p[1]);
        }
        return queue;
    }
}
