package com.dsa_algorithms.Hash;

public class AnagramPairs {
    public static boolean isAnagram(String str1, String str2) {
        //Your code goes here
        int m = str1.length(), n = str2.length();
        if (m != n)
            return false;
        int[] chars = new int[26];
        for(char ch:str1.toCharArray())
            chars[ch-'a']++;
        for(char ch:str2.toCharArray()){
            if (chars[ch-'a'] == 0)
                return false;
            chars[ch-'a']--;
        }
        return true;
    }
}
