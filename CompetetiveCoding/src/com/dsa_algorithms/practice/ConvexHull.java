package com.dsa_algorithms.practice;

import java.util.*;

public class ConvexHull {
    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x != o.x) {
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.y, o.y);
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }

        Collections.sort(points);

        Point a = points.get(0), b = points.get(points.size() - 1);

        ArrayDeque<Point> deque = new ArrayDeque<>();
        for (Point point : points) {
            if (pointLieOnConvexHull(a, b, point) < 0) {
                continue;
            }
            if (deque.size() > 1) {
                resolveConvexHull(deque, point);
            }
            deque.addLast(point);
        }
        deque.pollLast();
        deque.pollFirst();
        List<Point> convexHull = new ArrayList<>(deque);
        deque = new ArrayDeque<>();
        for (int i=points.size()-1; i>=0; i--) {
            Point point = points.get(i);
            if (pointLieOnConvexHull(b, a, point) < 0 || convexHull.contains(point)) {
                continue;
            }
            if (deque.size() > 1) {
                resolveConvexHull(deque, point);
            }
            deque.addLast(point);
        }
        convexHull.addAll(deque);
        System.out.println(convexHull.size());
        convexHull.forEach(System.out::println);
    }

    private static void resolveConvexHull(ArrayDeque<Point> deque, Point point) {
        while (deque.size() > 1) {
            Point point1 = deque.pollLast();
            int isInside = pointLieOnConvexHull(deque.peekLast(), point1, point);
            if (isInside <= 0) {
                deque.addLast(point1);
                break;
            }
        }
    }

    // Uses cross product to determine which side the point lies on
    private static int pointLieOnConvexHull(Point a, Point b, Point c) {
        long x1 = b.x - a.x;
        long y1 = b.y - a.y;
        long x2 = c.x - a.x;
        long y2 = c.y - a.y;
        long cross = x1 * y2 - y1 * x2;
        return cross == 0 ? 0 : (cross > 0 ? 1 : -1);
    }
}
