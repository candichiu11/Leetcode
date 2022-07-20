package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {

    public static void main ( String [ ] args ) {
        LastStoneWeight1046 ls = new LastStoneWeight1046();
        int[] stones = {500, 200, 100, 300, 1000};
        ls.lastStoneWeight(stones);
    }

    //Time: O(Nlog N) , Space: O(N)
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pr = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone: stones) {
            pr.add(stone);
        }

        //N: length of stones
        while(pr.size() > 1) {
            int heavyStone1 = pr.poll(); //O(log N)
            int heavyStone2 = pr.poll(); //O(log N)

            if(heavyStone1 != heavyStone2) {
                int newStone = heavyStone1 - heavyStone2;
                pr.add(newStone); //O(log N)
            }
        }

        return pr.isEmpty()? 0: pr.poll();
    }
}
