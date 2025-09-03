class Solution {
    private static int M, N;
    private static int MOD = (int) (1e9 + 7);

    public int uniquePaths(int[][] grid) {
        M = grid.length;
        N = grid[0].length;

        int[][][] dp = new int[M][N][2];

        for (int[][] row : dp)
            for (int[] col : row)
                Arrays.fill(col, -1);

        long ans = Math.max(countPath(grid, 0, 0, 1, dp),
                countPath(grid, 0, 0, 0, dp));

        return (int) (ans % MOD);
    }

    public int countPath(int[][] grid, int i, int j,
            int dir, int[][][] dp) {

        if (i == M - 1 && j == N - 1)
            return 1;

        if (i >= M || j >= N)
            return 0;

        if (dp[i][j][dir] != -1)
            return dp[i][j][dir];

        long count = 0;

        if (grid[i][j] == 1) {
            if (dir == 1)
                count = countPath(grid, i + 1, j, 0, dp);
            else
                count = countPath(grid, i, j + 1, 1, dp);
        } else
            count = countPath(grid, i + 1, j, 0, dp) +
                    countPath(grid, i, j + 1, 1, dp);

        dp[i][j][dir] = (int) (count % 1000000007);

        return dp[i][j][dir];
    }
}
