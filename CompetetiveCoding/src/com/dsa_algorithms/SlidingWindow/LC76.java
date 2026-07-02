package com.dsa_algorithms.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC76 {
    public String minWindow(String s, String t) {
        int i = 0, j = 0, m = s.length(), start = 0, end = -1, formed = 0, required;
        Map<Character, Integer> source = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        required = collect(t, target);

        while (j < m) {
            char currCh = s.charAt(j++);
            target.computeIfPresent(currCh, (k, v) -> {
                source.compute(k, (sk, sv) -> sv == null ? 1 : sv + 1);
                return v;
            });
            if (target.getOrDefault(currCh, -1).equals(source.getOrDefault(currCh, 0))) formed++;

            while (i < j && formed == required) {
                if (end < start || j - i < end - start) {
                    start = i;
                    end = j;
                }
                char begCh = s.charAt(i++);
                if (target.getOrDefault(begCh, -1).equals(source.getOrDefault(begCh, 0))) formed--;
                source.computeIfPresent(begCh, (k, v) -> v - 1);
                if (source.getOrDefault(begCh, -1) == 0) source.remove(begCh);
            }
        }
        return end > start ? s.substring(start, end) : "";
    }

    private int collect(String str, Map<Character, Integer> map) {
        int unique = 0;
        for (char ch : str.toCharArray()) {
            if (map.compute(ch, (k, v) -> v == null ? 1 : v + 1) == 1)
                unique++;
        }
        return unique;
    }
}
