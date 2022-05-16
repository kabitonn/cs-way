package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.HashSet;
import java.util.Set;

/**
 * 380. 常数时间插入、删除和获取随机元素
 *
 * @author tokabi
 * @date 2019/11/1 12:04
 */
public class RandomizedSet_1 {

    Set<Integer> set;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet_1() {
        set = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Integer[] array = set.toArray(new Integer[0]);
        int random = (int) (Math.random() * set.size());
        return array[random];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */