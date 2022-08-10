package BackToBackSWE.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateThePowerSet78 {

    //branch factor: 2, depth: n
    //Time: O(2^n) :O(1), n: length of the inputSet
    //Space: O(n), the amount of space used by the recursion stack
    public List<List<Integer>> powerSet(int[] inputSet) {
        List<List<Integer>> result = new ArrayList<>();
        generate(0, new ArrayList<>(), inputSet, result);
        return result;
    }

    private void generate(int currentIndex, List<Integer> partialAnswer, int[] inputSet, List<List<Integer>> answer) {
        //base case:  Time: O(n)
        if(currentIndex == inputSet.length) {
            answer.add(new ArrayList<>(partialAnswer));
            return;
        }

        //O(1)
        partialAnswer.add(inputSet[currentIndex]);
        generate(currentIndex + 1, partialAnswer, inputSet, answer);
        partialAnswer.remove(partialAnswer.size() - 1);
        generate(currentIndex + 1, partialAnswer, inputSet, answer);

    }
}
