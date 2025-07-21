package com.dsa_algorithms.practice;

import java.util.*;
public class L975 {
    public int oddEvenJumps(int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Integer[] map = new Integer[1_00_001];
        int i, n = arr.length, ans = 0;
        Integer[] nextLargerElement = new Integer[n];
        Integer[] nextSmallerElement = new Integer[n];
        boolean[][] dp = new boolean[n][2];

        treeSet.add(arr[n-1]);
        map[arr[n-1]] = n-1;
        for(i=n-2; i>=0; i--){
            Integer elt = treeSet.ceiling(arr[i]);
            if (elt != null){
                nextLargerElement[i] = map[elt];
            }
            elt = treeSet.floor(arr[i]);
            if (elt != null){
                nextSmallerElement[i] = map[elt];
            }
            map[arr[i]] = i;
            treeSet.add(arr[i]);
        }

        for(i=n-1; i>=0 ;i--){
            if (i == n-1){
                dp[i][0] = dp[i][1] = true;
            }
            else{
                Integer index = nextLargerElement[i];
                if (index != null){
                    dp[i][0] = dp[index][1];
                }
                index = nextSmallerElement[i];
                if (index != null){
                    dp[i][1] = dp[index][0];
                }
            }
            if (dp[i][0]){
                ans++;
            }
        }
        return ans;
    }
}
