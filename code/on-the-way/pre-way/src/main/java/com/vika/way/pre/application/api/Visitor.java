package com.vika.way.pre.application.api;

public class Visitor implements Runnable {

    String name;
    FlowLimit flowLimit;

    public Visitor(String name, FlowLimit flowLimit) {
        this.name = name;
        this.flowLimit = flowLimit;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(i + " " + name + " " + flowLimit.getCount() + flowLimit.filter());
                Thread.sleep(1);
            }

            Thread.sleep(800);

            for (int i = 0; i < 100; i++) {
                System.out.println(i + " " + name + " " + flowLimit.getCount() + flowLimit.filter());
                Thread.sleep(1);

            }
        } catch (Exception e) {
        }
    }

}
