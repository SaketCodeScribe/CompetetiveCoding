package com.dsa_algorithms.Contest.biweekly.biweekly157;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {


    }
    public long sumOfLargestPrimes(String s) {
        int i, j, n = s.length(), k = (int)Math.sqrt(Math.pow(10,10)-1)+1;
        boolean[] isPrime = new boolean[k+1];
        Arrays.fill(isPrime, true);
        isPrime[1] = isPrime[0] = false;
        Set<Long> set = new HashSet<>();

        for(i=2; i<=k; i++){
            if (isPrime[i]) {
                for (j = 2; i * j <= k; j++){
                    isPrime[i*j] = false;
                }
            }
        }
        for(i=0; i<n; i++){
            for(j=0; j<=i; j++){
                long value = Long.valueOf(s.substring(j,i+1));
                if (checkPrime(value, isPrime)){
                    set.add(value);
                }
            }
        }
        List<Long> arr = new ArrayList<>();
        arr.addAll(set);
        if (arr.size() < 3){
            return arr.stream().reduce((long)0, (a,b)-> a+b);
        }
        arr.sort((a,b) -> Long.compare(b,a));
        return arr.get(0)+arr.get(1)+arr.get(2);
    }
    private boolean checkPrime(long value, boolean[] prime){
        int i;
        if (value < 2){
            return false;
        }
        for(i=2; i<prime.length; i++){
            if (prime[i] && i != value && value % i == 0){
                return false;
            }
        }
        return true;
    }
}
