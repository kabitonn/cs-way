package com.vika.way.pre.application.api;

public class FlowLimit {

    private Integer count;
    private long updateTime;

    public FlowLimit() {
        count = 0;
        updateTime = 0;
    }

    public int getCount() {
        return count;
    }

    public boolean filter() {
        synchronized (count) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - updateTime > 1 * 1000) {
                updateTime = currentTime;
                count = 0;
            }
            if (count < 100) {
                count++;
            } else {
                return false;
            }
        }
        return true;
    }

    /*public static void main(String[] args) {
        FlowLimit flowLimit = new FlowLimit();
        for (int i = 0; i < 200; i++) {
            if (!flowLimit.filter()) {
                System.out.println("false");
            }
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println(flowLimit.filter());
    }*/

    public static void main(String[] args) throws Exception {
        FlowLimit flowLimit = new FlowLimit();
        Visitor v1 = new Visitor("v1", flowLimit);
        Visitor v2 = new Visitor("v2", flowLimit);
        new Thread(v1).start();
        Thread.sleep(200);
        new Thread(v2).start();
        Thread.yield();
    }
}
