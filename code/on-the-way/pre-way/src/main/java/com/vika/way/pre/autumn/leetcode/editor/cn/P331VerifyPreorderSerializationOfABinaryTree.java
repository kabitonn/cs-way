//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。 
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
//
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈 
// 👍 107 👎 0


//Java：验证二叉树的前序序列化

package com.vika.way.pre.autumn.leetcode.editor.cn;


import java.util.Stack;

public class P331VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new P331VerifyPreorderSerializationOfABinaryTree().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[^,#]+,#,#");

        public boolean isValidSerialization1(String preorder) {
            java.util.regex.Matcher matcher = pattern.matcher(preorder);
            while (!"#".equals(preorder) && matcher.find()) {
                preorder = matcher.replaceAll("#");
                matcher = pattern.matcher(preorder);
            }
            return "#".equals(preorder);
        }

        public boolean isValidSerialization2(String preorder) {
            String[] strings = preorder.split(",");
            Stack<String> stack = new Stack<>();
            for (String s : strings) {
                while ("#".equals(s) && !stack.isEmpty() && "#".equals(stack.peek())) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
                stack.push(s);
            }
            return stack.size() == 1 && "#".equals(stack.pop());
        }

        public boolean isValidSerialization3(String preorder) {
            String[] strings = preorder.split(",");
            Stack<Integer> stack = new Stack<>();
            int n = strings.length;
            int[] visited = new int[n];
            int index = 0;
            stack.push(index++);
            while (index <= n) {
                int node = stack.peek();
                if ("#".equals(strings[node]) || visited[node] == 2) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    visited[stack.peek()]++;
                } else {
                    stack.push(index++);
                }
            }
            return index == n;
        }

        public boolean isValidSerialization(String preorder) {
            String[] strs = preorder.split(",");
            int n = strs.length;
            int leaves = 0;
            int nodes = 0;
            int i = 0;
            for (String s : strs) {
                if ("#".equals(s)) {
                    leaves++;
                } else {
                    nodes++;
                }
                i++;
                if (leaves == nodes + 1) {
                    break;
                }
            }
            if (i == n && leaves == nodes + 1) {
                return true;
            } else {
                return false;
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}