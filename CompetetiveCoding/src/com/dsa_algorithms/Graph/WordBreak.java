package com.dsa_algorithms.Graph;
import java.util.*;
public class WordBreak {

    public static Boolean wordBreak(String[] arr, int n, String target) {
        // Write your code here.
        Set<String> wordSet = new HashSet<>(Arrays.asList(arr));

        // Step 2: Declare an empty queue and a HashMap for visited nodes
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        // Step 3: Push 0 to the queue
        queue.add(0);

        // Step 4: Run a loop until the queue is not empty
        while (!queue.isEmpty()) {
            // Step 5: Pop the top element of the queue
            int start = queue.poll();

            // Step 6: If the top element is not visited, mark it as visited
            if (!visited.getOrDefault(start, false)) {
                visited.put(start, true);

                // Step 7: Run a loop from j = top element till the length of the target string
                for (int end = start + 1; end <= target.length(); end++) {
                    // Step 8: If the suffix of the string starting from j exists in the hashmap, push j to the queue
                    if (wordSet.contains(target.substring(start, end))) {
                        queue.add(end);

                        // Step 9: If j = length of target string, return true
                        if (end == target.length()) {
                            return true;
                        }
                    }
                }
            }
        }

        // Step 10: If no solution exists, return false
        return false;
    }
}
