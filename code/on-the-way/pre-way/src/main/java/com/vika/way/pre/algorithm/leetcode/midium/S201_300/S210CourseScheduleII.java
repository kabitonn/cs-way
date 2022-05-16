package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.*;

public class S210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] topo = new int[numCourses];
        int seq = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            topo[seq++] = pre;
            for (int course : adjacentList[pre]) {
                if (--indegree[course] == 0) {
                    queue.add(course);
                }
            }
        }
        return seq == numCourses ? topo : new int[0];
    }

    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacentList = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacentList[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            adjacentList[pre[1]].add(pre[0]);
        }
        int[] marked = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasCircle(i, adjacentList, marked, stack)) {
                return new int[0];
            }
        }
        int[] seq = new int[numCourses];
        //那个没有前驱的课程，一定在栈顶，所以课程学习的顺序就应该是从栈顶到栈底
        for (int i = 0; i < numCourses; i++) {
            seq[i] = stack.pop();
        }
        return seq;
    }

    /**
     * @param node         当前遍历节点
     * @param adjacentList 邻接表
     * @param marked       -1 其他节点已遍历过， 1 当前节点遍历过程中 0 还未遍历
     * @param stack        存储拓扑排序的逆序，有指向该节点的先入栈
     * @return boolean
     * @date 2019/10/10 21:21
     */
    public boolean hasCircle(int node, List<Integer>[] adjacentList, int[] marked, Stack<Integer> stack) {
        if (marked[node] == 1) {
            return true;
        }
        if (marked[node] == -1) {
            return false;
        }
        marked[node] = 1;
        for (int course : adjacentList[node]) {
            if (hasCircle(course, adjacentList, marked, stack)) {
                return true;
            }
        }
        //node的所有后继结点都访问完了，都没有存在环，则这个结点就可以被标记为已经访问结束
        stack.push(node);
        marked[node] = -1;
        return false;
    }
}
