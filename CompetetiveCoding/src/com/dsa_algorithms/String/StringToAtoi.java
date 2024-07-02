package com.dsa_algorithms.String;

public class StringToAtoi {
    public int myAtoi(String s) {
        int i = 0, n;
        String max = String.valueOf(Integer.MAX_VALUE), min = String.valueOf(Integer.MIN_VALUE);
        String sign = "";
        boolean isZero = true;
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        n = s.length();
        if (n == 0)
            return 0;
        if (s.charAt(0) == '-'){
            sign = "-";
            i = 1;
        }
        else if (s.charAt(0) == '+')
            i=1;

        while(i < n && sb.length() < 11){
            char ch = s.charAt(i);
            if (ch != '0'){
                isZero = false;
            }
            if (!isZero){
                if (Character.isDigit(ch))
                    sb.append(ch);
                else
                    break;
            }
            i++;
        }

        if (sb.isEmpty())
            return 0;
        String ans = sign+sb.toString();
        return sign.isEmpty() ? compareNum(ans, max) : compareNum(ans, min);
    }
    public int compareNum(String a, String b){
        if (a.length() < b.length())
            return Integer.valueOf(a);
        else if (a.length() > b.length())
            return Integer.valueOf(b);
        else if (a.compareTo(b) < 0)
            return Integer.valueOf(a);
        return Integer.valueOf(b);
    }
}
