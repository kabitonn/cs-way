package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S043MultiplyStrings {


    public static void main(String[] args) {
        S043MultiplyStrings solution = new S043MultiplyStrings();
        System.out.println(solution.multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        String multiply = "0";
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        for (int i = n1.length - 1; i >= 0; i--) {
            int a = n1[i] - '0';
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = n2.length - 1; j >= 0; j--) {
                int b = n2[j] - '0';
                int tmp = a * b + carry;
                sb.append(tmp % 10);
                carry = tmp / 10;
            }
            if (carry != 0) {
                sb.append(carry);
            }
            sb.reverse();
            for (int k = 0; k < n1.length - 1 - i; k++) {
                sb.append('0');
            }
            while (true) {
                if (sb.charAt(0) == '0' && sb.length() > 1) {
                    sb.deleteCharAt(0);
                } else {
                    break;
                }
            }
            String tmpMultiply = sb.toString();
            multiply = addString(tmpMultiply, multiply);
        }

        return multiply;

    }

    public String addString(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }

        return res.reverse().toString();
    }

    public String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int[] pos = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                //相乘的结果
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //加上 pos[i + j + 1] 之前已经累加的结果
                int sum = mul + pos[i + j + 1];
                //更新 pos[i + j]
                pos[i + j] += sum / 10;
                //更新 pos[i + j + 1]
                pos[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos.length; i++) {
            //判断最高位是不是 0
            if (i == 0 && pos[i] == 0) {
                continue;
            }
            sb.append(pos[i]);
        }
        return sb.toString();
    }
}
