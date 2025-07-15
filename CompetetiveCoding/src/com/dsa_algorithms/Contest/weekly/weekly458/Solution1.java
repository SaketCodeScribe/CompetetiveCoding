package com.dsa_algorithms.Contest.weekly.weekly458;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1 {
    public String processStr(String s) {
        int n = s.length();
        List<Character> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if (ch == '*' && !ans.isEmpty()){
                ans.remove(ans.size()-1);
            }
            else if (ch == '#'){
                ans.addAll(ans);
            }
            else if (ch == '%'){
                Collections.reverse(ans);
            }
            else{
                ans.add(ch);
            }
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
