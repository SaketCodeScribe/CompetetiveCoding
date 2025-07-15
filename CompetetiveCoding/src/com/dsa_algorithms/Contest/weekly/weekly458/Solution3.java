package com.dsa_algorithms.Contest.weekly.weekly458;

import java.util.*;
public class Solution3 {
    public char processStr(String s, long k) {
        long l=0;

        for(char ch:s.toCharArray()){
            if (ch == '*'){
                l = Math.max(0, l-1);
            }
            else if (ch == '#'){
                l *= 2;
            }
            else if (ch == '%'){
                continue;
            }
            else{
                l++;
            }
        }
        if (k >= l){
            return '.';
        }
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if (ch == '*'){
                l++;
            }
            else if (ch == '#'){
                l /= 2;
                if (k >= l){
                    k -= l;
                }
            }
            else if (ch == '%'){
                k = l-k-1;
            }
            else{
                l--;
                if (k == l){
                    return ch;
                }
            }
        }
        return '.';
    }
}
