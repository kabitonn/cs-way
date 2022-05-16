package com.vika.way.pre.autumn.interview.tencent;

/**
 * @author ：tangjiawei
 * @date ：2020/9/12 22:26
 */

/**
 * 1.对于一棵满二叉排序树深度为K，节点数为 2^K - 1 ；节点值为 1至 (2^K-1)。
 * 给出K和任意三个节点的值，输出包含该三个节点的最小子树的根节点值
 * 样例输入：k =4 节点：10 15 13
 * 样例输出：12
 * <p>
 *            8
 *       /        \
 *      4          12
 *    /   \       /   \
 *   2     6     10    14
 *  / \   / \   /  \  /  \
 * 1   3 5   7 9   11 13  15
 */
public class BinarySearchPerfectTreeAncestor {

    public int minAncestor(int k, int p1, int p2, int p3) {
        if (k <= 0) {
            return 0;
        }
        int r = (int) Math.pow(2, k - 1);
        int size = r / 2;
        while (true) {
            if (p1 < r && p2 < r && p3 < r) {
                r = r - size;
            } else if (p1 > r && p2 > r && p3 > r) {
                r = r + size;
            } else {
                break;
            }
            size /= 2;
        }
        return r;
    }
}
