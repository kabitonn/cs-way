package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 380. 常数时间插入、删除和获取随机元素
 *
 * @author tokabi
 * @date 2019/11/1 12:04
 */
public class RandomizedSet {

    Set<Integer> set;
    List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean flag = set.add(val);
        if (flag) {
            list.add(val);
        }
        return flag;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        boolean flag = set.remove(val);
        if (flag) {
            list.remove((Integer)val);
        }
        return flag;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int random = (int) (Math.random() * list.size());
        return list.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */