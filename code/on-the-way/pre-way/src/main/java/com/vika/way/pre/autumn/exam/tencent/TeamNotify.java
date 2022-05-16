package com.vika.way.pre.autumn.exam.tencent;

import org.junit.Test;

import java.util.*;

/**
 * @Author tangjiawei
 * @Date 2020/9/6
 */
public class TeamNotify {

    public Set<Integer> notify(Set<Integer>[] teams, Map<Integer, List<Integer>> map, int start) {
        Set<Integer> notified = new HashSet<>();
        if (!map.containsKey(start)) {
            return notified;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> tList = map.get(start);
        for (int t : tList) {
            for (int p : teams[t]) {
                if (notified.contains(p)) {
                    continue;
                }
                queue.offer(p);
                notified.add(p);
            }
        }
        while (!queue.isEmpty()) {
            int p = queue.poll();
            List<Integer> teamList = map.get(p);
            System.out.println(p);
            for (int t : teamList) {
                for (int n : teams[t]) {
                    if (notified.contains(n)) {
                        continue;
                    }
                    queue.offer(n);
                    notified.add(n);
                }
            }
        }
        return notified;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer>[] teams = new Set[m];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            teams[i] = new HashSet<>();
            int x = sc.nextInt();
            for (int j = 0; j < x; j++) {
                int p = sc.nextInt();
                teams[i].add(p);
                if (!map.containsKey(p)) {
                    map.put(p, new ArrayList<>());
                }
                map.get(p).add(i);
            }
        }
        TeamNotify main = new TeamNotify();
        int result = main.notify(teams, map, 0).size();
        System.out.println(result);
    }

    /*
     50 5
     2 1 2
     5 10 11 12 13 14
     2 0 1
     2 49 2
     4 6 7 8 2
     */
    @Test
    public void test() {
        Set<Integer>[] teams = new Set[5];
        for (int i = 0; i < 5; i++) {
            teams[i] = new HashSet<>();
        }
        teams[0].add(1);
        teams[0].add(2);

    }
}
