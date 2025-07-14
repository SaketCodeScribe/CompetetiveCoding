package com.dsa_algorithms.practice;

import java.util.*;

public class L3453 {
    /*
        1. using bs with precision
     */
    public double separateSquares(int[][] squares) {
        double total = 0, low = Long.MAX_VALUE, high = Long.MIN_VALUE, mid, ans = 0;
        Arrays.sort(squares, (a, b) -> Integer.compare(a[1], b[1]));

        for(int[] square:squares){
            double len = square[2];
            total += len * len;
            low = Math.min(low, square[1]);
            high = Math.max(high, square[1]+square[2]);
        }
        total /= 2;
        while(high-low >= 1e-5){
            mid = low + (high-low)/2;
            if (calculateArea(squares, mid) >= total){
                ans = mid;
                high = mid;
            }
            else{
                low = mid;
            }
        }
        return ans;
    }

    private double calculateArea(int[][] squares, double mid) {
        double area = 0;
        for (int[] square : squares) {
            double len = square[2];
            double topY = square[1] + len, bottomY = square[1];
            if (bottomY >= mid) {
                continue;
            }
            if (topY <= mid) {
                area += len * len;
            } else {
                area += (mid - bottomY) * len;
            }
        }
        return area;
    }

    /*
        2. using line sweep
     */
    static class Event implements Comparable<Event>{
        int y;
        boolean isEnd;
        int len;
        public Event(int y, boolean isEnd, int len){
            this.y = y;
            this.isEnd = isEnd;
            this.len = len;
        }
        @Override
        public int compareTo(Event obj){
            if (this.y != obj.y){
                return Integer.compare(this.y, obj.y);
            }
            return this.isEnd ? -1 : 1;
        }
    }
    private double seperateSquaresII(int[][] squares){
        int i, n = squares.length;
        List<Event> events = new ArrayList<>();
        double totArea = 0, currAra = 0;

        for(i=0; i<n; i++){
            events.add(new Event(squares[i][1], false, squares[i][2]));
            events.add(new Event(squares[i][1]+squares[i][2], true, squares[i][2]));
            totArea += (long)squares[i][2]*(long)squares[i][2];
        }
        Collections.sort(events);
        n = events.size();
        i=0;
        int prevY = events.get(0).y, combinedWidth = events.get(0).len;
        double combinedArea = 0;

        for(i=1; i<n; i++){
            int currY = events.get(i).y;
            double currArea = (long)(currY-prevY)*combinedWidth;

            if (combinedArea + currArea >= totArea/2.0){
                double diff = totArea/2.0 - combinedArea;
                if (diff == 0){
                    return currY;
                }
                return prevY + diff/combinedWidth;
            }
            combinedArea += currArea;
            combinedWidth += events.get(i).isEnd ? -events.get(i).len : events.get(i).len;
            prevY = currY;
        }
        return 0;
    }

    public static void main(String[] args) {
        L3453 obj = new L3453();
        System.out.println(obj.seperateSquaresII(new int[][]{{0, 0, 2}, {1, 1, 1}}));
    }

}
