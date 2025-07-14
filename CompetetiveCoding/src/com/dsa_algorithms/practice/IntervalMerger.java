package com.dsa_algorithms.practice;

import java.util.*;

public class IntervalMerger {

    /**
     * Represents a simple interval [start, end].
     */
    static class Interval {
        int start;
        int end; // exclusive

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    /**
     * Segment Tree to manage covered intervals and retrieve merged intervals.
     */
    static class SegmentTree {
        // `xs` stores the sorted unique coordinate points.
        // The segment tree operates on elementary intervals [xs[i], xs[i+1]).
        private int[] xs;
        private int numElementaryIntervals; // xs.length - 1

        // `count[pos]` stores how many active intervals currently cover the node's range.
        // Used for lazy propagation.
        private int[] count;

        // `covered[pos]` stores the total length of the segment tree node's range
        // that is currently covered by at least one interval.
        private int[] covered;

        // Map for coordinate compression: actual_coord -> compressed_index
        private Map<Integer, Integer> coordToIndexMap;
        // Array for reverse lookup: compressed_index -> actual_coord
        private int[] indexToCoordArray;

        /**
         * Constructor for the SegmentTree. Performs coordinate compression.
         *
         * @param allIntervals A list containing all initial and query intervals.
         */
        public SegmentTree(List<Interval> allIntervals) {
            Set<Integer> uniqueCoords = new TreeSet<>(); // Use TreeSet for sorted unique elements
            for (Interval interval : allIntervals) {
                uniqueCoords.add(interval.start);
                uniqueCoords.add(interval.end);
            }

            indexToCoordArray = uniqueCoords.stream().mapToInt(Integer::intValue).toArray();
            coordToIndexMap = new HashMap<>();
            for (int i = 0; i < indexToCoordArray.length; i++) {
                coordToIndexMap.put(indexToCoordArray[i], i);
            }

            this.xs = indexToCoordArray;
            this.numElementaryIntervals = xs.length - 1;

            // Handle edge case: if only one unique coordinate or no intervals, no elementary intervals.
            if (numElementaryIntervals < 0) {
                numElementaryIntervals = 0; // No intervals to cover
            }


            // Tree arrays need size 4 * numElementaryIntervals for a safe upper bound on memory.
            this.count = new int[4 * numElementaryIntervals];
            this.covered = new int[4 * numElementaryIntervals];
        }

        /**
         * Recalculates the `covered` length for a node based on its children's `covered` lengths.
         * This is called when `count[pos]` is 0, meaning this node itself is not fully covered by a lazy value.
         *
         * @param pos The current node's index in the segment tree arrays.
         * @param treeLeftIdx The left compressed index of the elementary interval range this node covers.
         * @param treeRightIdx The right compressed index of the elementary interval range this node covers.
         */
        private void pushUp(int pos, int treeLeftIdx, int treeRightIdx) {
            // If the current node (pos) has a positive count, it means its entire interval
            // [xs[treeLeftIdx], xs[treeRightIdx + 1]) is covered.
            if (count[pos] > 0) {
                covered[pos] = xs[treeRightIdx + 1] - xs[treeLeftIdx];
            } else {
                // If count[pos] is 0, this node isn't fully covered by its own lazy value.
                // We need to aggregate from its children.
                if (treeLeftIdx == treeRightIdx) {
                    // If it's a leaf node and count is 0, it covers nothing.
                    covered[pos] = 0;
                } else {
                    // For an internal node, its covered length is the sum of its children's covered lengths.
                    covered[pos] = covered[pos * 2 + 1] + covered[pos * 2 + 2];
                }
            }
        }

        /**
         * Updates the segment tree with a given interval [queryStart, queryEnd) by adding `type`.
         * `type` is typically +1 (for adding an interval).
         *
         * @param queryStart The start coordinate of the interval to update (actual value).
         * @param queryEnd The end coordinate of the interval to update (actual value).
         * @param type The value to add/subtract to the `count` of affected intervals (e.g., +1).
         * @param pos The current node's index in the segment tree arrays.
         * @param treeLeftIdx The left compressed index of the elementary interval range this node covers.
         * @param treeRightIdx The right compressed index of the elementary interval range this node covers.
         */
        public void update(int queryStart, int queryEnd, int type, int pos, int treeLeftIdx, int treeRightIdx) {
            // Convert actual query coordinates to compressed indices
            int qlIdx = coordToIndexMap.get(queryStart);
            int qrIdx = coordToIndexMap.get(queryEnd); // This is the end index of the interval *before* it, so exclusive.

            // No overlap: The current node's interval [xs[treeLeftIdx], xs[treeRightIdx + 1])
            // is completely outside the query range [queryStart, queryEnd).
            if (xs[treeRightIdx + 1] <= queryStart || xs[treeLeftIdx] >= queryEnd) {
                return;
            }

            // Full overlap: The query range completely covers the current node's interval.
            // Update `count` for this node directly.
            if (queryStart <= xs[treeLeftIdx] && xs[treeRightIdx + 1] <= queryEnd) {
                count[pos] += type;
            } else {
                // Partial overlap: The query range partially overlaps. Recurse into children.
                int mid = (treeLeftIdx + treeRightIdx) / 2;
                update(queryStart, queryEnd, type, pos * 2 + 1, treeLeftIdx, mid);    // Left child
                update(queryStart, queryEnd, type, pos * 2 + 2, mid + 1, treeRightIdx); // Right child
            }
            // After recursive calls (or if it was a full overlap), update the current node's `covered` length.
            pushUp(pos, treeLeftIdx, treeRightIdx);
        }

        /**
         * Traverses the segment tree to collect all currently merged (covered) intervals.
         *
         * @return A list of non-overlapping merged intervals.
         */
        public List<Interval> getMergedIntervals() {
            List<Interval> result = new ArrayList<>();
            if (numElementaryIntervals == 0) {
                return result; // No intervals to merge if no elementary intervals
            }
            findIntervalsRecursive(0, 0, numElementaryIntervals - 1, result);
            return result;
        }

        /**
         * Recursive helper to find and merge intervals.
         * It identifies contiguous segments where `covered` is non-zero.
         *
         * @param pos The current node's index.
         * @param treeLeftIdx The left compressed index of the node's range.
         * @param treeRightIdx The right compressed index of the node's range.
         * @param result The list to accumulate merged intervals.
         */
        private void findIntervalsRecursive(int pos, int treeLeftIdx, int treeRightIdx, List<Interval> result) {
            // If this segment is not covered, nothing to add from here.
            if (covered[pos] == 0) {
                return;
            }

            // If the node itself is fully covered by a lazy value, or it's a leaf node.
            // This means its entire range is part of a single merged interval.
            if (count[pos] > 0 || treeLeftIdx == treeRightIdx) {
                int startCoord = xs[treeLeftIdx];
                int endCoord = xs[treeRightIdx + 1];

                // Attempt to merge with the last interval in the result list
                if (!result.isEmpty() && result.get(result.size() - 1).end == startCoord) {
                    result.get(result.size() - 1).end = endCoord;
                } else {
                    result.add(new Interval(startCoord, endCoord));
                }
                return;
            }

            // If not fully covered by lazy and not a leaf, it means coverage is fragmented,
            // so recurse to children to find contiguous covered segments.
            int mid = (treeLeftIdx + treeRightIdx) / 2;
            findIntervalsRecursive(pos * 2 + 1, treeLeftIdx, mid, result);    // Left child
            findIntervalsRecursive(pos * 2 + 2, mid + 1, treeRightIdx, result); // Right child
        }
    }

    // --- Main Solution Class ---
    public static class Solution {

        /**
         * Merges an array of initial non-overlapping intervals with a set of query intervals.
         *
         * @param initialIntervals An array of initial non-overlapping intervals.
         * @param queryIntervals An array of intervals to merge.
         * @return A list of the final non-overlapping merged intervals.
         */
        public List<Interval> mergeIntervals(List<Interval> initialIntervals, List<Interval> queryIntervals) {
            // 1. Collect all unique coordinates for compression.
            List<Interval> allIntervals = new ArrayList<>();
            allIntervals.addAll(initialIntervals);
            allIntervals.addAll(queryIntervals);

            // 2. Initialize Segment Tree with coordinate compression.
            SegmentTree segmentTree = new SegmentTree(allIntervals);

            // 3. Populate Segment Tree with initial intervals.
            // For each initial interval, update the segment tree with type = +1.
            for (Interval interval : initialIntervals) {
                if (interval.start < interval.end) { // Only consider valid intervals
                    segmentTree.update(interval.start, interval.end, 1, 0, 0, segmentTree.numElementaryIntervals - 1);
                }
            }

            // 4. Process Query Intervals.
            // For each query interval, update the segment tree with type = +1.
            for (Interval query : queryIntervals) {
                if (query.start <= query.end) { // Only consider valid intervals
                    segmentTree.update(query.start, query.end, 1, 0, 0, segmentTree.numElementaryIntervals - 1);
                }
            }

            // 5. Retrieve the final set of merged intervals from the segment tree.
            return segmentTree.getMergedIntervals();
        }
    }

    // --- Example Usage ---
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Simple merging
        List<Interval> initial1 = Arrays.asList(
                new Interval(1, 5),
                new Interval(10, 12),
                new Interval(15, 20)
        );
        List<Interval> queries1 = Arrays.asList(
                new Interval(4, 11) // Overlaps with [1,5] and [10,12]
        );
        System.out.println("Test Case 1:");
        System.out.println("Initial: " + initial1);
        System.out.println("Queries: " + queries1);
        System.out.println("Merged: " + solver.mergeIntervals(initial1, queries1)); // Expected: [[1, 12], [15, 20]]
        System.out.println("---");

        // Test Case 2: More complex merges
        List<Interval> initial2 = Arrays.asList(
                new Interval(0, 2),
                new Interval(4, 6),
                new Interval(8, 10)
        );
        List<Interval> queries2 = Arrays.asList(
                new Interval(1, 5),  // Merges [0,2] & [4,6] -> [0,6]
                new Interval(7, 9),  // Merges [8,10] -> [7,10]
                new Interval(3, 7)   // Merges [0,6] & [7,10] (indirectly) -> [0,10]
        );
        System.out.println("Test Case 2:");
        System.out.println("Initial: " + initial2);
        System.out.println("Queries: " + queries2);
        System.out.println("Merged: " + solver.mergeIntervals(initial2, queries2)); // Expected: [[0, 10]]
        System.out.println("---");

        // Test Case 3: Query in a gap
        List<Interval> initial3 = Arrays.asList(
                new Interval(1, 3),
                new Interval(7, 9)
        );
        List<Interval> queries3 = Arrays.asList(
                new Interval(4, 6) // Fills a gap
        );
        System.out.println("Test Case 3:");
        System.out.println("Initial: " + initial3);
        System.out.println("Queries: " + queries3);
        System.out.println("Merged: " + solver.mergeIntervals(initial3, queries3)); // Expected: [[1, 3], [4, 6], [7, 9]]
        System.out.println("---");

        // Test Case 4: Overlapping queries
        List<Interval> initial4 = Arrays.asList(
                new Interval(10, 20),
                new Interval(2, 3)
        );
        List<Interval> queries4 = Arrays.asList(
                new Interval(15, 25),
                new Interval(5, 6)
        );
        System.out.println("Test Case 4:");
        System.out.println("Initial: " + initial4);
        System.out.println("Queries: " + queries4);
        System.out.println("Merged: " + solver.mergeIntervals(initial4, queries4)); // Expected: [[5, 25]]
        System.out.println("---");
    }
}
