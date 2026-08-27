package com.dsa_algorithms.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> anagram = new HashMap<>();

        for(String str:strs) {
            String key = hash(str);
            anagram.computeIfAbsent(key, x -> new ArrayList<>()).add(str);
        }
        ans.addAll(anagram.values());
        return ans;
    }
    private String hash(String str) {
        int[] cnt = new int[26];
        StringBuilder key = new StringBuilder();
        for(char ch:str.toCharArray()) cnt[ch-'a']++;
        for(int c:cnt) key.append(c+",");
        return key.toString();
    }
}
