package com.dsa_algorithms.Greedy;

import java.util.Stack;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int i, n = s.length(), lo, hi;
        i = lo = hi = 0;

        while(i < n){
            char ch = s.charAt(i++);
            lo += ch == '(' ? 1 : -1;
            hi += ch != ')' ? 1 : -1;
            if (hi < 0)
                return false;
            lo = Math.max(lo,0);
        }
        return lo == 0;
    }
}
