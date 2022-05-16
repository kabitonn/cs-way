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
public class BlockingCycleQueue1 {

    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private final int capacity = 10;
    private int[] queue = new int[capacity];
    private int head = 0;
    private int tail = 0;
    private int count = 0;
    private int value = 0;

    public int pop() throws InterruptedException {
        int popData = 0;
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            popData = queue[head];
            head = (head + 1) % capacity;
            count--;
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
        return popData;
    }

    public int push(int data) throws InterruptedException {
        int pushData = 0;
        lock.lock();
        try {
            while (count == capacity) {
                notFull.await();
            }
            queue[tail] = value;
            pushData = value;
            tail = (tail + 1) % capacity;
            count++;
            value++;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
        return pushData;
    }

    @Test
    public void testOneToOne() throws InterruptedException {
        BlockingCycleQueue1 queue = new BlockingCycleQueue1();
        Provider provider = new Provider(queue, "p1");
        Consumer consumer = new Consumer(queue, "c1");
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> providerFuture = executorService.submit(provider);
        Future<?> consumer1Future = executorService.submit(consumer);
        Thread.sleep(1000L);
        providerFuture.cancel(true);
        consumer1Future.cancel(true);
    }

    @Test
    public void testOneToMany() throws InterruptedException {
        BlockingCycleQueue1 queue = new BlockingCycleQueue1();
        Provider provider = new Provider(queue, "p1");
        int countConsumer = 5;
        Consumer[] consumers = new Consumer[countConsumer];
        for (int i = 0; i < countConsumer; i++) {
            consumers[i] = new Consumer(queue, "c" + i);
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> providerFuture = executorService.submit(provider);
        Future<?>[] consumerFutures = new Future[countConsumer];
        for (int i = 0; i < countConsumer; i++) {
            consumerFutures[i] = executorService.submit(consumers[i]);
        }
        Thread.sleep(1000L);
        providerFuture.cancel(true);
        for (int i = 0; i < countConsumer; i++) {
            consumerFutures[i].cancel(true);
        }
    }

    @Test
    public void testManyToMany() throws InterruptedException {
        BlockingCycleQueue1 queue = new BlockingCycleQueue1();
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
        Future<?>[] providerFutures = new Future[countProvider];
        for (int i = 0; i < countProvider; i++) {
            providerFutures[i] = executorService.submit(providers[i]);
        }
        Future<?>[] consumerFutures = new Future[countConsumer];
        for (int i = 0; i < countConsumer; i++) {
            consumerFutures[i] = executorService.submit(consumers[i]);
        }
        Thread.sleep(100L);
        for (int i = 0; i < countProvider; i++) {
            providerFutures[i].cancel(true);
        }
        for (int i = 0; i < countConsumer; i++) {
            consumerFutures[i].cancel(true);
        }
    }

    class Provider implements Runnable {
        private BlockingCycleQueue1 queue;
        private String name;

        private AtomicInteger a = new AtomicInteger();

        public Provider(BlockingCycleQueue1 queue, String name) {
            this.queue = queue;
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int data = queue.push(0);
                    System.out.println("生产者" + name + "生产:" + data);
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println(name + "生产终止");
                    break;
                }
            }
        }
    }

    class Consumer implements Runnable {

        private BlockingCycleQueue1 queue;
        private String name;

        public Consumer(BlockingCycleQueue1 queue, String name) {
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



