package com.dsa_algorithms.String;

public class StableNumber {
    static String findStableNumber(int k, String s) {
        // Write your code here.
        int i, n = s.length();
        if (k >= n)
            return s;
        char[] temp = new char[n];
        for(i=0; i<n; i++)
            temp[i] = s.charAt(i%k);
        String ans = new String(temp);
        if (ans.compareTo(s) >= 0)
            return ans;
        i = k-1;
        while(i >= 0){
            if (temp[i] != '9'){
                temp[i] = (char)((temp[i]-'0')+1+'0');
                i++;
                break;
            }
            i--;
        }
        while(i < k)
            temp[i++] = '0';
        for(i=k; i<n; i++)
            temp[i] = temp[i%k];
        return new String(temp);
    }
}
