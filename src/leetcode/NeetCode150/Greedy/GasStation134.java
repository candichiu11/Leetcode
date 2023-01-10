package leetcode.NeetCode150.Greedy;

public class GasStation134 {

    // Time: O(N)
    // Space: O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;

        for (int g : gas) {
            sumGas += g;
        }

        for (int c : cost) {
            sumCost += c;
        }

        if (sumGas < sumCost) return -1;

        int n = gas.length;
        int total = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];

            if (total < 0) {
                total = 0;
                index = i + 1;
            }
        }
        return index;
    }
}
