package com.dsa_algorithms.Hash;
import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static ArrayList<ArrayList<String>> getGroupedAnagrams(ArrayList<String> inputStr, int n) {
        // Write your code here.
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int[] chars = new int[26];
            for(char ch:inputStr.get(i).toCharArray())
                chars[ch-'a']++;
            String key = Arrays.stream(chars).mapToObj(String::valueOf).collect(Collectors.joining());
            Integer val = map.get(key);
            if (val == null){
                map.put(key, ans.size());
                val = ans.size();
                ans.add(new ArrayList<>());
            }
            ans.get(val).add(inputStr.get(i));
        }
        return ans;
    }
}
