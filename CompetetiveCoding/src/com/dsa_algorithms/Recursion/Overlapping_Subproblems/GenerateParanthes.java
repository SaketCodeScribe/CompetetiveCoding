package com.dsa_algorithms.Recursion.Overlapping_Subproblems;

import java.util.*;
public class GenerateParanthes {
    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return Arrays.asList("");
        List<String> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(String left:generateParenthesis(i)){
                for(String right:generateParenthesis(n-i-1))
                    ans.add("("+left+")"+right);
            }
        }
        return ans;
    }
}
