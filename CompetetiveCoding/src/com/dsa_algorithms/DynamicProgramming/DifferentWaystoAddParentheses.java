package com.dsa_algorithms.DynamicProgramming;
import java.util.*;
public class DifferentWaystoAddParentheses {

    Map<int[], List<Integer>> map;
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        map = new HashMap<>();
        return diffWaysToCompute(0, n-1, expression);
    }
    public List<Integer> diffWaysToCompute(int l, int r, String str){
        List<Integer> arr = new ArrayList<>();
        int[] ind = new int[]{l,r};

        if (!(str.substring(l,r+1).contains("+")||str.substring(l,r+1).contains("-")||str.substring(l,r+1).contains("*"))){
            arr.add(Integer.valueOf(str.substring(l,r+1)));
            return arr;
        }
        if (map.get(ind) != null)
            return map.get(ind);
        for(int i=l; i<=r; i++){
            char op = str.charAt(i);
            if (!Character.isDigit(op)){
                List<Integer> lefts = diffWaysToCompute(l, i-1, str);
                List<Integer> rights = diffWaysToCompute(i+1, r, str);
                for(Integer left:lefts){
                    for(Integer right:rights){
                        if (op == '+')
                            arr.add(left+right);
                        else if (op == '-')
                            arr.add(left-right);
                        else if (op == '*')
                            arr.add(left*right);
                    }
                }
            }
        }
        map.put(ind, arr);
        return arr;
    }
}
