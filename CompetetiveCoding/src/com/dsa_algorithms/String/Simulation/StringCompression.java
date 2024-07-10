package com.dsa_algorithms.String.Simulation;

import java.util.*;
public class StringCompression {
    public int compress(char[] chars) {
        int i = 1, j = 0, n = chars.length, cnt = 1;
        List<Character> ans = new ArrayList<>();

        while(i <= n){
            if(i < n && chars[i] == chars[i-1])
                cnt++;
            else{
                chars[j++] = chars[i-1];
                if (cnt > 1){
                    for(char digit:Integer.toString(cnt).toCharArray())
                        chars[j++] = digit;
                }
                cnt = 1;
            }
            i++;
        }
        return j;
    }
}
