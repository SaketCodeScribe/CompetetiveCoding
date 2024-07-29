package com.dsa_algorithms.TwoPointer.pointers_for_every_input;

public class VersionCompare {
    public int compareVersion(String version1, String version2) {
        int i, j, m = version1.length(), n = version2.length();
        int a = 0, b = 0;
        i = j = 0;

        while(i < m || j < n){
            a = b = 0;
            while(i < m && version1.charAt(i) != '.')
                a = a*10+(version1.charAt(i++)-'0');
            while(j < n && version2.charAt(j) != '.')
                b = b*10+(version2.charAt(j++)-'0');
            if (a < b)
                return -1;
            if (a > b)
                return 1;
            i++; j++;
        }
        return 0;
    }
}
