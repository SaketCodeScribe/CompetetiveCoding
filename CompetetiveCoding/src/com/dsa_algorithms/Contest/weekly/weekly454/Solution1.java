package com.dsa_algorithms.Contest.weekly.weekly454;

public class Solution1 {
    public String generateTag(String caption) {
        int i, n = caption.length();
        caption.trim();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(i=0; i<n; i++){
            char ch = caption.charAt(i);
            if (ch == ' '){
                flag = true;
            }
            else if (Character.isAlphabetic(ch)){
                if (flag) {
                    sb.append(Character.toUpperCase(ch));
                }
                else{
                    sb.append(ch);
                }
            }
        }
        return sb.isEmpty() ? "" : "#"+sb.substring(0,Math.min(100, sb.length()));
    }
}
