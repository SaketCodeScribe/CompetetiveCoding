package com.dsa_algorithms.Stack;

import java.util.*;

public class RemoveKDigits {
    Deque<Character> deque;
    int k;
    public String removeKdigits(String num, int K) {
        int n = num.length();
        k = K;
        if (n == k)
            return "0";

        num = removeDigits(num, 0, n-1);
        num = removeZeroesFromBeg(num);
        return k > num.length() ? "0" : num.substring(0, num.length()-k);
    }

    public String removeZeroesFromBeg(String num){
        int i = 0;
        while(i < num.length()){
            if (num.charAt(i) != '0')
                break;
            i++;
        }
        return i >= num.length() ? "0" : num.substring(i, num.length());
    }

    public String removeDigits(String num, int s, int e){
        deque = new LinkedList();
        StringBuilder sb = new StringBuilder();
        int i = s;

        while(i <= e && k > 0){
            while(!deque.isEmpty() && k > 0 && deque.peekLast() > num.charAt(i)){
                deque.pollLast();
                k--;
            }
            deque.addLast(num.charAt(i++));
        }
        while(!deque.isEmpty())
            sb.append(deque.pollFirst());
        while(i <= e)
            sb.append(num.charAt(i++));
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
