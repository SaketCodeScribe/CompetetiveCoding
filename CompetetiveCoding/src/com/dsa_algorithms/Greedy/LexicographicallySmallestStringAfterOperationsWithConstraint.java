package com.dsa_algorithms.Greedy;

public class LexicographicallySmallestStringAfterOperationsWithConstraint {
    public String getSmallestString(String s, int k) {
        int n = s.length(), i = 0;
        StringBuilder ans = new StringBuilder();

        while (i < n && k > 0){
            int dist = Math.min(s.charAt(i)-'a', 26-(s.charAt(i)-'a'));
            if (dist <= k){
                ans.append('a');
                k -= dist;
            }
            else{
                ans.append((char)('a'+((s.charAt(i)-'a')-k)));
                k = 0;
            }
            i++;
        }
        while(i < n)
            ans.append(s.charAt(i++));
        return ans.toString();
    }
}
