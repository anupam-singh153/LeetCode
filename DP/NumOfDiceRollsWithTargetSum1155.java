class Solution {

    private static final int MOD = (int) (1e9 + 7);

    private int solve(int N, int K, int target, int[][][] dp) {

        if (N == 0)
            return target == 0 ? 1 : 0;

        if (dp[N][K][target] != -1)
            return dp[N][K][target];

        int result = 0;

        for (int i = 1; i <= K; ++i) {

            if (i <= target)
                result = (result + solve(N - 1, K, target - i, dp)) % MOD;
        }

        return dp[N][K][target] = result;
    }

    public int numRollsToTarget(int n, int k, int target) {

        int[][][] dp = new int[n + 1][k + 1][target + 1];

        for (int[][] row : dp)
            for (int[] col : row)
                Arrays.fill(col, -1);

        return solve(n, k, target, dp);
    }
}
