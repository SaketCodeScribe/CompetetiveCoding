package com.dsa_algorithms.practice;

import java.util.*;

public class L490 {
    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o){
            if (o == this){
                return true;
            }
            if (o instanceof Point o1){
                return this.x == o1.x && this.y == o1.y;
            }
            return false;
        }
        @Override
        public int hashCode(){
            return (this.x+","+this.y).hashCode();
        }
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int i, j, m = maze.length, n = maze[0].length;
        List<int[][]> row = new ArrayList<>(), col = new ArrayList<>();

        for(i=0; i<m; i++){
            int[] left = new int[n], right = new int[n];
            for(j=0; j<n; j++){
                left[j] = j > 0 ? left[j-1] : j;
                if (maze[i][j] == 1){
                    left[j] = j;
                }
            }
            for(j=n-1; j>=0; j--){
                right[j] = j < n-1 ? right[j+1] : j;
                if (maze[i][j] == 1){
                    right[j] = j;
                }
            }
            row.add(new int[][]{left, right});
        }
        for(i=0; i<n; i++){
            int[] left = new int[m], right = new int[m];
            for(j=0; j<m; j++){
                left[j] = j > 0 ? left[j-1] : j;
                if (maze[i][j] == 1){
                    left[j] = j;
                }
            }
            for(j=m-1; j>=0; j--){
                right[j] = j < m-1 ? right[j+1] : j;
                if (maze[i][j] == 1){
                    right[j] = j;
                }
            }
            col.add(new int[][]{left, right});
        }
        Queue<Point> queue = new LinkedList<>();
        Set<Point> set = new HashSet<>();
        Point src = new Point(start[0], start[1]);
        Point dest = new Point(destination[0], destination[1]);
        queue.offer(src);
        set.add(src);

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0){
                Point node = queue.poll();
                if (node.equals(dest)){
                    return true;
                }
                int x = node.x;
                int[] rowLeft = row.get(x)[0], rowRight = row.get(x)[1];
                int y = node.y;
                int[] colUp = col.get(y)[0], colDown = col.get(y)[1];

                int closestWallFromLeft = rowLeft[x];
                Point left = new Point(x, closestWallFromLeft);
                if (closestWallFromLeft < y && !set.contains(left)){
                    queue.offer(left);
                    set.add(left);
                }
                int closestWallFromRight = rowRight[x];
                Point right = new Point(x, closestWallFromRight);
                if (closestWallFromRight > y && !set.contains(right)){
                    queue.offer(right);
                    set.add(right);
                }
                int closestWallFromUp = colUp[y];
                Point up = new Point(x, closestWallFromUp);
                if (closestWallFromUp < x && !set.contains(up)){
                    queue.offer(up);
                    set.add(up);
                }
                int closestWallFromDown = colDown[y];
                Point down = new Point(x, closestWallFromDown);
                if (closestWallFromDown > x && !set.contains(down)){
                    queue.offer(down);
                    set.add(down);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L490 obj = new L490();
    }
}
