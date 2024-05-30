package com.dsa_algorithms.Stack;

import java.util.Stack;

public class NextGreaterNumber {
    public static String nextGreater(String s) {
        // Write your code here
        int n = s.length(), i;
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        i = n-1;

        while(i >= 0){
            if (i < n-1 && s.charAt(i) < s.charAt(i+1)){
                char last = stack.peek();
                while(!stack.isEmpty()){
                    char val = stack.pop();
                    if (val > s.charAt(i)){
                        if (stack.isEmpty()){
                            ans.append(s.charAt(i));
                            last = val;
                        }
                        else if (s.charAt(i) < stack.peek())
                            ans.append(val);
                        else{
                            last = val;
                            ans.append(s.charAt(i));
                        }
                    }
                    else
                        ans.append(val);
                }
                ans.append(last);
                i--;
                break;
            }
            stack.push(s.charAt(i--));
        }
        while(i >= 0)
            ans.append(s.charAt(i--));
        ans = ans.reverse();
        return ans.length() > 0 ? ans.toString() : "-1";
    }
}
