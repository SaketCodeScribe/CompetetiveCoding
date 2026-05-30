package com.dsa_algorithms.SlidingWindow;

public class LC76 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length(), count = 0, i = 0, j = 0;
        if (m == 0 || n == 0){
            return "";
        }
        int[] freq = new int[52];
        int[] freqInWindow = new int[52];
        int unique = extractFrequency(t, freq);
        int low = 0, high = Integer.MAX_VALUE;

        while(j < m || i < m){
            int slide;
            if ((slide = slideThroughWindow(s, i, j, count, unique, freq, freqInWindow)) != -1){
                count--;
                i = slide;
                if (high - low > j - i + 1){
                    low = i-1;
                    high = j;
                }
            }
            if (j < m){
                int curr = getIndex(s.charAt(j));
                freqInWindow[curr]++;
                if (freq[curr] > 0 && freqInWindow[curr] == freq[curr]){
                    count++;
                }
                j++;
            }
            else break;
        }
        return high == Integer.MAX_VALUE ? "" : s.substring(low, high);
    }
    private int extractFrequency(String word, int[] freq){
        int unique = 0;
        for(char ch:word.toCharArray()){
            int index = getIndex(ch);
            freq[index]++;
            if (freq[index] == 1){
                unique++;
            }
        }
        return unique;
    }

    private int getIndex(Character ch){
        return Character.isUpperCase(ch) ? (ch-'A')+26 : ch-'a';
    }

    private int slideThroughWindow(String s, int i, int j, int count, int unique, int[] freq, int[] freqInWindow){
        if (count < unique){
            return -1;
        }
        int curr;
        while(i < j){
            curr = getIndex(s.charAt(i));
            freqInWindow[curr]--;
            i++;
            if (freq[curr] > 0 && freqInWindow[curr] < freq[curr]){
                break;
            }
        }
        return i;
    }
}
