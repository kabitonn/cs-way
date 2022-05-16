package com.vika.way.pre.jvm.concurrent;

public class NonVisible {
    private static volatile boolean ready = false;
    private static int count = 0;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while(!ready) {
                System.out.println(ready+" son ");
            }
            System.out.println("son finish");
        }
    }

    public static void main(String[] args) throws Exception{
        new ReaderThread().start();
        Thread.sleep(1);
        Thread.yield();
        System.out.println("main time");
        System.out.println("main recovery");
        ready = true;
        System.out.println("main readey");
        System.out.println("main finish");


    }
}
