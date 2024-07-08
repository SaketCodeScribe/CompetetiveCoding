package com.dsa_algorithms.Stack.Pop_When_Closing_bracket;

import java.util.*;
public class DecodeString {
    public String decodeString(String s) {
        int i = 0, n = s.length(), num = 0;
        String ans = "";
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stack = new Stack<>();

        while(i < n){
            if(Character.isDigit(s.charAt(i)))
                num = num*10+(s.charAt(i)-'0');
            else{
                if (num > 0)
                    numStack.push(num);
                if (s.charAt(i) == ']'){
                    ans = "";
                    while(!stack.isEmpty() && !stack.peek().equals("["))
                        ans = stack.pop()+ans;
                    stack.pop();
                    num = numStack.pop()-1;
                    String temp = ans;
                    while(num-- > 0)
                        ans = ans+temp;
                    stack.push(ans);
                }
                else
                    stack.push(""+s.charAt(i));
                num = 0;
            }
            i++;
        }
        ans = "";
        while(!stack.isEmpty()){
            ans = stack.pop()+ans;;
        }
        return ans;
    }
}
