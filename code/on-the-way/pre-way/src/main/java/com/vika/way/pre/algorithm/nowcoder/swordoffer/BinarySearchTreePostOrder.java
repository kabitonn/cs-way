package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class BinarySearchTreePostOrder {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verifySequence(sequence, 0, sequence.length - 1);
    }

    public boolean verifySequence(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int rootVal = sequence[end];
        int left = start;
        for (; left < end; left++) {
            if (sequence[left] > rootVal) {
                break;
            }
        }
        for (int right = left; right < end; right++) {
            if (sequence[right] < rootVal) {
                return false;
            }
        }
        return verifySequence(sequence, start, left - 1) && verifySequence(sequence, left, end - 1);

    }
}
