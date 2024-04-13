package com.dsa_algorithms.DynamicProgramming;

import java.util.*;
public class GenerateParenthesis {
    Map<int[], List<String>> map;
    public List<String> generateParenthesis(int n) {
        map = new HashMap<>();
        return generateParenthesis(0, 0, n);
    }
    public List<String> generateParenthesis(int op, int clo, int n){
        List<String> temp = new ArrayList<>();
        if (op == clo && op == n){
            temp.add("");
            return temp;
        }
        if (map.get(new int[]{op, clo}) != null)
            return map.get(new int[]{op, clo});
        if (op >= clo && op < n){
            for(String str:generateParenthesis(op+1, clo, n))
                temp.add("("+str);
        }
        if (op > clo){
            for(String str:generateParenthesis(op, clo+1, n))
                temp.add(")"+str);
        }
        map.put(new int[]{op, clo}, temp);
        return temp;
    }
}
