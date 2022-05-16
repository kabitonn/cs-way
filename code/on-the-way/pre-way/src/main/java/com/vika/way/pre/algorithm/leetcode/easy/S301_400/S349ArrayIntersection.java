package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class S349ArrayIntersection {

	public static void main(String[] args) {

	}
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length) {
        	//while(i+1<nums1.length && nums1[i+1]==nums1[i]) i++;
            //while(j+1<nums2.length && nums2[j+1]==nums2[j]) j++;
        	if(nums1[i]<nums2[j]) {
        		i++;
        	}
        	else if (nums1[i]>nums2[j]) {
        		j++;
			}
        	else if (nums1[i]==nums2[j]) {
        		set.add(nums1[i]);
        		i++;
        		j++;
			}
        }
        int[] res = new int[set.size()];
        i = 0;
        for(Integer n:set) {
        	res[i++] = n;
        }
        return res;
    }
	public int[] intersection1(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (Integer n : nums1) {
            set1.add(n);
        }
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (Integer n : nums2) {
            set2.add(n);
        }

		int size = set1.size()>set2.size()?set2.size():set1.size();
		int[] res = new int[size];
		int i = 0;
		for(Integer n:set1) {
			if(set2.contains(n)){res[i++] = n;}
		}
		return Arrays.copyOf(res, i);
	}
	public int[] intersection2(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (Integer n : nums1) {
            set1.add(n);
        }
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (Integer n : nums2) {
            set2.add(n);
        }

		set1.retainAll(set2);
		int[] res = new int[set1.size()];
		int i = 0;
		for(Integer n:set1) {
			res[i++] = n;
		}
		return res;
	}
}
