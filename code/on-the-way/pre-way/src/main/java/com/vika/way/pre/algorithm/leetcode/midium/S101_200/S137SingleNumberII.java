package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S137SingleNumberII {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            } else {
                return nums[i];
            }
        }
        return 0;
    }

    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            Integer count = map.get(n);
            count = count == null ? 1 : count + 1;
            map.put(n, count);
        }
        for (Integer n : map.keySet()) {
            if (map.get(n) == 1) {
                return n;
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        int single = 0;
        //考虑每一位
        for (int i = 0; i < 32; i++) {
            int count = 0;
            //考虑每一个数
            for (int j = 0; j < nums.length; j++) {
                //当前位是否是 1
                if ((nums[j] >>> i & 1) == 1) {
                    count++;
                }
            }
            //1 的个数是否是 3 的倍数
            if (count % 3 != 0) {
                single = single | 1 << i;
            }
        }
        return single;
    }

    public int singleNumber3(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int num : nums) {
            twos |= ones & num;//用Int32位任意一位出现了一次1的结果ones 和当期num与 则同一个位置出现两次的会是1合并到twos 出现一次的保持twos原先的位
            ones ^= num;//一直异或num 则Int中的某一位出现一次1 ones为1 两次则异或成0 三次还是1 但是会被后续操作清零
            threes = ones & twos;//ones和twos同时为1时 threes为1
            ones &= ~threes;//threes对应的位置为1 取反为0 和ones与则将对应位清零
            twos &= ~threes;
        }
        return ones;
    }

    public int singleNumber4(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public int singleNumber5(int[] nums) {
        int x1 = 0, x2 = 0, mask = 0;
        for (int i : nums) {
            x2 ^= x1 & i;
            x1 ^= i;
            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1,2,2,6};
        S137SingleNumberII solution= new S137SingleNumberII();
        System.out.println(solution.singleNumber5(nums));
    }
}
