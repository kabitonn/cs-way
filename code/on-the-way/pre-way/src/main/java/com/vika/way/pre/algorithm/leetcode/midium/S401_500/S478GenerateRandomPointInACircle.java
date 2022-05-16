package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.Arrays;
import java.util.Random;

public class S478GenerateRandomPointInACircle {

    private double radius;
    private double xCenter;
    private double yCenter;

    public S478GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
    }

    public double[] randPoint() {
        Random random = new Random();
        double xRand, yRand;
        double distance;
        do {
            xRand = xCenter - radius + random.nextDouble() * radius * 2;
            yRand = yCenter - radius + random.nextDouble() * radius * 2;
            distance = Math.pow(xRand - xCenter, 2) + Math.pow(yRand - yCenter, 2);

        } while (distance > radius * radius);
        return new double[]{xRand, yRand};
    }

    public double[] randPoint0() {
        Random random = new Random();
        double dx;
        double dy;
        do {
            dx = random.nextDouble() * 2 - 1;
            dy = random.nextDouble() * 2 - 1;
        } while (dx * dx + dy * dy > 1);
        double xRand = xCenter + radius * dx;
        double yRand = yCenter + radius * dy;
        return new double[]{xRand, yRand};
    }


    public double[] randPoint1() {
        Random random = new Random();
        double dx = random.nextDouble();
        double dy = random.nextDouble();
        while (dx * dx + dy * dy > 1) {
            dx = random.nextDouble();
            dy = random.nextDouble();
        }
        double xRand = xCenter + (random.nextBoolean() ? 1 : -1) * radius * dx;
        double yRand = yCenter + (random.nextBoolean() ? 1 : -1) * radius * dy;
        return new double[]{xRand, yRand};
    }

    public double[] randPoint2() {
        Random random = new Random();
        double theta = random.nextDouble() * Math.PI * 2;
        double r = Math.sqrt(Math.pow(radius, 2) * random.nextDouble());
        double xRand = xCenter + Math.cos(theta) * r;
        double yRand = yCenter + Math.sin(theta) * r;
        return new double[]{xRand, yRand};
    }

    public static void main(String[] args) {
        S478GenerateRandomPointInACircle solution = new S478GenerateRandomPointInACircle(1, 0, 0);
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(solution.randPoint2()));
        }
    }
}
