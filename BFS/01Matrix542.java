class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int M = mat.length;
        int N = mat[0].length;
        int[][] result = new int[M][N];

        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < M; ++r) {
            for (int c = 0; c < N; ++c) {

                if (mat[r][c] == 0)
                    queue.add(new int[] { r, c });
                else
                    result[r][c] = -1;
            }
        }

        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int offset = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 1; i <= levelSize; ++i) {
                int[] curr = queue.poll();

                for (int[] d : dir) {
                    int nr = d[0] + curr[0];
                    int nc = d[1] + curr[1];

                    if (nr >= 0 && nc >= 0 && nr < M && nc < N && result[nr][nc] == -1) {
                        result[nr][nc] = 1 + offset;
                        queue.add(new int[] { nr, nc });
                    }
                }
            }

            offset++;
        }

        return result;
    }
}
