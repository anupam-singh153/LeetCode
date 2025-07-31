class Solution {

    private int solve(int[] coins, int i, int amount, int[][] dp) {

        if (i >= coins.length)
            return amount == 0 ? 1 : 0;

        if (dp[amount][i] != -1)
            return dp[amount][i];

        //include
        int include = 0;

        if (coins[i] <= amount)
            include = solve(coins, i, amount - coins[i], dp);
        //exclude
        int exclude = solve(coins, i + 1, amount, dp);

        return dp[amount][i] = include + exclude;
    }

    public int change(int amount, int[] coins) {

        int[][] dp = new int[amount + 1][coins.length];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(coins, 0, amount, dp);
    }
}
