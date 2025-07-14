package com.dsa_algorithms.Contest.weekly.weekly457;

import java.util.*;
public class Solution1 {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int i, n = code.length;
        Map<String, TreeSet<String>> map = new LinkedHashMap<>();
        List<String> ans = new ArrayList<>();

        for(i=0; i<n; i++){
            String business = businessLine[i];
            if (code[i].length() > 0 && isActive[i] && (business.equals("electronics") || business.equals("grocery") || business.equals("pharmacy") || business.equals("restaurant"))){
                boolean flag = true;
                for(char ch:code[i].toCharArray()){
                    if (!(ch == '_' || Character.isAlphabetic(ch) || Character.isDigit(ch))){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    map.computeIfAbsent(business, x-> new TreeSet<>()).add(code[i]);
                }
            }
        }
        for(TreeSet<String> val:map.values()){
            ans.addAll(val);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution1 obj = new Solution1();
    }
}
