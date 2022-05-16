package com.vika.way.pre.algorithm.leetcode.easy.S1001_2000;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class S1114PrintInOrder_2 {

    private CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);
    private CyclicBarrier cyclicBarrier3 = new CyclicBarrier(2);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        try {
            cyclicBarrier2.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            cyclicBarrier2.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            cyclicBarrier3.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            cyclicBarrier3.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
