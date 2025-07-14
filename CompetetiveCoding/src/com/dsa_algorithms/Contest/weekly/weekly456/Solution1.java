package com.dsa_algorithms.Contest.weekly.weekly456;
import java.util.*;
public class Solution1 {
    public static List<String> partitionString(String s) {
        int i, n = s.length();
        StringBuilder sb = new StringBuilder();
        Set<String> set = new LinkedHashSet<>();
        i = 0;

        while(i < n){
            sb = new StringBuilder(s.charAt(i)+"");
            while(i < n && set.contains(sb.toString())){
                sb.append(s.charAt(++i)+"");
            }
            set.add(sb.toString());
            i++;
        }
        return set.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(partitionString("abbccccd"));
    }
}
