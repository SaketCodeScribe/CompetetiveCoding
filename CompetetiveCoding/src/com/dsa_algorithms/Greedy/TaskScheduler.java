package com.dsa_algorithms.Greedy;

import java.util.Arrays;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int i = 0, len = 0, j, k, ans = 0;
        Integer[] freq = new Integer[26];

        for(char task:tasks){
            int ind = task-'a';
            freq[ind]++;
            if (freq[ind] == 1)
                len++;
        }
        Arrays.sort(freq, (a, b) -> b-a);
        while(i<len){
            j = 0;
            k = n;
            while (k-- >= 0){
                ans++;
                if (freq[j] > 0){
                    freq[j]--;
                    if (freq[j] == 0)
                        i++;
                }
                j++;
            }
            Arrays.sort(freq, (a,b) -> (b-a));
        }

        return ans;
    }

    public static void main(String[] args) {
        String ip = "192.168.100..0";
        String pattern = "((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        System.out.println(ip.matches(pattern));
    }
}
