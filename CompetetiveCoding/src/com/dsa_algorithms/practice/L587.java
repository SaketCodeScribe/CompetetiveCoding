package com.dsa_algorithms.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class L587 {
    static class Point implements Comparable<Point>{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x != o.x){
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.y, o.y);
        }
    }
    public int[][] outerTrees(int[][] trees) {
        Set<Point> convexHull = new HashSet<>();
        List<Point> points = new ArrayList<>();
        for(int[] tree:trees){
            points.add(new Point(tree[0], tree[1]));
        }
        Collections.sort(points);
        Point a = points.get(0), b = points.get(points.size()-1);
        ArrayDeque<Point> deque = new ArrayDeque<>();

        for(Point point:points){
            if (getRegionOfPoint(a,b, point) < 0){ // left of vector AB > 0
                continue;
            }
            if (deque.size() > 1){
                resolveThePointsOnConvexHull(deque, point);
            }
            deque.addLast(point);
        }
        deque.pollLast();
        deque.pollFirst();
        convexHull.addAll(deque);
        deque = new ArrayDeque<>();
        for(int i=points.size()-1; i>=0; i--){
            Point point = points.get(i);
            if (getRegionOfPoint(b,a, point) < 0 || convexHull.contains(point)){ // left of vector BA > 0
                continue;
            }
            if (deque.size() > 1){
                resolveThePointsOnConvexHull(deque, point);
            }
            deque.addLast(point);
        }
        convexHull.addAll(deque);
        return convexHull.stream().map(point -> new int[]{point.x, point.y}).toArray(int[][]::new);
    }

    private void resolveThePointsOnConvexHull(ArrayDeque<Point> deque, Point point) {
        while(deque.size() > 1){
            Point lastPoint = deque.pollLast();
            Point secondLastPoint = deque.peekLast();
            int regionOfPoint = getRegionOfPoint(secondLastPoint, lastPoint, point);
            if (regionOfPoint <= 0){
                deque.addLast(lastPoint);
                break;
            }
        }
    }

    private int getRegionOfPoint(Point a, Point b, Point c) {
        int x1 = b.x - a.x;
        int y1 = b.y - a.y;
        int x2 = c.x - a.x;
        int y2 = c.y - a.y;
        int crossProduct = x1 * y2 - x2 * y1;
        return crossProduct;
    }

    public static void main(String[] args) {
        L587 obj = new L587();
        System.out.println(obj.outerTrees(new int[][]{{1,2}, {2,2}, {4,2}}));
    }
}
