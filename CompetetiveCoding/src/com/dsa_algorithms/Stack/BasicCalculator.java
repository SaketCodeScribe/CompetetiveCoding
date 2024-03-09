package com.dsa_algorithms.Stack;

import java.util.*;

public class BasicCalculator {
    public int calculate(String s) {
        int n = s.length(),i = 0, num = 0, ans = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();

        while(i < n) {
            char ch = s.charAt(i++);
            if (Character.isDigit(ch))
                num = 10 * num + (ch - '0');
            if (ch == '+') {
                ans += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                ans += sign * num;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(ans);
                stack.push(sign);
                sign = 1;
                ans = num = 0;
            } else if (ch == ')') {
                ans += sign * num;
                sign = stack.pop();
                ans += sign * stack.pop();
                sign = 1;
                num = 0;
            }
        }
        if (num != 0)
            ans += sign*num;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate(" 18416    +1894654-(-5661+83)+((-1-23))"));
    }
}
