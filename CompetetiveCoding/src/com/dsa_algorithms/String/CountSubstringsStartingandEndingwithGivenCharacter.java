package com.dsa_algorithms.String;

public class CountSubstringsStartingandEndingwithGivenCharacter {
    public long countSubstrings(String s, char c) {
        long ans = 0, cnt = 0;

        for(char ch:s.toCharArray()){
            if (ch == c)
                ans += (++cnt);
        }
        return ans;
    }
}
