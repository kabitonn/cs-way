package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

public class S204CountPrimes {

    public static void main(String[] args) {

    }
    public int countPrimes1(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for(int i=2;i<n;i++) {
            if(!notPrime[i]) {
                count++;
                for(int j=i*2;j<n;j+=i) {
                    notPrime[j] = true;
                }
            }
        }
        return count;
    }
    public int countPrimes(int n) {
        int count = 0;
        if(n>2) {count++;}
        for(int i=3;i<n;i+=2) {
            if(isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n) {
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}
