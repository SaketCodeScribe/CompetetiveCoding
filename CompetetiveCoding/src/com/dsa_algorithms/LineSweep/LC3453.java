package com.dsa_algorithms.LineSweep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC3453 {
    static class Event implements Comparable<Event>{
        int length, y;
        boolean isEnd;
        public Event(int y, int length, boolean isEnd){
            this.y = y;
            this.length = length;
            this.isEnd = isEnd;
        }
        public int compareTo(Event other){
            int compare = Integer.compare(this.y, other.y);
            return compare == 0 ? Integer.compare(this.length, other.length) : compare;
        }
        @Override
        public String toString(){
            return "["+y+", "+length+", "+isEnd+"]";
        }
    }
    public double separateSquares(int[][] squares) {
        int i = 0, n = 2*squares.length, prevY = 0, currY = 0, length;
        double halfArea = getHalfArea(squares), combinedArea = 0, base = 0;
        List<Event> events = init(squares);

        while(i < n){
            Event event = events.get(i);
            length = event.length;
            currY = event.y;
            boolean isEnd = event.isEnd;
            combinedArea += (double)base * (currY - prevY);
            if (combinedArea >= halfArea){
                return currY - (combinedArea - halfArea) / base;
            }
            if (!isEnd) {
                base += length;
            }
            else base -= length;
            prevY = currY;
            i++;
        }
        return 0.0;
    }
    private double getHalfArea(int[][] squares){
        double area = 0;

        for(int[] square:squares){
            area += (double)square[2]*(double)square[2];
        }
        return area / 2;
    }
    private List<Event> init(int[][] squares){
        List<Event> events = new ArrayList<>();
        for (int[] square:squares){
            events.add(new Event(square[1], square[2], false));
            events.add(new Event(square[1] + square[2], square[2], true));
        }
        Collections.sort(events);
        return events;
    }
}
