package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class PokeSequence {

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //int zero = 0;
        boolean[] visited = new boolean[14];
        for (int n : numbers) {
            if (n == 0) {
                //zero++;
                continue;
            }
            if (visited[n]) {
                return false;
            }
            if (n < min) {
                min = n;
            }
            if (n > max) {
                max = n;
            }
            visited[n] = true;
        }
        if (max - min > 4) {
            return false;
        }
        return true;
    }
}
