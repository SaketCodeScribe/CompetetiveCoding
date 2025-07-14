package com.dsa_algorithms.Interview;

import java.util.*;

/*
Given are N cities and M roads that travel between the given pair of cities and time it takes to
travel that road. Also we are given a list of favourite cities L and a source city S . we have to
tell the favourite city which can be reached from source city the fastest(in minimum time)
 */
public class Solution4 {
    static class City{
        int time;
        int city;
        public City(int city, int time){
            this.time = time;
            this.city = city;
        }
    }
    public int timeToReachFavoriteCity(List<List<List<Integer>>> adj, int source,
                                       List<Integer> favoriteCity, int n){
        PriorityQueue<City> pq = new PriorityQueue<>();
        int[] times = new int[n];
        Set<Integer> set = new HashSet<>();
        Arrays.fill(times, Integer.MAX_VALUE);
        set.addAll(favoriteCity);
        pq.offer(new City(source, 0));

        while(!pq.isEmpty()){
            City node = pq.poll();
            int city = node.city;
            int timeToReach = node.time;
            if (set.contains(city)){
                return timeToReach;
            }
            for(List<Integer> neighbor:adj.get(city)){
                int child = neighbor.get(0), time = neighbor.get(1);
                if (times[child] > timeToReach+time){
                    times[child] = timeToReach+time;
                    pq.offer(new City(child, times[child]));
                }
            }
        }
        return -1;
    }

}
