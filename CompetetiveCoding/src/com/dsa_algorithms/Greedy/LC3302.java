package com.dsa_algorithms.Greedy;

public class LC3302 {
    /*
    for lexicographically smallest result I want to match from start
    if matches - good we're done
    if not then if I know there is index > i which matches whit j+1, then it's safe to match index character otherwise we cant
    to handle 2nd condition we need to have suffix pre computed.
    */
    public int[] validSequence(String word1, String word2) {
        int i, j, n = word1.length(), m = word2.length(), match = 0;
        int[] suffix = new int[m];
        int[] result = new int[m];

        for(i=n-1, j=m-1 ; i>=0 && j >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(j)) {
                suffix[j--] = i;
            }
        }
        for(i=0, j=0; i<n && j<m; i++) {
            if (word1.charAt(i) == word2.charAt(j) ||
                    (match == 0 && (j == m-1 || i < suffix[j+1]))) {
                match += word1.charAt(i) == word2.charAt(j) ? 0 : 1;
                result[j++] = i;
            }
        }
        return j == m ? result : new int[0];
    }
}
