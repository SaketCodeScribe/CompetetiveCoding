package com.dsa_algorithms.practice;

public class Google1 {
    public static void main(String[] args) {
        String s1 = "The boy goes to the hospital", s2 = "The cute little boy goes to the hospital";
        String[] a = s1.split(" "), b = s2.split(" ");

        System.out.println(helper(a, b) || helper(b, a));
    }
    private static boolean helper(String[] s1, String[] s2){
        int i, j, m = s1.length, n = s2.length;
        boolean[] curr, prev = new boolean[n+1];
        prev[0] = true;

        for(i=1; i<=m; i++){
            curr = new boolean[n+1];
            for(j=1; j<=n; j++){
                curr[j] = curr[j-1];
                if (s1[i-1].equals(s2[j-1])){
                    curr[j] |= prev[j-1];
                }
            }
            prev = curr;
        }
        return prev[n];
    }
}
