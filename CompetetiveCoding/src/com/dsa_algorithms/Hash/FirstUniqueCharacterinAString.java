package com.dsa_algorithms.Hash;

public class FirstUniqueCharacterinAString {
    public int firstUniqChar(String s) {
        int[] chars = new int[26];

        for(char ch:s.toCharArray())
            chars[ch-'a']++;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (chars[ch-'a'] == 1)
                return i;
        }
        return -1;
    }
}
