package com.vika.way.pre.algorithm.leetcode.easy.S1001_2000;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class S1114PrintInOrder {

    private Lock lock = new ReentrantLock();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int step=1;

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            step = 2;
            condition2.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (step!=2){
                condition2.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            step=3;
            condition3.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (step!=3){
                condition3.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
        finally {
            lock.unlock();
        }
    }
}
