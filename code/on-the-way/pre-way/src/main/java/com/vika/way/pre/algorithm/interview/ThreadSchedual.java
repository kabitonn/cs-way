package com.vika.way.pre.algorithm.interview;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSchedual {

    private int total;
    private CyclicBarrier barrier;

    public ThreadSchedual(int total) {
        this.total = total;
        this.barrier = new CyclicBarrier(total);
    }


    public void schedual() {
        FirstProcess[] firstProcesses = new FirstProcess[total - 1];
        for (int i = 0; i < total - 1; i++) {
            char c = (char) ('b' + i);
            firstProcesses[i] = new FirstProcess(String.valueOf(c), barrier);
        }
        LastProcess lastProcess = new LastProcess("a", barrier);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(lastProcess);
        for (int i = 0; i < total - 1; i++) {
            executorService.submit(firstProcesses[i]);
        }
    }

    public static void main(String[] args) {
        int total = 5;
        ThreadSchedual threadSchedual = new ThreadSchedual(total);
        threadSchedual.schedual();
    }

    class FirstProcess implements Runnable {
        String name;
        CyclicBarrier barrier;

        public FirstProcess(String name, CyclicBarrier barrier) {
            this.name = name;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            /*
            优先线程执行部分
             */
            System.out.println(name);
            try {
                barrier.await();
                //线程执行完毕释放屏障
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {

            }
        }
    }

    class LastProcess implements Runnable {
        String name;
        CyclicBarrier barrier;

        public LastProcess(String name, CyclicBarrier barrier) {
            this.name = name;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                barrier.await();
                //等待FistProcess先执行完毕
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {
            }
            System.out.println(name);
        }
    }

}
