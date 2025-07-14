package com.dsa_algorithms.Maths.Combinatorics;

import java.util.TreeMap;

public class L2842 {
    private static final int MOD = 1_000_000_007;
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        int i, n = s.length();
        int[] cnt = new int[26];
        double ans = 1d;
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        for(i=0; i<n; i++){
            cnt[s.charAt(i)-'a']++;
        }
        for(i=0; i<26; i++){
            if (cnt[i] > 0){
                tree.put(cnt[i], tree.getOrDefault(cnt[i], 0)+1);
            }
        }
        for(int key:tree.descendingKeySet()){
            int val = tree.get(key);
            if (val < k){
                ans = (ans%MOD * Math.pow(key, val)%MOD)%MOD;
                k -= val;
            }
            else{
                ans = (ans%MOD * (combinatorics(val, k)%MOD*Math.pow(key, k))%MOD)%MOD;
                k = 0;
            }
            if (k == 0){
                break;
            }
        }
        if (k > 0){
            return 0;
        }
        return (int)(ans%MOD);
    }
    private double combinatorics(int n, int k){
        double comb = 1d;

        for(int i=1; i<=k; i++){
            comb = (comb * (1d*(n-i+1))/i);
        }
        return comb%MOD;
    }

    public static void main(String[] args) {
        L2842 obj = new L2842();
    }
}
