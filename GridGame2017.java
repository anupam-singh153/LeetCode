class Solution {
    public long gridGame(int[][] grid) {

        long firstRowSum = 0;
        int n = grid[0].length;

        for (int x : grid[0]) // calculate FirstRow Sum
            firstRowSum += x;

        long secRowSum = 0;
        firstRowSum -= grid[0][0];
        long ans = firstRowSum;

        for (int i = 1; i < n; ++i) {
            firstRowSum -= grid[0][i];
            secRowSum += grid[1][i - 1];

            ans = Math.min(ans, Math.max(firstRowSum, secRowSum));
        }
        return ans;
    }
}
