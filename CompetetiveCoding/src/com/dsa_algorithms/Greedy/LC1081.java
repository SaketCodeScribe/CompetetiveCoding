package com.dsa_algorithms.Greedy;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1081 {
    public String smallestSubsequence(String s) {
        int n = s.length(), i;
        int[] freq = new int[26];
        boolean[] vis = new boolean[26];
        Deque<Character> queue = new ArrayDeque<>();

        for(char ch:s.toCharArray()) freq[ch-'a']++;

        for(i=0; i<n; i++) {
            char ch = s.charAt(i);
            while (!queue.isEmpty() && !vis[ch-'a'] && ch < queue.peekLast() && freq[queue.peekLast()-'a'] > 0) {
                vis[queue.pollLast()-'a'] = false;
            }
            if (!vis[ch-'a']){
                queue.addLast(ch);
                vis[ch-'a'] = true;
            }
            freq[ch-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.pollFirst());
        }
        return sb.toString();
    }
}
