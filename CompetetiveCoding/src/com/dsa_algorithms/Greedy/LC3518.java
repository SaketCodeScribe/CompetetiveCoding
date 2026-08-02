package com.dsa_algorithms.Greedy;

public class LC3518 {
    private final long CAP = (long)(1e7);
    public String smallestPalindrome(String s, int K) {
        int i = 0, halfLen;
        long k = K;
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        updateFrequencyMap(s, freq);
        char mid = halfFreqAndGetOddCharacter(freq);
        halfLen = getHalfLength(freq);

        if (multinomial(freq, halfLen) < k) return "";

        for(int pos = 0; pos < halfLen; pos++){
            i = 0;
            while(i < 26) {
                if (freq[i] > 0) {
                    freq[i]--;
                    long ways = multinomial(freq, halfLen - pos - 1);

                    if (k <= ways) {
                        sb.append((char)(i+'a'));
                        break;
                    } else {
                        k -= ways;
                        freq[i]++;
                    }
                }
                i++;
            }
        }
        if (k > 1) return "";
        String first = sb.toString();
        String second = sb.reverse().toString();
        return first + (mid != 0 ? mid : "") + second;
    }
    private int getHalfLength(int[] freq) {
        int cnt = 0;
        for(int f:freq) {
            cnt += f;
        }
        return cnt;
    }
    private long multinomial(int[] freq, int n) {
        long res = 1;
        int used = 0;

        for(int c=0; c<26; c++) {
            for(int f=1; f<=freq[c]; f++) {
                used++;
                res = res * used / f;
                if (res > CAP) return CAP;
            }
        }
        return res;
    }
    private void updateFrequencyMap(String s, int[] freq) {
        for(char ch:s.toCharArray()) {
            freq[ch-'a']++;
        }
    }
    private char halfFreqAndGetOddCharacter(int[] freq) {
        char mid = 0;
        for(int i=0; i<26; i++) {
            if (freq[i]%2 != 0) mid = (char)(i + 'a');
            freq[i] /= 2;
        }
        return mid;
    }

    // optimization of multinomial
    /*
    import java.math.BigInteger;

class Solution {
    public String smallestPalindrome(String s, int K) {
        int i = 0, halfLen;
        BigInteger k = BigInteger.valueOf(K);
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        updateFrequencyMap(s, freq);
        char mid = halfFreqAndGetOddCharacter(freq);
        halfLen = getHalfLength(freq);

        BigInteger ways = multinomial(freq, halfLen);
        if (ways.compareTo(k) < 0) return "";

        for(int pos = 0; pos < halfLen; pos++){
            int remaining = halfLen - pos;
            i = 0;
            while(i < 26) {
                if (freq[i] > 0) {
                    BigInteger waysWithI = ways
                            .multiply(BigInteger.valueOf(freq[i]))
                            .divide(BigInteger.valueOf(remaining));

                    if (k.compareTo(waysWithI) <= 0) {
                        sb.append((char)(i+'a'));
                        freq[i]--;
                        ways = waysWithI;
                        break;
                    } else {
                        k = k.subtract(waysWithI);
                    }
                }
                i++;
            }
        }
        String first = sb.toString();
        String second = sb.reverse().toString();
        return first + (mid != 0 ? mid : "") + second;
    }
    private int getHalfLength(int[] freq) {
        int cnt = 0;
        for(int f:freq) {
            cnt += f;
        }
        return cnt;
    }
    private BigInteger multinomial(int[] freq, int n) {
        BigInteger res = BigInteger.ONE;
        int used = 0;

        for(int c=0; c<26; c++) {
            for(int f=1; f<=freq[c]; f++) {
                used++;
                res = res.multiply(BigInteger.valueOf(used))
                         .divide(BigInteger.valueOf(f));
            }
        }
        return res;
    }
    private void updateFrequencyMap(String s, int[] freq) {
        for(char ch:s.toCharArray()) {
            freq[ch-'a']++;
        }
    }
    private char halfFreqAndGetOddCharacter(int[] freq) {
        char mid = 0;
        for(int i=0; i<26; i++) {
            if (freq[i]%2 != 0) mid = (char)(i + 'a');
            freq[i] /= 2;
        }
        return mid;
    }
}
     */
}
