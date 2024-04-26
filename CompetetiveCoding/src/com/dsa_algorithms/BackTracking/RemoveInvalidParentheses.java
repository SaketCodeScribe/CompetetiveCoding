package com.dsa_algorithms.BackTracking;

import java.util.*;

public class RemoveInvalidParentheses {
    Set<String> set;
    int min = Integer.MAX_VALUE;
    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();
        StringBuilder exp = new StringBuilder();

        int i, n = s.length(), opRem = 0, clRem = 0;
        for(i=0; i<n; i++){
            if (s.charAt(i) == '(')
                opRem++;
            else if (s.charAt(i) == ')'){
                clRem = opRem == 0 ? clRem + 1 : clRem;
                opRem = opRem > 0 ? opRem - 1 : opRem;
            }
        }
        System.out.println(opRem+" "+clRem);
        recurse(s,0,n,0,0,opRem,clRem,exp);
        return new ArrayList<>(set);
    }
    public void recurse(String s, int i, int n, int lc, int rc, int opRem, int clRem, StringBuilder exp){
        if (i >= n){
            if (clRem == 0 && opRem == 0){
                set.add(exp.toString());
            }
            return;
        }
        char ch = s.charAt(i);
        int len = exp.length();
        if ((ch == '(' && opRem > 0) || (ch == ')' && clRem > 0)){
            recurse(s, i+1, n, lc, rc,
                    ch == '(' ? opRem-1 : opRem,
                    ch == ')' ? clRem-1 : clRem,
                    exp);
        }
        exp.append(ch);
        if (ch == '(')
            recurse(s,i+1,n,lc+1,rc,opRem,clRem,exp);
        else if(ch == ')'){
            if (rc < lc)
                recurse(s,i+1,n,lc,rc+1,opRem,clRem,exp);
        }
        else
            recurse(s,i+1,n,lc,rc,opRem,clRem,exp);
        exp.deleteCharAt(len);
        return;
    }
}
