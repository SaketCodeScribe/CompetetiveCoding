package com.dsa_algorithms.TwoPointer;

public class LC686 {

    public int countBinarySubstrings(String s) {
        int n = s.length(), i = 0, cnt = 0, previousGroup = 0, currentGroup = 0;

        while(i < n){
            currentGroup = countCharacter(s, n, s.charAt(i), i);
            i += currentGroup;
            cnt += Math.min(previousGroup, currentGroup);
            previousGroup = currentGroup;
        }
        return cnt;
    }

    private int countCharacter(String s, int n, char ch, int index){
        int cnt = 0;

        while(index < n && s.charAt(index) == ch){
            index++;
            cnt++;
        }
        return cnt;
    }
}
