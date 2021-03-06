//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 
//
// 示例 1: 
//
// 给定 nums = [1,1,1,2,2,3],
//
//函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,1,2,3,3],
//
//函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//} 
// Related Topics 数组 双指针 
// 👍 275 👎 0


//Java：删除排序数组中的重复项 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P80RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new P80RemoveDuplicatesFromSortedArrayIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates1(int[] nums) {
            boolean duplicate = false;
            int index = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    duplicate = false;
                    nums[index++] = nums[i];
                } else if (!duplicate) {
                    nums[index++] = nums[i];
                    duplicate = true;
                }
            }
            return index;
        }

        public int removeDuplicates(int[] nums) {
            int slow = 0, fast = 1;
            int count = 1;
            for (; fast < nums.length; fast++) {
                if (nums[fast] != nums[slow]) {
                    nums[++slow] = nums[fast];
                    count = 1;
                } else if (count++ < 2) {
                    nums[++slow] = nums[fast];
                }
            }
            return slow + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}