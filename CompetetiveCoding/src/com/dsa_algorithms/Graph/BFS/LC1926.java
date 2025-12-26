package com.dsa_algorithms.Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length, steps = 0;
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        while(!queue.isEmpty()){
            int size = queue.size();
            steps++;
            while(size-- > 0){
                int[] cord = queue.poll();
                for(int[] direction:directions){
                    assert cord != null;
                    int x = cord[0] + direction[0], y = cord[1] + direction[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.'){
                        if (x == 0 || x == m-1 || y == 0 || y == n-1){
                            return steps;
                        }
                        queue.offer(new int[]{x, y});
                        maze[x][y] = '+';
                    }
                }
            }
        }
        return -1;
    }
}
