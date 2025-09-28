class Solution {

    private static int N;

    private int solve(int[] costs, int i, int[] dp) {

        if (i == N)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int result = (int) (1e9 + 7);

        for (int k = 1; k <= 3; ++k) {

            if (i + k <= N)
                result = Math.min(result, costs[i + k - 1] + k * k + solve(costs, i + k, dp));
            else
                break;
        }

        return dp[i] = result;
    }

    public int climbStairs(int n, int[] costs) {

        N = n;
        int[] dp = new int[N];
        Arrays.fill(dp, -1);

        return solve(costs, 0, dp);
    }
}
