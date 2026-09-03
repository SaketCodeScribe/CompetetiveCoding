package com.dsa_algorithms.TwoPointer;

import java.util.Set;

public class LC345 {
    public String reverseVowels(String s) {
        int i = 0, j = s.length()-1;
        char[] chars = new char[s.length()];
        Set<Character> vowel = Set.of('a','e','i','o','u','A','E','I','O','U');

        while(i <= j) {
            while (i <= j && !vowel.contains(s.charAt(i))) chars[i] = s.charAt(i++);
            while (i <= j && !vowel.contains(s.charAt(j))) chars[j] = s.charAt(j--);
            if (i <= j){
                chars[i] = s.charAt(j);
                chars[j--] = s.charAt(i++);
            }
        }
        return new String(chars);
    }
}
