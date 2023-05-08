package com.vika.way.pre.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * @author chenwei.tjw
 * @date 2023/5/8
 **/
public class LongAdderFeature {
    private static final int NUM_INC = 1_000_000;

    private static LongAdder longAdder = new LongAdder();

    private static void update() {
        ExecutorService executorService = new ThreadPoolExecutor(5, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        IntStream.range(0, NUM_INC).forEach(i -> {
            Runnable task = () -> longAdder.add(2);
            executorService.submit(task);
        });
        stop(executorService);
        System.out.println(longAdder.sum());
    }

    private static void stop(ExecutorService executorService) {
        try {
            executorService.shutdown();
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!executorService.isTerminated()) {
                System.out.println("kill tasks");
            }
            executorService.shutdownNow();
        }
    }

    public static void main(String[] args) {
        update();
    }

}
