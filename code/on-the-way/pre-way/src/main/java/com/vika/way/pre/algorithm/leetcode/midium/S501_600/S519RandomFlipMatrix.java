package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class S519RandomFlipMatrix {

    Set<Integer> flippedIndex;
    Random random;
    int rows, cols, size;


    public S519RandomFlipMatrix(int n_rows, int n_cols) {
        random = new Random();
        rows = n_rows;
        cols = n_cols;
        size = rows * cols;
        flippedIndex = new HashSet<>();
    }

    public int[] flip() {
        if (flippedIndex.size() == size) {
            return null;
        }
        int index;
        do {
            index = random.nextInt(size);
        } while (flippedIndex.contains(index));
        int[] pos = {index / cols, index % cols};
        flippedIndex.add(index);
        return pos;
    }

    public void reset() {
        flippedIndex.clear();
    }
}
