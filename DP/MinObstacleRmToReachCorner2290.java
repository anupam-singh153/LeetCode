class Solution {

    int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int minimumObstacles(int[][] grid) {

        int M = grid.length;
        int N = grid[0].length;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] { 0, 0 });

        int[][] dp = new int[M][N];

        for (int[] row : dp)
            Arrays.fill(row, (int) 1e8);

        dp[0][0] = 0;

        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= M || nc < 0 || nc >= N)
                    continue;

                int newCost = dp[r][c] + grid[nr][nc];

                if (newCost < dp[nr][nc]) {
                    if (grid[nr][nc] == 1)
                        dq.addLast(new int[] { nr, nc });
                    else
                        dq.addFirst(new int[] { nr, nc });

                    dp[nr][nc] = newCost;
                }
            }
        }

        return dp[M - 1][N - 1];
    }
}
