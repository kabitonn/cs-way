package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.LinkedList;
import java.util.Queue;

public class AppearOnceChar1 {

    int[] map = new int[256];
    Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map[ch]++ == 0) {
            queue.add(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char first = '#';
        while (!queue.isEmpty()) {
            char ch = queue.peek();
            if (map[ch] == 1) {
                return ch;
            } else {
                queue.poll();
            }
        }
        return first;
    }
}
