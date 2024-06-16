package com.dsa_algorithms.Greedy;

import java.util.*;
public class JobSequencingProblem {
    static class sortyByProfit implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            return a[1] != b[1] ? a[1]-b[1] : b[2]-a[2];
        }
    }
    public static int[] jobScheduling(int [][]jobs) {
        // Write your code here
        int i = 0, n = jobs.length;
        long profit = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(jobs, new sortyByProfit());
        while(i < n){
            if (jobs[i][1] > pq.size()){
                pq.add(jobs[i][2]);
                profit += jobs[i][2];
            }
            else if (jobs[i][2] > pq.peek()){
                profit += jobs[i][2]-pq.poll();
                pq.add(jobs[i][2]);
            }
            i++;
        }
        return new int[]{pq.size(), (int)profit};
    }
}
