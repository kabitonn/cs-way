package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ContinuousSequenceSum {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();
        ArrayList<Integer> list;
        for (int i = 1; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                int j = sum / i;
                if (i != 1 && i % 2 == 1) {
                    list = new ArrayList<>();
                    for (int k = j - i / 2; k <= j + i / 2; k++) {
                        list.add(k);
                    }
                    listArrayList.add(new ArrayList<>(list));
                    if (i != j && j % 2 == 1 && i - j / 2 > 0) {
                        list = new ArrayList<>();
                        for (int k = i - j / 2; k <= i + j / 2; k++) {
                            list.add(k);
                        }
                        listArrayList.add(new ArrayList<>(list));
                    }
                } else if (j != 1 && j % 2 == 1) {
                    list = new ArrayList<>();
                    int r = (j + 1) / 2;
                    for (int k = r - i; k <= r + i - 1; k++) {
                        list.add(k);
                    }
                    listArrayList.add(new ArrayList<>(list));
                }
            }
        }
        Collections.sort(listArrayList, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return listArrayList;
    }


    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        int left = 1, right = 2;
        ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();
        int curSum = left + right;
        while (left <= sum / 2) {
            if (curSum < sum) {
                right++;
                curSum += right;
            } else if (curSum > sum) {
                curSum -= left;
                left++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                listArrayList.add(list);
                curSum -= left;
                left++;
                right++;
                curSum += right;
            }
        }
        return listArrayList;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();
        for (int n = (int) Math.sqrt(sum * 2); n >= 2; n--) {
            if ((sum % n == 0 && n % 2 == 1) || (sum % n) * 2 == n) {
                ArrayList list = new ArrayList();
                int mid = sum / n;
                for (int i = 0, k = mid - (n - 1) / 2; i < n; i++, k++) {
                    list.add(k);
                }
                listArrayList.add(list);
            }
        }
        return listArrayList;
    }
}
