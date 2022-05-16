package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S038CountAndSay {

    public static void main(String[] args) {
        S038CountAndSay solution = new S038CountAndSay();
        System.out.println(solution.countAndSay1(4));

    }

    public String countAndSay2(int n){
        String last = "1";
        while(n-->1){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int i=0;i<last.length();i++){
                if(i+1<last.length()&&last.charAt(i)==last.charAt(i+1)){
                    count++;
                }
                else {
                    sb.append(count).append(last.charAt(i));
                    count=1;
                }
            }
            last = sb.toString();
        }
        return last;
    }
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String last = countAndSay(n - 1);
        return getNextString(last);
    }
    private String getNextString1(String last){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i=0;i<last.length();i++){
            if(i+1<last.length()&&last.charAt(i)==last.charAt(i+1)){
                count++;
            }
            else {
                sb.append(count).append(last.charAt(i));
                count=1;
            }
        }
        return sb.toString();
    }

    public String getNextString(String last) {
        if (last.length() == 0) {
            return "";
        }
        int repeatNum = getRepeatNum(last);
        return "" + repeatNum + last.charAt(0) + getNextString(last.substring(repeatNum));
    }

    public String countAndSay1(int n){
        String res = "1";
        while(n-->1){
            String tmp = "";
            for(int i=0;i<res.length();i++){
                int repeatNum= getRepeatNum(res.substring(i));
                tmp = tmp+repeatNum+res.charAt(i);
                i=i+repeatNum-1;
            }
            res = tmp;
        }
        return res;
    }

    private int getRepeatNum(String string) {
        int count = 1;
        char ch = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (ch == string.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
