package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

public class S299BullsandCows {

    public static void main(String[] args) {
        S299BullsandCows solution = new S299BullsandCows();
        System.out.println(solution.getHint1("1807", "7810"));
    }

    public String getHint(String secret, String guess) {
        int[] nums = new int[10];
        int A = 0, B = 0;
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (i < secret.length() && c == secret.charAt(i)) {
                A++;
            } else {
                nums[c - '0']++;
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (i >= guess.length() || c != guess.charAt(i)) {
                if (nums[c - '0'] > 0) {
                    B++;
                    nums[c - '0']--;
                }
            }
        }
        return A + "A" + B + "B";
    }

    public String getHint2(String secret, String guess) {
        int[] nums = new int[10];
        int A = 0, B = 0;
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                A++;
            } else {
                nums[c1 - '0']--;
                nums[c2 - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (nums[i] > 0) {
                B += nums[i];
            }
        }
        B = secret.length() - A - B;
        return A + "A" + B + "B";
    }

    public String getHint1(String secret, String guess) {
        int[] buck1 = new int[10];
        int[] buck2 = new int[10];
        int A = 0, B = 0;
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                A++;
            } else {
                buck1[c1 - '0']++;
                buck2[c2 - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            B += Math.min(buck1[i], buck2[i]);
        }
        return A + "A" + B + "B";
    }
}
