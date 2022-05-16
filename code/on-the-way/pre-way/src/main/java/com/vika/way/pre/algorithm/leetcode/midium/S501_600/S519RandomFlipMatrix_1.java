package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class S519RandomFlipMatrix_1 {

    Map<Integer, Integer> flippedIndex;
    Random random;
    int rows, cols;
    int availableNum;


    public S519RandomFlipMatrix_1(int n_rows, int n_cols) {
        random = new Random();
        rows = n_rows;
        cols = n_cols;
        availableNum = rows * cols;
        flippedIndex = new HashMap<>();
    }

    public int[] flip() {
        if (availableNum == 0) {
            return null;
        }
        int i = random.nextInt(availableNum--);
        int index = flippedIndex.getOrDefault(i, i);
        flippedIndex.put(i, flippedIndex.getOrDefault(availableNum, availableNum));
        int[] pos = {index / cols, index % cols};
        return pos;
    }

    public void reset() {
        availableNum = rows * cols;
        flippedIndex.clear();
    }
}
