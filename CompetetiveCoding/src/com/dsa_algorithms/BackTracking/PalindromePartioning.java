package com.dsa_algorithms.BackTracking;
import java.util.*;

public class PalindromePartioning {
    static List<List<String>> ans;
    public static List<List<String>> partition(String s) {
        // Write your code here.
        ans = new ArrayList<>();
        return palPartition(0, s.length(), new ArrayList<>(), s);
    }

    public static List<List<String>> palPartition(int i, int n, List<String> temp, String s){
        if (i >= n){
            ans.add(new ArrayList<>(temp));
            return ans;
        }
        StringBuilder str = new StringBuilder();
        for(int j=i; j<n; j++){
            str.append(s.charAt(j));
            if (isPalindrome(str)){
                temp.add(str.toString());
                palPartition(j+1, n, temp, s);
                temp.remove(temp.size()-1);
            }
        }
        return ans;
    }
    public static boolean isPalindrome(StringBuilder s){
        int i=0, n = s.length();

        while(i < n/2){
            if(s.charAt(i) != s.charAt(n-i-1))
                return false;
            i++;
        }
        return true;
    }
}
