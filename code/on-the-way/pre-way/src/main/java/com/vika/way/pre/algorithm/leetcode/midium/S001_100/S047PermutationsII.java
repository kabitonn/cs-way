package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.*;

public class S047PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> listSet = new HashSet<>();
        List<List<Integer>> listList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, listSet, new ArrayList<>());
        for (List l : listSet) {
            listList.add(l);
        }
        return listList;
    }

    private void backtrack(int[] nums, boolean[] visited, Set<List<Integer>> listSet, List<Integer> list) {
        if (list.size() == nums.length) {
            listSet.add(new ArrayList<>(list));
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                backtrack(nums, visited, listSet, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack1(nums, visited, listList, new ArrayList<>());
        return listList;
    }

    private void backtrack1(int[] nums, boolean[] visited, List<List<Integer>> listList, List<Integer> list) {
        if (list.size() == nums.length) {
            listList.add(new ArrayList<>(list));
        }
        for (int i = 0; i < visited.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                backtrack1(nums, visited, listList, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique3(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, 0, listList);
        return listList;
    }

    private void permute(int[] nums, int start, List<List<Integer>> listList) {
        if (start == nums.length) {
            //List list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            listList.add(list);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            /*int j = i - 1;
            while (j >= start && nums[j] != nums[i]) {
                --j;
            }
            if (j != start - 1) {
                continue;
            }*/
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
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

    public List<List<Integer>> permuteUnique4(int[] nums) {
        Set<List<Integer>> setList = new HashSet<>();
        setList.add(new ArrayList<>());
        //在上边的基础上只加上最外层的 for 循环就够了，代表每次新添加的数字
        for (int i = 0; i < nums.length; i++) {
            Set<List<Integer>> set = new HashSet<>();
            for (List list : setList) {
                for (int k = 0; k <= i; k++) {
                    if (k < i && nums[i] == (int) list.get(k)) {
                        continue;
                    }
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(k, nums[i]);
                    set.add(temp);
                }
            }
            setList = set;
        }
        return new ArrayList<>(setList);
    }

    public List<List<Integer>> permuteUnique5(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();

        listList.add(new ArrayList<>());
        //在上边的基础上只加上最外层的 for 循环就够了，代表每次新添加的数字
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tempList = new ArrayList<>();
            for (List list : listList) {
                for (int k = 0; k <= i; k++) {
                    if (k < i && nums[i] == (int) list.get(k)) {
                        continue;
                    }
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(k, nums[i]);
                    tempList.add(temp);
                }
            }
            listList = tempList;
        }
        return removeDuplicate(listList);
    }

    private List<List<Integer>> removeDuplicate(List<List<Integer>> listList) {
        Map<String, String> ans = new HashMap<String, String>();
        for (int i = 0; i < listList.size(); i++) {
            List<Integer> list = listList.get(i);
            String key = "";
            // [ 2 3 4 ] 转为 "2,3,4"
            for (int j = 0; j < list.size() - 1; j++) {
                key = key + list.get(j) + ",";
            }
            key = key + list.get(list.size() - 1);
            ans.put(key, "");
        }
        // 根据逗号还原 List
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        for (String key : ans.keySet()) {
            String[] l = key.split(",");
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < l.length; i++) {
                int c = Integer.parseInt(l[i]);
                temp.add(c);
            }
            ansList.add(temp);
        }
        return ansList;
    }
}