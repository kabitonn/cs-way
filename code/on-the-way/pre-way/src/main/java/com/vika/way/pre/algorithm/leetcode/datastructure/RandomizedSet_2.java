package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 380. 常数时间插入、删除和获取随机元素
 *
 * @author tokabi
 * @date 2019/11/1 12:04
 */
public class RandomizedSet_2 {

    Map<Integer, Integer> valueMap;
    Map<Integer, Integer> indexMap;
    int size;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet_2() {
        indexMap = new HashMap<>();
        valueMap = new HashMap<>();
        size = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        indexMap.put(val, ++size);
        valueMap.put(size, val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int index = indexMap.remove(val);
        if (index != size) {
            valueMap.remove(index);
            int lastValue = valueMap.get(size);
            valueMap.put(index, lastValue);
            indexMap.put(lastValue, index);
        }
        valueMap.remove(size--);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int randomIndex = new Random().nextInt(size) + 1;
        return valueMap.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */