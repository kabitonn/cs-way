package com.vika.way.pre.algorithm.leetcode.easy.S1001_2000;

public class S1114PrintInOrder_5 {

    private volatile int step = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        while (step != 1) {
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        step = 2;

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (step != 2) {
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        step = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (step != 3) {
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
