package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.ArrayList;
import java.util.List;

public class StreamMidian {

    List<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        int i = list.size() - 1;
        for (; i >= 0; i--) {
            if (list.get(i) <= num) {
                break;
            }
        }
        list.add(i + 1, num);
    }

    public Double GetMedian() {
        int size = list.size();
        double left = list.get((size - 1) / 2);
        double right = list.get(size / 2);
        if ((size & 1) == 1) {
            return left;
        } else {
            return (left + right) / 2;
        }
    }


}
