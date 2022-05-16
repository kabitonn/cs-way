package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S229MajorityElementII {

    public static void main(String[] args) {
        S229MajorityElementII solution = new S229MajorityElementII();
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(solution.majorityElement1(nums));
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int times = nums.length / 3;
        for (int n : map.keySet()) {
            if (map.get(n) > times) {
                list.add(n);
            }
        }
        return list;
    }

    public List<Integer> majorityElement1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Integer candidateA = null, candidateB = null;
        int countA = 0, countB = 0;
        for (int n : nums) {
            if (candidateA != null && n == candidateA) {
                countA++;
            } else if (candidateB != null && n == candidateB) {
                countB++;
            } else if (countA == 0) {
                candidateA = n;
                countA++;
            } else if (countB == 0) {
                candidateB = n;
                countB++;
            } else {
                countA--;
                countB--;
            }
        }
        countA = countB = 0;
        for (int n : nums) {
            if (n == candidateA) {
                countA++;
            } else if (n == candidateB) {
                countB++;
            }
        }
        if (countA > nums.length / 3) {
            list.add(candidateA);
        }
        if (countB > nums.length / 3) {
            list.add(candidateB);
        }
        return list;
    }

    public List<Integer> majorityElement1_1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        //初始化：定义两个候选人及其对应的票数
        int candidateA = nums[0], candidateB = nums[0];
        int countA = 0, countB = 0;
        //遍历数组
        for (int num : nums) {
            if (num == candidateA) {
                countA++;//投A
                continue;
            }
            if (num == candidateB) {
                countB++;//投B
                continue;
            }
            //此时当前值和AB都不等，检查是否有票数减为0的情况，如果为0，则更新候选人
            if (countA == 0) {
                candidateA = num;
                countA++;
                continue;
            }
            if (countB == 0) {
                candidateB = num;
                countB++;
                continue;
            }
            //若此时两个候选人的票数都不为0，且当前元素不投AB，那么A,B对应的票数都要--;
            countA--;
            countB--;
        }
        //上一轮遍历找出了两个候选人，但是这两个候选人是否均满足票数大于N/3仍然没法确定，需要重新遍历，确定票数
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == candidateA) {
                countA++;
            } else if (num == candidateB) {
                countB++;
            }
        }
        if (countA > nums.length / 3) {

            list.add(candidateA);
        }
        if (countB > nums.length / 3) {
            list.add(candidateB);
        }
        return list;
    }

}
