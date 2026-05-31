package com.dsa_algorithms.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int m = s.length();
        int n = words.length;
        int k = words[0].length();

        if (m < n * k) return ans;

        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < k; offset++) {
            slide(offset, s, k, freq, ans);
        }

        return ans;
    }

    private void slide(int start,
                       String s,
                       int wordLen,
                       Map<String, Integer> freq,
                       List<Integer> ans) {

        int left = start;
        int right = start;
        int matchedWords = 0;

        Map<String, Integer> seen = new HashMap<>();

        while (right + wordLen <= s.length()) {
            String word = s.substring(right, right + wordLen);

            if (!freq.containsKey(word)) {
                seen.clear();
                matchedWords = 0;
                right += wordLen;
                left = right;
                continue;
            }

            seen.put(word, seen.getOrDefault(word, 0) + 1);

            while (seen.get(word) > freq.get(word)) {
                String leftWord = s.substring(left, left + wordLen);

                if (seen.get(leftWord) >= freq.get(leftWord)) {
                    matchedWords--;
                }

                seen.put(leftWord, seen.get(leftWord) - 1);
                left += wordLen;
            }

            if (seen.get(word).equals(freq.get(word))) {
                matchedWords++;
            }

            if (matchedWords == freq.size()) {
                ans.add(left);

                String leftWord = s.substring(left, left + wordLen);
                seen.put(leftWord, seen.get(leftWord) - 1);
                matchedWords--;
                left += wordLen;
            }

            right += wordLen;
        }
    }
}
