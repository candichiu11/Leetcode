package leetcode.Level2.day11GraphBFSDFS;

import java.util.*;

public class BusRoute815 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
       if(source == target) return 0;

        //1. Create a hash map to store <bus stop, List of routes>
        Map<Integer, List<Integer>> map = new HashMap<>();

        //2. Build the map according to int[][] routes
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                List<Integer> busRoute = new ArrayList<>();
                busRoute.add(i);
                if(map.containsKey(routes[i][j])) {
                    map.get(routes[i][j]).addAll(busRoute);
                    map.put(routes[i][j], map.get(routes[i][j]));
                } else {
                    map.put(routes[i][j], busRoute);
                }
            }
        }

        queue.add(source);
        while(!queue.isEmpty()) {
            count++;

            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int curr = queue.poll();
                List<Integer> buses = map.get(curr);

                for(int bus : buses) {
                  if(!visited.contains(bus)) {
                      visited.add(bus);
                      for (int stop : routes[bus]) {
                          if (stop == target) {
                              return count;
                          }
                          queue.add(stop);
                      }
                  }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BusRoute815 test = new BusRoute815();
        int[][] routes = {{1,2,7},{3,6,7}};
        test.numBusesToDestination(routes, 1, 6);
    }
}
