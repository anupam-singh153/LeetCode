class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {

                if (grid[i][j] == 1)
                    freshOranges += 1;

                else if (grid[i][j] == 2)
                    queue.add(new int[] { i, j });
            }
        }

        if (freshOranges == 0)
            return 0;

        int timeLine = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 1; i <= levelSize; ++i) {
                int[] pos = queue.poll();

                int r = pos[0];
                int c = pos[1];

                int[][] neighbours = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

                for (int[] neighbour : neighbours) {
                    int nr = r + neighbour[0];
                    int nc = c + neighbour[1];

                    if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1)
                        continue;

                    grid[nr][nc] = 2;
                    freshOranges -= 1;
                    queue.add(new int[] { nr, nc });
                }

                if (freshOranges == 0)
                    return timeLine + 1;
            }
            timeLine++;
        }

        if (freshOranges == 0)
            return timeLine;

        return -1;
    }
}
