package com.dsa_algorithms.Hash;

import java.util.*;

public class ShortestUncommonSubstringinanArray {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length, i, j, k;
        Map<String, Set<Integer>> map = new HashMap<>();
        String[] ans = new String[n];
        Arrays.fill(ans, "");
        for(i=0; i<n; i++){
            for(j=0; j<arr[i].length(); j++){
                StringBuilder str = new StringBuilder();
                for(k=j; k<arr[i].length(); k++){
                    str.append(arr[i].charAt(k));
                    map.computeIfAbsent(str.toString(), k1 -> new HashSet<>());
                    map.get(str.toString()).add(i);
                }
            }
        }
        for(i=0; i<n; i++){
            for(j=0; j<arr[i].length(); j++){
                StringBuilder str = new StringBuilder();
                for(k=j; k<arr[i].length(); k++){
                    str.append(arr[i].charAt(k));
                    if (map.get(str.toString()).size() == 1)
                        if (ans[i].equals("") || ans[i].length() > str.length() || (ans[i].length() == str.length() && ans[i].compareTo(str.toString()) > 0))
                            ans[i] = str.toString();
                }
            }
        }
        return ans;
    }
}
