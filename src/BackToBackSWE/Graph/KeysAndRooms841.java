package BackToBackSWE.Graph;

import java.util.*;

public class KeysAndRooms841 {

    //BFS: Time: O(|V|+|E|) Space: O(|V|)
    //Time: O(n+k), n: the number of rooms, k: the number of keys
    //Space: O(n), n rooms in the queue [1, 2, 3...n]
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        queue.add(0);
        seen.add(0);

        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            List<Integer> roomsUnlocked = rooms.get(currentRoom);

            for(int unlockedRoom: roomsUnlocked) {
                queue.add(unlockedRoom);
                seen.add(unlockedRoom);

                if(rooms.size() == seen.size()) return true;
            }
        }

        return rooms.size() == seen.size();
    }
}
