package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.ArrayList;
import java.util.List;

public class S046Permutations {

    public static void main(String[] args) {
        S046Permutations solution = new S046Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(solution.permute0(nums));
    }

    public List<List<Integer>> permute0(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        backtrack(nums, listList, new ArrayList<>());
        return listList;
    }

    private void backtrack(int[] nums, List<List<Integer>> listList, List<Integer> list) {
        if (list.size() == nums.length) {
            listList.add(new ArrayList<>(list));
        }
        for (int num : nums) {
            boolean isExsit = false;
            for (int n : list) {
                if (num == n) {
                    isExsit = true;
                    break;
                }
            }
            if (!isExsit) {
                list.add(num);
                backtrack(nums, listList, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack1(nums, visited, listList, new ArrayList<>());
        return listList;
    }

    private void backtrack1(int[] nums, boolean[] visited, List<List<Integer>> listList, List<Integer> list) {
        if (list.size() == nums.length) {
            listList.add(new ArrayList<>(list));

        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                backtrack1(nums, visited, listList, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        long visited = 0;
        backtrack2(nums, visited, listList, new ArrayList<>());
        return listList;
    }

    private void backtrack2(int[] nums, long visited, List<List<Integer>> listList, List<Integer> list) {
        if (list.size() == nums.length) {
            listList.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if ((1 << i & visited) == 0) {
                list.add(nums[i]);
                visited ^= 1 << i;
                backtrack2(nums, visited, listList, list);
                list.remove(list.size() - 1);
                visited ^= 1 << i;
            }
        }
    }

    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        permute(nums, 0, listList);
        return listList;
    }

    /**
     * 递归交换
     *
     * @param nums
     * @param start
     * @param listList
     */
    private void permute(int[] nums, int start, List<List<Integer>> listList) {
        if (start == nums.length) {
            //List list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            listList.add(list);
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permute(nums, start + 1, listList);
            swap(nums, i, start);
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public List<List<Integer>> permute4(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        listList.add(new ArrayList<>());
        //在上边的基础上只加上最外层的 for 循环就够了，代表每次新添加的数字
        for (int i = 0; i < nums.length; i++) {
            int currentSize = listList.size();
            for (int j = 0; j < currentSize; j++) {
                for (int k = 0; k <= i; k++) {
                    List<Integer> temp = new ArrayList<>(listList.get(j));
                    temp.add(k, nums[i]);
                    listList.add(temp);
                }
            }
            for (int j = 0; j < currentSize; j++) {
                listList.remove(0);
            }
        }
        return listList;
    }

    public List<List<Integer>> permute5(int[] nums) {
        return permute5(nums, nums.length);
    }

    public List<List<Integer>> permute5(int[] nums, int len) {
        if (len == 1) {
            List<List<Integer>> listList = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            listList.add(list);
            return listList;
        }
        List<List<Integer>> preListList = permute5(nums, len - 1);
        List<List<Integer>> listList = new ArrayList<>();
        for (List<Integer> list : preListList) {
            for (int i = 0; i < len; i++) {
                List<Integer> tempList = new ArrayList<>(list);
                tempList.add(i, nums[len - 1]);
                listList.add(tempList);
            }
        }
        return listList;
    }
}
