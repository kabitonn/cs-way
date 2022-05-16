package com.vika.way.pre.application.queue;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用数组，实现一个的循环队列（先进先出）,如果能实现支持并发考虑更好（一写多读）。能无锁更好
 */
public class BlockingCycleQueue {

    final int capacity = 10;
    final Lock putLock = new ReentrantLock();
    final Lock takeLock = new ReentrantLock();
    final Condition notEmpty = takeLock.newCondition();
    final Condition notFull = putLock.newCondition();
    int[] queue = new int[capacity];
    AtomicInteger count = new AtomicInteger();
    int value=0;
    int head;
    int tail;

    public BlockingCycleQueue() {
    }

    public int pop() throws InterruptedException {
        int popData = 0;
        int c = -1;
        final AtomicInteger count = this.count;
        final Lock takeLock = this.takeLock;
        takeLock.lock();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            popData = queue[head];
            head = (head + 1) % capacity;
            c = count.getAndDecrement();
            if (c > 1) {
                notEmpty.signal();
            }
        } finally {
            takeLock.unlock();
        }
        if (c == capacity) {
            signalNotFull();
        }
        return popData;
    }

    public int push(int data) throws InterruptedException {
        int pushData = 0;
        int c = -1;
        final Lock putLock = this.putLock;
        final AtomicInteger count = this.count;
        putLock.lock();
        try {
            while (count.get() == capacity) {
                notFull.await();
            }
            queue[tail] = value;
            pushData = value++;
            tail = (tail + 1) % capacity;
            c = count.getAndIncrement();
            if (c < capacity - 1) {
                notFull.signal();
            }
        } finally {
            putLock.unlock();
        }
        if (c == 0) {
            signalNotEmpty();
        }
        return pushData;
    }


    public void signalNotFull() {
        final Lock putLock = this.putLock;
        putLock.lock();
        try {
            notFull.signal();
        } finally {
            putLock.unlock();
        }
    }

    public void signalNotEmpty() {
        final Lock takeLock = this.takeLock;
        takeLock.lock();
        try {
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }

    @Test
    public void testManyToMany() throws InterruptedException {
        BlockingCycleQueue queue = new BlockingCycleQueue();
        int countProvider = 5;
        int countConsumer = 5;
        Provider[] providers = new Provider[countProvider];
        for (int i = 0; i < countProvider; i++) {
            providers[i] = new Provider(queue, "p" + i);
        }
        Consumer[] consumers = new Consumer[countConsumer];
        for (int i = 0; i < countConsumer; i++) {
            consumers[i] = new Consumer(queue, "c" + i);
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?>[] consumerFutures = new Future[countConsumer];
        for (int i = 0; i < countConsumer; i++) {
            consumerFutures[i] = executorService.submit(consumers[i]);
        }
        Future<?>[] providerFutures = new Future[countProvider];
        for (int i = 0; i < countProvider; i++) {
            providerFutures[i] = executorService.submit(providers[i]);
        }
        Thread.sleep(1000L);
        for (int i = 0; i < countProvider; i++) {
            providerFutures[i].cancel(true);
        }
        for (int i = 0; i < countConsumer; i++) {
            consumerFutures[i].cancel(true);
        }
    }

    class Provider implements Runnable {
        private BlockingCycleQueue queue;
        private String name;

        private int a = 0;

        public Provider(BlockingCycleQueue queue, String name) {
            this.queue = queue;
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int data = queue.push(a++);
                    System.out.println("生产者" + name + "生产:" + data);
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println(name + "生产终止");
                    break;
                } catch (Exception e) {
                    //System.out.println(e);
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {

        private BlockingCycleQueue queue;
        private String name;

        public Consumer(BlockingCycleQueue queue, String name) {
            this.queue = queue;
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int data = queue.pop();
                    System.out.println("消费者" + name + "消费:" + data);
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println(name + "消费终止");
                    break;
                }
            }
        }
    }

}
