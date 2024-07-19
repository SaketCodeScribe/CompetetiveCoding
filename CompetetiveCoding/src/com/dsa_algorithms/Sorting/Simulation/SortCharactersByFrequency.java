package com.dsa_algorithms.Sorting.Simulation;

import java.util.*;
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        List<Character> chars;

        for(char ch:s.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)+1);
        chars = new ArrayList<>(map.keySet());
        Collections.sort(chars, (a,b) -> Integer.compare(map.get(b), map.get(a)));
        for(char ch:chars){
            int cnt = map.get(ch);
            while(cnt-- > 0)
                ans.append(ch);
        }
        return ans.toString();
    }
}
