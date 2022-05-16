//给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤： 
//
// 
// 如果所读的字符是字母，则将该字母写在磁带上。 
// 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。 
// 
//
// 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。 
//
// 
//
// 示例 1： 
//
// 输入：S = "leet2code3", K = 10
//输出："o"
//解释：
//解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
//字符串中的第 10 个字母是 "o"。
// 
//
// 示例 2： 
//
// 输入：S = "ha22", K = 5
//输出："h"
//解释：
//解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
// 
//
// 示例 3： 
//
// 输入：S = "a2345678999999999999999", K = 1
//输出："a"
//解释：
//解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= S.length <= 100 
// S 只包含小写字母与数字 2 到 9 。 
// S 以字母开头。 
// 1 <= K <= 10^9 
// 题目保证 K 小于或等于解码字符串的长度。 
// 解码后的字符串保证少于 2^63 个字母。 
// 
// Related Topics 栈 
// 👍 102 👎 0


//Java：索引处的解码字符串

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P880DecodedStringAtIndex {
    public static void main(String[] args) {
        Solution solution = new P880DecodedStringAtIndex().new Solution();
        System.out.println(solution.decodeAtIndex("a2345678999999999999999", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeAtIndex1(String S, int K) {
            StringBuilder sb = new StringBuilder();
            for (char c : S.toCharArray()) {
                if (Character.isDigit(c)) {
                    String tmp = sb.toString();
                    for (int i = 1; i < c - '0'; i++) {
                        sb.append(tmp);
                    }
                    sb = new StringBuilder(sb);
                } else {
                    sb.append(c);
                }
                if (sb.length() >= K) {
                    break;
                }
            }
            return String.valueOf(sb.charAt(K - 1));
        }

        public String decodeAtIndex(String S, int K) {
            long size = 0;
            for (char c : S.toCharArray()) {
                if (Character.isDigit(c)) {
                    size *= (c - '0');
                } else {
                    size++;
                }
            }
            long no = size;
            for (int i = S.length() - 1; i >= 0; i--) {
                char c = S.charAt(i);
                if (K == 0 && Character.isLetter(c)) {
                    return String.valueOf(c);
                }
                if (Character.isDigit(c)) {
                    int num = c - '0';
                    no /= num;
                    K %= no;
                } else if (no == K) {
                    return String.valueOf(c);
                } else {
                    no--;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}