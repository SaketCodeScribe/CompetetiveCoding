package com.dsa_algorithms.String;

public class kThCharaterOfDecryptedString {
    public static char kThCharaterOfDecryptedString(String s, Long k){
        // Write your code here
        int i, j, substringLength, n = s.length();
        long num;
        i = 0;
        while(i < n){
            j = getLastIndex(s, i);
            String value = getFrequency(s, j);
            num = Long.valueOf(value);
            substringLength = j-i;
            if (k > num*substringLength)
                k -= num*substringLength;
            else{
                k = (k-1)%substringLength;
                return s.charAt((int)(i+(long)k));
            }
            i = j+value.length();
        }
        return '$';
    }
    public static int getLastIndex(String s, int i){
        int n = s.length();
        while(i < n && !Character.isDigit(s.charAt(i)))
            i++;
        return i;
    }
    public static String getFrequency(String s, int i){
        int n = s.length(), beg = i;
        while(i < n && Character.isDigit(s.charAt(i)))
            i++;
        return s.substring(beg, i);
    }
}
