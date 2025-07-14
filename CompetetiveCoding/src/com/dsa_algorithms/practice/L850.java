package com.dsa_algorithms.practice;

import java.util.*;

public class L850 {
    static class Cord{
        int xstart, y, xend, type; // type = 1 : start, type = -1 : end
        public Cord(int a, int b, int c, int t){
            xstart = a;
            xend = b;
            y = c;
            type = t;
        }
    }
    static class SegmentTree{
        int[] cords;
        int[] count;
        int[] covered;
        Map<Integer, Integer> cordMap;
        int length; // range of the nodes in terms of cord compression

        public SegmentTree(int[][] rectangles){
            TreeSet<Integer> treeSet = new TreeSet<>();
            cordMap = new HashMap<>();
            for(int[] rectangle:rectangles){
                treeSet.add(rectangle[0]);
                treeSet.add(rectangle[2]);
            }
            cords = treeSet.stream().mapToInt(val -> val).toArray();
            int length = cords.length;
            for(int i = 0; i< length; i++){
                cordMap.put(cords[i], i);
            }
            length = cords.length-1;
            count = new int[4*length];
            covered = new int[4*length];
        }

        public void update(int lq, int rq, int type, int start, int end, int pos) {
            int lq1 = cordMap.get(lq), rq1 = cordMap.get(rq);
            if (end <= lq1 || start >= rq1){
                return;
            }
            if ((lq1 <= start && rq1 >= end) || (lq1 == rq1)){
                count[pos] += type;
                return;
            }
            int mid = start+(end-start)/2;
            update(lq, rq, type, start, mid, 2*pos+1);
            update(lq, rq, type, mid+1, end, 2*pos+2);
            pushUp(pos, start, end);
        }

        private void pushUp(int pos, int left, int right) {
            if (count[pos] > 0){
                covered[pos] = cords[right+1] - cords[left];
            }
            else if (left == right) {
                covered[pos] = 0;
            }
            else{
                covered[pos] = covered[2*pos+1] + covered[2*pos+2];
            }
        }

        public int peek() {
            return covered[0];
        }
    }
    public int rectangleArea(int[][] rectangles) {
        int i = 0, n = rectangles.length;
        Cord[] rectCord = new Cord[n];
        SegmentTree segmentTree = new SegmentTree(rectangles);

        for(int[] cord:rectangles){
            rectCord[i++] = new Cord(cord[0], cord[2], cord[1], 1);
            rectCord[i++] = new Cord(cord[0], cord[2], cord[3], -1);
        }

        Arrays.sort(rectCord, (a,b) -> Integer.compare(a.y, b.y));

        int currY, prevY, combinedLen = 0, area = 0;
        prevY = -1;
        i = 0;
        while(i < rectCord.length){
            currY = rectCord[i].y;
            if (prevY >= 0) {
                area += (currY - prevY)*combinedLen;
            }
            segmentTree.update(rectCord[i].xstart, rectCord[i].xend, rectCord[i].type, 0, segmentTree.length-1, 0);
            combinedLen = segmentTree.peek();
            prevY = currY;
        }
        return area;
     }
}
