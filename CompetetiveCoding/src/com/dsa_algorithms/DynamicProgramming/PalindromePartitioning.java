package com.dsa_algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> ans;
    List<String> vec;
    int n;

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        System.out.println(obj.partition("aab"));
        System.out.println(obj.partition("ersbeereabbaer"));
    }

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        vec = new ArrayList<>();
        n = s.length();
        return partition(0, s);
    }

    public List<List<String>> partition(int start, String s) {
        if (start >= n) {
            ans.add(new ArrayList<>(vec));
            return ans;
        }
        StringBuilder str = new StringBuilder();
        for (int i = start; i < n; i++) {
            str.append(s.charAt(i));
            if (isPalindrome(s, start, i)) {
                vec.add(str.toString());
                partition(i + 1, s);
                vec.remove(vec.size() - 1);
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
