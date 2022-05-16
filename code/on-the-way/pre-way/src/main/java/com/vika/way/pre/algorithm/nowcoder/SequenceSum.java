package com.vika.way.pre.algorithm.nowcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequenceSum {

    public List<Integer> getSequence(int n, int l) {
        List<Integer> list = new ArrayList<>();
        int left = 1, right = 2;
        int sum = left + right;
        while (left < n / 2) {
            if (sum < n) {
                right++;
                sum += right;
            } else if (sum > n) {
                sum -= left;
                left++;
            } else if (right - left + 1 >= l) {
                if (right - left + 1 <= 100) {
                    list.clear();
                    for (int i = left; i <= right; i++) {
                        list.add(i);
                    }
                }
                sum -= left;
                left++;
                right++;
                sum += right;
            }
        }
        return list;
    }

    @Test
    public void test() {
        List<Integer> list = getSequence1(18, 2);
        System.out.println(list);
    }

    public List<Integer> getSequence1(int N, int L) {
        List<Integer> list = new ArrayList<>();
        for (int l = L; l <= 100; l++) {
            if ((N * 2 - l * l + l) % (2 * l) == 0) {
                int start = (N * 2 - l * l + l) / 2 / l;
                for (int i = 0; i < l; i++) {
                    list.add(start + i);
                }
                return list;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextByte();
        SequenceSum sequenceSum = new SequenceSum();
        List<Integer> list = sequenceSum.getSequence(N, L);
        if (list.size() == 0) {
            System.out.println("No");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
