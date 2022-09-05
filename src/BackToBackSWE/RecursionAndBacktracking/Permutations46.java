package BackToBackSWE.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {

    //Time: O(n!)
    //Space: O(n), n choices -> n depth
    public List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(nums, new ArrayList<>(), result);

        return result;
    }

    private void generate(int[] nums, List<Integer> partialResult, List<List<Integer>> result) {
        //base
        if (partialResult.size() == nums.length) {
            result.add(new ArrayList<>(partialResult));
        }

        for (int choice : nums) {
            if (partialResult.contains(choice)) {
                continue;
            }

            partialResult.add(choice);
            generate(nums, partialResult, result);
            partialResult.remove(partialResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations46 test = new Permutations46();
        int[] nums = {1, 2, 3};
        System.out.println(test.permutations(nums));
    }
}
