package com.dsa_algorithms.Greedy;

import java.util.*;

public class ReplaceQuestionMarksinStringtoMinimizeItsValue {
    public String minimizeStringValue(String s) {
        int n = s.length(), i=0;
        StringBuilder ans = new StringBuilder();
        List<Character> chars = new ArrayList<>();
        Integer[][] freq = new Integer[26][2];

        for (i = 0; i < 26; i++) {
            freq[i][0] = i;
            freq[i][1] = 0;
        }

        for (char ch : s.toCharArray()) {
            if (ch != '?') {
                freq[ch - 'a'][1]++;
            }
        }
        Arrays.sort(freq, (a, b) -> a[1].equals(b[1]) ? a[0] - b[0] : a[1] - b[1]);
        for(char ch:s.toCharArray()){
            if (ch == '?'){
                chars.add((char)(freq[0][0]+'a'));
                freq[0][1]++;
                Arrays.sort(freq, (a, b) -> a[1].equals(b[1]) ? a[0] - b[0] : a[1] - b[1]);
            }
        }
        Collections.sort(chars);
        i = 0;
        for(char ch:s.toCharArray()){
            if (ch != '?')
                ans.append(ch);
            else
                ans.append(chars.get(i++));
        }
        return ans.toString();
    }
}
