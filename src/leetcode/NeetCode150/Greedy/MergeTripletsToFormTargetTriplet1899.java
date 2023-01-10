package leetcode.NeetCode150.Greedy;

public class MergeTripletsToFormTargetTriplet1899 {

    // Time: O(N), N: triplets.length
    // Space: O(1)
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] greedy = new boolean[3];

        for (int[] triplet : triplets) {
            if (isValid(triplet, target)) {
                for (int i = 0; i < 3; i++) {
                    if (triplet[i] == target[i]) {
                        greedy[i] = true;
                    }
                }
            }
        }

        return greedy[0] && greedy[1] && greedy[2];
    }

    private boolean isValid(int[] triplet, int[] target) {
        return triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2];
    }
}
