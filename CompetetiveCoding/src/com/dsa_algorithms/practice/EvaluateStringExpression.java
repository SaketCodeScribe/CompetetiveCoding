package com.dsa_algorithms.practice;

import java.util.Stack;

/*
String expression evaluation
Ex: 2a+2b-(a-b)
 */
public class EvaluateStringExpression {
    static class Digit{
        String digit;
        int index;

        public Digit(String digit, int index) {
            this.digit = digit;
            this.index = index;
        }
    }
    public String evaluateExpression(String str){
        int i = 0, n = str.length();
        char sign = '_';
        Stack<String>[] stackArray = new Stack[26];

        while(i < n){
            if (str.charAt(i) == '+' || str.charAt(i) == '-'){
                sign = str.charAt(i);
                i++;
            }
            else if (str.charAt(i) == '('){
                for(int d = 0; d<26; d++){
                    if (stackArray[d] == null){
                        stackArray[d] = new Stack<>();
                    }
                    if (sign != '_') {
                        stackArray[d].push("" + sign);
                    }
                    stackArray[d].push("(");
                }
                i++;
            }
            else if (str.charAt(i) == ')'){
                for(int d = 0; d<26; d++){
                    String eval = evaluate(stackArray[d]);
                    if (!eval.isEmpty()) {
                        stackArray[d].add(eval);
                    }
                }
                i++;
            }
            else {
                Digit digit = extractDigit(str, i, n);
                String num = digit.digit;
                int j = digit.index;
                char ch = str.charAt(j);
                if (stackArray[ch - 'a'] == null) {
                    stackArray[ch - 'a'] = new Stack<>();
                }
                if (sign != '_') {
                    stackArray[ch - 'a'].push("" + sign);
                }
                stackArray[ch - 'a'].push(num);
                i = j + 1;
            }
        }
        StringBuilder result = new StringBuilder();

        for(int d = 0; d<26; d++){
            String coeff = evaluate(stackArray[d]);
            if (!coeff.isEmpty()) {
                if (d > 0) {
                    if (Integer.parseInt(coeff) > 0) {
                        result.append("+");
                    }
                    else{
                        result.append("-");
                    }
                }
                result.append(coeff).append((char) ('a' + d));
            }
        }
        return result.toString();
    }

    private Digit extractDigit(String str, int i, int n) {
        StringBuilder sb = new StringBuilder();
        while(i<n && Character.isDigit(str.charAt(i))){
            sb.append(str.charAt(i));
            i++;
        }
        String num = sb.toString();
        return new Digit(num.isEmpty() ? "1" : num, i);
    }
    private String evaluate(Stack<String> stack){
        int num = 0;
        if (stack.isEmpty()){
            return "";
        }
        if (stack.peek().equals("(")){
            stack.clear();
            return "";
        }
        while(!stack.isEmpty() && !(stack.peek().equals("+") || stack.peek().equals("-"))){
            String num1 = stack.pop();
            String sign = stack.pop();
            String num2 = stack.pop();
            if (sign.equals("+")){
                num += Integer.parseInt(num1) + (!num2.equals("(") ? Integer.parseInt(num2) : 0);
            }
            else{
                num += (!num2.equals("(") ? Integer.parseInt(num2) : 0) - Integer.parseInt(num1);
            }
            if (num2.equals("(")){
                break;
            }
        }
        return String.valueOf((!stack.isEmpty() ?  stack.peek().equals("+") ? 1 : -1 : 1)*num);
    }

    public static void main(String[] args) {
        EvaluateStringExpression obj = new EvaluateStringExpression();
        System.out.println(obj.evaluateExpression("2a+2b-(a-b)"));
        System.out.println(obj.evaluateExpression("(((2a+2b)-((a-b))))"));
    }
}
