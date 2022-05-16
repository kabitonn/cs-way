package com.vika.way.pre.algorithm.alg.company;

import java.util.*;

class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    @Override
    public int compareTo(Point o) {
        return this.y - o.y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class RightTopPoint {

    public List<Point> rightTopPoint(Point[] point) {
        Arrays.sort(point);
        int max = -1;
        List<Point> list = new ArrayList<>();
        for (int i = point.length - 1; i >= 0; i--) {
            if (point[i].getX() > max) {
                max = point[i].getX();
                list.add(point[i]);
            }
        }
        return list;
    }

    public List<int[]> rightTopPoint(int[][] point) {
        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int max = -1;
        List<int[]> list = new ArrayList<>();
        for (int i = point.length - 1; i >= 0; i--) {
            if (point[i][0] > max) {
                max = point[i][0];
                list.add(point[i]);
            }
        }
        return list;
    }
    public static void main0(String[] args) {
        RightTopPoint rightTopPoint = new RightTopPoint();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] point = new int[n][2];
        for (int i = 0; i < n; i++) {
            point[i][0] = scanner.nextInt();
            point[i][1] = scanner.nextInt();
        }
        List<int[]> list = rightTopPoint.rightTopPoint(point);

        for (int[] p : list) {
            System.out.println(p[0] + " " + p[1]);
        }
    }


    public static void main(String[] args) {
        RightTopPoint rightTopPoint = new RightTopPoint();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] point = new Point[n];
        int x, y;
        for (int i = 0; i < n; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            point[i] = new Point(x, y);
        }
        List<Point> list = rightTopPoint.rightTopPoint(point);

        for (Point p : list) {
            System.out.println(p);
        }

    }
}
