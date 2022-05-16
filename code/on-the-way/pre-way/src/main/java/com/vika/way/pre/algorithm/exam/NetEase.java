package com.vika.way.pre.algorithm.exam;

import org.junit.Test;

import java.util.Queue;
import java.util.*;

public class NetEase {


    public long getMaxDiff(long[] num) {
        int n = num.length;
        long d = num[1] - num[0];
        if (d <= 0) {
            return -1;
        }
        long diff;
        for (int i = 2; i < n; i++) {
            diff = num[i] - num[i - 1];
            if (diff <= 0) {
                return -1;
            }
            d = gcd(d, diff);
        }
        return d;
    }

    public long gcd(long a, long b) {
        long r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public int getMinDamage(int n, int d, int[] attack, int[] damage) {
        Monster[] monsters = new Monster[n];
        for (int i = 0; i < n; i++) {
            monsters[i] = new Monster(attack[i], damage[i]);
        }
        Arrays.sort(monsters, new Comparator<Monster>() {
            @Override
            public int compare(Monster o1, Monster o2) {
                return o1.attack - o2.attack;
            }
        });
        int damageFlood = 0;
        int i = 0;
        for (; i < n; i++) {
            if (d > monsters[i].attack) {
                d++;
            } else {
                break;
            }
        }
        for (int j = n - 1; j >= i; j--) {
            if (d <= monsters[i].attack) {
                damageFlood += monsters[j].damage;
            }
            d++;
        }
        return damageFlood;
    }


    public int getMinDamage1(int n, int d, int[] attack, int[] damage) {
        Monster[] monsters = new Monster[n];
        for (int i = 0; i < n; i++) {
            monsters[i] = new Monster(attack[i], damage[i]);
        }
        Arrays.sort(monsters, new Comparator<Monster>() {
            @Override
            public int compare(Monster o1, Monster o2) {
                return o1.attack - o2.attack;
            }
        });
        int i = 0;
        for (; i < n; i++) {
            if (d > monsters[i].attack) {
                d++;
            } else {
                break;
            }
        }
        if (i == n) {
            return 0;
        }
        int[] arr = new int[n - i];
        for (int j = i, k = 0; j < n; j++) {
            arr[k++] = j;
        }
        List<List<Integer>> listList = new ArrayList<>();
        permute(arr, listList, 0);
        int minDamage = Integer.MAX_VALUE;
        for (List<Integer> list : listList) {
            int tmpD = d;
            int tmpDamage = 0;
            for (int j : list) {
                if (tmpD <= monsters[i].attack) {
                    tmpDamage += monsters[j].damage;
                }
            }
            minDamage = Math.min(minDamage, tmpDamage);
        }

        return minDamage;
    }

    public void permute(int[] arr, List<List<Integer>> listList, int start) {
        if (start == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : arr) {
                list.add(n);
            }
            listList.add(list);
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permute(arr, listList, start + 1);
            swap(arr, start, i);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    class Monster {
        int attack;
        int damage;

        Monster(int attack, int damage) {
            this.attack = attack;
            this.damage = damage;
        }
    }

    public int getAffectNumber(List<List<Integer>> listList, int start, int n) {
        boolean[] affected = new boolean[n];
        affected[start] = true;
        for (List<Integer> list : listList) {
            boolean flag = false;
            for (int i : list) {
                if (affected[i]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int i : list) {
                    affected[i] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += affected[i] ? 1 : 0;
        }
        return count;
    }

    public int[][] getDistance(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    d[i][j] = 0;
                } else {
                    d[i][j] = getMinDistance(matrix, i, j);
                }
            }
        }
        return d;
    }

    public int getMinDistance(char[][] matrix, int i, int j) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int d = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];
                if (matrix[x][y] == '0') {
                    return d;
                }
                if (x > 0 && !visited[x - 1][y]) {
                    queue.add(new int[]{x - 1, y});
                    visited[x - 1][y] = true;
                }
                if (x < n - 1 && !visited[x + 1][y]) {
                    queue.add(new int[]{x + 1, y});
                    visited[x + 1][y] = true;
                }
                if (y > 0 && !visited[x][y - 1]) {
                    queue.add(new int[]{x, y - 1});
                    visited[x][y - 1] = true;
                }
                if (y < m - 1 && !visited[x][y + 1]) {
                    queue.add(new int[]{x, y + 1});
                    visited[x][y + 1] = true;
                }
            }
            d++;
        }
        return d;
    }

    public int getMinDistance1(char[][] matrix, int i, int j) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        queueX.add(i);
        queueY.add(j);
        visited[i][j] = true;
        int d = 0;
        while (!queueX.isEmpty()) {
            int size = queueX.size();
            for (int k = 0; k < size; k++) {
                int x = queueX.poll();
                int y = queueY.poll();
                if (matrix[x][y] == '0') {
                    return d;
                }
                if (x > 0 && !visited[x - 1][y]) {
                    queueX.add(x - 1);
                    queueY.add(y);
                    visited[x - 1][y] = true;
                }
                if (x < n - 1 && !visited[x + 1][y]) {
                    queueX.add(x + 1);
                    queueY.add(y);
                    visited[x + 1][y] = true;
                }
                if (y > 0 && !visited[x][y - 1]) {
                    queueX.add(x);
                    queueY.add(y - 1);
                    visited[x][y - 1] = true;
                }
                if (y < m - 1 && !visited[x][y + 1]) {
                    queueX.add(x);
                    queueY.add(y + 1);
                    visited[x][y + 1] = true;
                }
            }
            d++;
        }
        return d;
    }

    @Test
    public void test() {
        char[][] matrix = {{'1', '0', '1'},
            {'0', '1', '0'}, {'1', '0', '1'}};
        int[][] dis = getDistance(matrix);
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                System.out.print(dis[i][j] + " ");
            }
            System.out.println(dis[i][m - 1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
        NetEase main = new NetEase();
        int[][] dis = main.getDistance(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                System.out.print(dis[i][j] + " ");
            }
            System.out.println(dis[i][m - 1]);
        }
    }
}
