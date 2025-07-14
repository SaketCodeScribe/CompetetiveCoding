package com.dsa_algorithms.practice;

import java.util.*;
import java.io.*;
public class AreaOfRectangle {
    static class Event implements Comparable<Event>{
        int y;
        int x1;
        int x2;
        int type;
        public Event(int y, int x1, int x2, int type){
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
        @Override
        public int compareTo(Event othr){
            if (this.y != othr.y){
                return Integer.compare(this.y, othr.y);
            }
            return Integer.compare(othr.type, this.type);
        }
    }
    static class SegmentTree{
        int[] xs;
        Map<Integer, Integer> map;
        int numElementaryInterval;
        int[] cnt, covered;

        public SegmentTree(int[][] rectangles){
            TreeSet<Integer> treeSet = new TreeSet<>();
            map = new HashMap<>();
            for(int[] rect:rectangles){
                treeSet.add(rect[0]);
                treeSet.add(rect[2]);
            }
            xs = treeSet.stream().mapToInt(val -> val).toArray();
            for(int i = 0; i<xs.length; i++){
                map.put(xs[i], i);
            }
            numElementaryInterval = xs.length-1;
            cnt = new int[numElementaryInterval <= 0 ? 1 : 4*numElementaryInterval];
            covered = new int[numElementaryInterval <= 0 ? 1 : 4*numElementaryInterval];
        }
        public void update(int xl, int xr, int type, int treeLeftIdx, int treeRightIdx, int pos){
            if (xr <= xs[treeLeftIdx] || xl >= xs[treeRightIdx+1]){
                return;
            }
            if (xl <= xs[treeLeftIdx] && xr >= xs[treeRightIdx+1]){
                cnt[pos] += type;
            }
            else{
                int mid = treeLeftIdx + (treeRightIdx - treeLeftIdx)/2;
                update(xl, xr, type, treeLeftIdx, mid, 2*pos+1);
                update(xl, xr, type, mid+1, treeRightIdx, 2*pos+2);
            }
            updateNode(pos, treeLeftIdx, treeRightIdx);
        }
        public void updateNode(int pos, int left, int right){
            if (cnt[pos] > 0){
                covered[pos] = xs[right+1] - xs[left];
            }
            else{
                if (left == right){
                    covered[pos] = 0;
                }
                else{
                    covered[pos] = covered[2*pos+1] + covered[2*pos+2];
                }
            }
        }
        public int peek(){
            return covered[0];
        }

    }
    public long rectangleArea(int[][] rectangles) {
        int i, j = 0, n = rectangles.length;
        Event[] events = new Event[2*n];

        for(i=0; i<n; i++){
            events[j++] = new Event(rectangles[i][1], rectangles[i][0], rectangles[i][2], 1);
            events[j++] = new Event(rectangles[i][3], rectangles[i][0], rectangles[i][2], -1);
        }
        Arrays.sort(events);
        SegmentTree segmentTree = new SegmentTree(rectangles);

        i = 0;
        long prevY = -1, currY = -1;
        long totarea = 0;
        while(i < 2*n){
            Event event = events[i];
            currY = event.y;
            long combinedLength = segmentTree.peek();
            totarea += ((currY-prevY)*combinedLength);
            segmentTree.update(event.x1, event.x2, event.type, 0, segmentTree.numElementaryInterval-1, 0);
            prevY = currY;
            i++;
        }
        return totarea;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of rectangles
        int n = Integer.parseInt(br.readLine());
        int[][] rectangles = new int[n][4];

        // Read each rectangle's coordinates
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                rectangles[i][j] = Integer.parseInt(line[j]);
            }
        }
        AreaOfRectangle obj = new AreaOfRectangle();
        System.out.println(obj.rectangleArea(rectangles));
    }
}
