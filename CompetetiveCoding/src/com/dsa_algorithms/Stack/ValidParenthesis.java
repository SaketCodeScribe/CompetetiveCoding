package com.dsa_algorithms.Stack;

import java.util.*;
public class ValidParenthesis {
    public boolean isValid(String s) {
        int i, n = s.length();
        Stack<Character> stack = new Stack<>();

        for(i=0; i<n; i++){
            char ch = s.charAt(i);
            if (ch == ')' || ch == ']' || ch == '}'){
                if (stack.isEmpty())
                    return false;
                if((stack.peek() == '(' && ch != ')') || (stack.peek() == '[' && ch != ']') || (stack.peek() == '{' && ch != '}'))
                    return false;
                stack.pop();
            }
            else
                stack.push(ch);
        }
        return stack.isEmpty() ? true : false;
    }
}
