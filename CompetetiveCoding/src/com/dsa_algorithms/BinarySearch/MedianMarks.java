package com.dsa_algorithms.BinarySearch;

import java.util.*;
import java.util.stream.IntStream;

public class MedianMarks {
    static List<Pair> arr;
    static class Pair{
        int low, high;
        public Pair(int low, int high){
            this.low = low;
            this.high = high;
        }
    }

    static int medianMarks(int x, int[] l, int[] r) {
        int low = 1, high = (int)1e5, mid, ans = -1;
        arr = new ArrayList<>();

        IntStream.range(0, l.length).forEach(i -> arr.add(new Pair(l[i], r[i])));

        Collections.sort(arr, (a, b) -> a.low-b.low);

        while(low <= high){
            mid = (low+high) >> 1;
            if (isPossible(mid, x)){
                ans = mid;
                low = mid+1;
            }
            else
                high = mid-1;
        }
        return ans;
    }

    static boolean isPossible(int median, int x){
        int i, cnt = 0, marks = 0, n = arr.size();
        Stack<Integer> stack = new Stack<>();

        for(i=0; i<n; i++){
            if (arr.get(i).high < median)
                marks += arr.get(i).low;
            else if (arr.get(i).low >= median){
                cnt++;
                marks += arr.get(i).low;
            }
            else
                stack.push(arr.get(i).low);
        }
        i = Math.max(0, (n+1)/2-cnt);

        if (i > stack.size())
            return false;

        while(i > 0){
            marks += median;
            stack.pop();
            i--;
        }
        while(!stack.isEmpty())
            marks += stack.pop();
        return marks <= x;
    }
}
