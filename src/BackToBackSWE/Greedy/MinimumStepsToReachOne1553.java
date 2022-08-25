package BackToBackSWE.Greedy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumStepsToReachOne1553 {

    public int minimunSteps(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(n);
        int step = 0;

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == 0) {
                    return step -2;
                }

                if (visited.contains(curr)) {
                    continue;
                } else {
                    visited.add(curr);
                }

                queue.add(curr - 1);

                if (curr % 2 == 0) {
                    queue.add(curr / 2);
                }
            }
        }
        return step;
    }

    public static void main(String[] args) {
        MinimumStepsToReachOne1553 test = new MinimumStepsToReachOne1553();
        System.out.println(test.minimunSteps(7));
    }
}
