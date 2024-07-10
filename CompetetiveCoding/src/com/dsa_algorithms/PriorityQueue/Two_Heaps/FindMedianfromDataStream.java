package com.dsa_algorithms.PriorityQueue.Two_Heaps;

import java.util.*;

public class FindMedianfromDataStream {
    PriorityQueue<Integer> minHeap, maxHeap;
    int size;

    public FindMedianfromDataStream() {
        minHeap = new PriorityQueue<Integer>(); // n/2(even & odd)
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); // minheap+1 (odd), minheap(even)
        size = 0;
    }

    public void addNum(int num) {
        size++;
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);
        if (maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if((size&1) > 0)
            return maxHeap.peek();
        return (minHeap.peek()+maxHeap.peek())/2.0;
    }
}
