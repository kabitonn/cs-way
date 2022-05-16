package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] adjacentList = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacentList[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adjacentList[pre[1]].add(pre[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int leftCourse = numCourses;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            leftCourse--;
            for (int course : adjacentList[pre]) {
                if (--indegree[course] == 0) {
                    queue.add(course);
                }
            }
        }
        return leftCourse == 0;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacentList = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacentList[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            adjacentList[pre[1]].add(pre[0]);
        }
        int[] marked = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCircle(i, adjacentList, marked)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCircle(int node, List<Integer>[] adjacentList, int[] marked) {
        if (marked[node] == 1) {
            return true;
        }
        if (marked[node] == -1) {
            return false;
        }
        marked[node] = 1;
        for (int adj : adjacentList[node]) {
            if (hasCircle(adj, adjacentList, marked)) {
                return true;
            }
        }
        marked[node] = -1;
        return false;
    }
}
