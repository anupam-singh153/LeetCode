class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = cost.length;
        int fuel = 0;
        int totalfuel = 0;
        int idx = 0;

        for (int i = 0; i < n; ++i) {

            fuel += gas[i] - cost[i];

            totalfuel += gas[i] - cost[i];

            if (fuel < 0) {
                fuel = 0;
                idx = i + 1;
            }
        }
        return (totalfuel >= 0) ? idx : -1;
    }
}
