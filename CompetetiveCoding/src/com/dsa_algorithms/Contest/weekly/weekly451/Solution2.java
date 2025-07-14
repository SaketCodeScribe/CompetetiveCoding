package com.dsa_algorithms.Contest.weekly.weekly451;

import java.util.Stack;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(resultingString("mpnom"));
    }
    public static String resultingString(String s) {
        int i, j, n = s.length();
        char[] chars = new char[n];
        if (s.isEmpty()){
            return "";
        }
        j=-1;
        for(i=0; i<n; i++){
            char ch = s.charAt(i);
            if (j > -1 && (((chars[j]-'a')-(ch-'a')+26)%26 == 1 || ((chars[j]-'a')-(ch-'a')+26)%26 == 25)){
                j--;
            }
            else{
                chars[++j] = ch;
            }
        }
        return new String(chars).substring(0,j+1);
    }
}
