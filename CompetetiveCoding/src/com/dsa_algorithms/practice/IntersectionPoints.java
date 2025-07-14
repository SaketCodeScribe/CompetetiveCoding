package com.dsa_algorithms.practice;

import java.util.*;

public class IntersectionPoints {
    private static final int shift = 1_000_000;
    static class Event implements Comparable<Event>{
        long y, type, x1, x2;

        public Event(long y, long type, long x1, long x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }

        @Override
        public int compareTo(Event o) {
            if (this.y != o.y){
                return Long.compare(this.y, o.y);
            }
            return Long.compare(this.x1, o.x1);
        }
    }
    static class SegmentTree{
        long[] tree;

        public SegmentTree(int n) {
            this.tree = new long[4*n];
        }

        public void update(int treeLeftIndex, int treeRightIndex, int type, int index, int pos){
            if (treeLeftIndex == treeRightIndex){
                tree[pos] += type;
                return;
            }
            int mid = treeLeftIndex + (treeRightIndex-treeLeftIndex)/2;
            if (index <= mid) {
                update(treeLeftIndex, mid, type, index, 2 * pos + 1);
            }
            else {
                update(mid + 1, treeRightIndex, type, index, 2 * pos + 2);
            }
            tree[pos] = tree[2*pos+1] + tree[2*pos+2];
        }

        public long count(int treeLeftIndex, int treeRightIndex, int lq, int rq, int pos) {
            if (lq >= treeRightIndex || rq <= treeLeftIndex){
                return 0;
            }
            if (lq <= treeLeftIndex && rq >= treeRightIndex){
                return tree[pos];
            }
            int mid = treeLeftIndex + (treeRightIndex-treeLeftIndex)/2;
            long leftVal = count(treeLeftIndex, mid, lq, rq, 2*pos+1);
            long rightVal = count(mid+1, treeRightIndex, lq, rq, 2*pos+2);
            return leftVal+rightVal;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of line segments
        int n = scanner.nextInt();
        List<Event> events = new ArrayList<>();
        Set<String> set = new HashSet<>();
        long xMax = Integer.MIN_VALUE, xMin = Integer.MAX_VALUE;

        // Loop to read each line segment
        for (int i = 0; i < n; i++) {
            long x1 = scanner.nextInt();
            long y1 = scanner.nextInt();
            long x2 = scanner.nextInt();
            long y2 = scanner.nextInt();
            String key = x1+","+y1+","+Math.abs(distSquare(x1, y1, x2, y2));
            if (set.contains(key)){
                continue;
            }
            set.add(key);
            if (x1 == x2){
                events.add(new Event(Math.min(y1, y2)+shift, 1, x1+shift, x1+shift));
                events.add(new Event(Math.max(y1, y2)+shift, -1, x1+shift, x1+shift));
            }
            else{
                events.add(new Event(y1+shift, 2, Math.min(x1, x2)+shift, Math.max(x1, x2)+shift));
            }
            xMax = Math.max(xMax, Math.max(x1,x2)+shift);
            xMin = Math.min(xMin, Math.min(x1,x2)+shift);
        }
        Collections.sort(events);

        SegmentTree tree = new SegmentTree((int)xMax);

        long ans = 0;

        for(Event event:events){
            int x1 = (int) event.x1, x2 = (int) event.x2, type = (int) event.type;

            if (type < 2){
                tree.update((int)xMin, (int)xMax, type, x1, 0);
            }
            else{
                ans += tree.count((int)xMin, (int)xMax, x1, x2-1, 0);
            }
        }
        System.out.println(ans);
        scanner.close();
    }

    private static long distSquare(long x1, long y1, long x2, long y2) {
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
}
