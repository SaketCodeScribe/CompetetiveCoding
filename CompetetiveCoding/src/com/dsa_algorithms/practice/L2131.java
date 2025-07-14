package com.dsa_algorithms.practice;

import java.util.*;

public class L2131 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[]{"lc","cl","gg","ab","ty","yt","lc","cl","ab","lc","cl","gg","lc","cl","gg","ab","ty","yt"}));
        System.out.println(longestPalindrome(new String[]{"mm","mm","yb","by","bb","bm","ym","mb","yb","by","mb","mb","bb","yb","by","bb","yb","my","mb","ym"}));
    }
    public static int longestPalindrome(String[] words) {
        int ans = 0;
        boolean flag = false;
        Map<String, Integer> map = new HashMap<>();

        for (String element : words) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        for (String element : words) {
            if (element.charAt(0) != element.charAt(1)) {
                String reverse = new StringBuilder(element).reverse().toString();
                int count = Math.min(map.get(element), map.getOrDefault(reverse, 0));
                ans += 2 * count * element.length();
            } else {
                int value = map.get(element);
                if (value > 1) {
                    ans += value / 2 * 2 * element.length();
                }
                if (value % 2 != 0) {
                    flag = true;
                }
            }
            map.put(element, 0);
        }
        return ans + (flag ? 2 : 0);
    }
}
