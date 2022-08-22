package BackToBackSWE.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ComputeBuildingsWithASunsetView1762 {

    //Time: O(n)
    //Space: O(n)
    public List<Integer> getBuildingsWithAView(int[] buildings) {
        Stack<Integer> buildingsWithAView = new Stack<>();
        List<Integer> indexes = new ArrayList<>();

        for (int j = 0; j < buildings.length; j++) {
            indexes.add(j);
        }

        for (int i = buildings.length - 1; i >= 0; i--) {
            while (!buildingsWithAView.isEmpty() && buildings[i] >= buildingsWithAView.peek()) {
                buildingsWithAView.pop();
                indexes.remove(i + 1);
            }

            buildingsWithAView.push(buildings[i]);
        }
        return indexes;
    }

    public static void main(String[] args) {
        ComputeBuildingsWithASunsetView1762 test = new ComputeBuildingsWithASunsetView1762();
        int[] buildings = {7, 4, 8, 2, 9};
        System.out.println(test.getBuildingsWithAView(buildings));
    }

}
