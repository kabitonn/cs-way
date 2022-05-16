package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S496NextGreaterElement {

    public static void main(String[] args) {
        S496NextGreaterElement solution=new S496NextGreaterElement();
        int[] nums1={3,1,5,7,9,2,6};
        int[] nums2={1,2,3,5,6,7,9,11};
        System.out.println(Arrays.toString(solution.nextGreaterElement3(nums1,nums2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] next = new int[n1];
        for (int i = 0; i < n1; i++) {
            next[i] = -1;
            boolean found = false;
            for (int j = 0; j < n2; j++) {
                if (!found && nums1[i] == nums2[j]) {
                    found = true;
                } else if (found && nums1[i] < nums2[j]) {
                    next[i] = nums2[j];
                    break;
                }
            }
        }
        return next;
    }

    public int[] nextGreaterElement_1(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] next = new int[n1];
        int[] map = new int[n1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j]) {
                    map[i] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < n1; i++) {
            next[i] = -1;
            for (int j = map[i] + 1; j < n2; j++) {
                if (nums1[i] < nums2[j]) {
                    next[i] = nums2[j];
                    break;
                }
            }
        }
        return next;
    }

    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] next = new int[n1];
        int max = 0;
        for (int num : nums2) {
            max = Math.max(num, max);
        }
        int[] map = new int[max + 1];
        for (int i = 0; i < n2; i++) {
            map[nums2[i]] = i;
        }
        for (int i = 0; i < n1; i++) {
            next[i] = -1;
            for (int j = map[nums1[i]] + 1; j < n2; j++) {
                if (nums1[i] < nums2[j]) {
                    next[i] = nums2[j];
                    break;
                }
            }
        }
        return next;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] next = new int[n1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            for (int j = i + 1; j < n2; j++) {
                if (nums2[i] < nums2[j]) {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }
        for (int i = 0; i < n1; i++) {
            next[i] = map.getOrDefault(nums1[i], -1);
        }
        return next;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] next = new int[n1];
        int[] stack = new int[n2];
        Map<Integer, Integer> map = new HashMap<>();
        int top = 0;
        for (int num : nums2) {
            while (top > 0 && stack[top - 1] < num) {
                map.put(stack[--top], num);
            }
            stack[top++] = num;
        }
        while (top > 0) {
            map.put(stack[--top], -1);
        }
        for (int i = 0; i < n1; i++) {
            next[i] = map.get(nums1[i]);
        }
        return next;
    }


}
