package leetcode.NeetCode150.AdvancedGraphs;

import java.util.*;

public class ReconstructItinerary332 {

    // Time: O(E * log E/V) ?
    // Space: O(V + E) V: the number of airports, E: the number of flights
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

       // Priority Queue sorting, O(N * log N)
        //1. build adjacency list - graph
        for (List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);

            if (!graph.containsKey(departure)) {
                graph.put(departure, new PriorityQueue<>());
            }
            graph.get(departure).add(arrival);
        }

        //dfs
        dfs("JFK", graph, res);

        return res;
    }

    private void dfs(String departure, Map<String, PriorityQueue<String>> graph, LinkedList<String> res) {
        PriorityQueue<String> arrivals = graph.get(departure);

        // arrivals != null dead end case
        // arrivals.isEmpty() finish the poll() for the departure airport
        while (arrivals != null && !arrivals.isEmpty()) {
           dfs(arrivals.poll(), graph, res);
        }
        res.addFirst(departure);

    }
}
