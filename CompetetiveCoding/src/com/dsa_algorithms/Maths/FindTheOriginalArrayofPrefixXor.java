package com.dsa_algorithms.Maths;

public class FindTheOriginalArrayofPrefixXor {
    public int[] findArray(int[] pref) {
        int i, n = pref.length;

        for(i=n-1; i>0; i--)
            pref[i] = pref[i]^pref[i-1];
        return pref;
    }
}
