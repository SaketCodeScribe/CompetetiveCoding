package com.dsa_algorithms.Stack;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int i, j = 0, n = num.length();
        if (k == n)
            return "0";
        while(j < n && k > 0){
            int val = num.charAt(j)-'0';
            while (k > 0 && !stack.isEmpty() && stack.peek() > val){
                stack.pop();
                k--;
            }
            if (!(stack.isEmpty() && val == 0))
                stack.push(val);
            j++;
        }
        while (k-- > 0 && !stack.isEmpty())
            stack.pop();
        i = j;
        while(i < n && num.charAt(i) == '0')
            i++;
        if (i == n && stack.isEmpty())
            return "0";
        if (stack.isEmpty())
            return num.substring(i);
        return stack.stream().map(String::valueOf).collect(Collectors.joining(""))+num.substring(j);
    }
}
