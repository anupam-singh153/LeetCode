class Solution {

    private boolean check = false;

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {

                if (board[r][c] == word.charAt(0) || !vis[r][c]) {
                    search(board, vis, r, c, m, n, word, 0);

                    if (check)
                        return true;
                }
            }
        }

        return false;
    }

    private void search(char[][] board, boolean[][] vis, int r, int c, int m, int n, String word, int idx) {

        if (idx == word.length()) {
            this.check = true;
            return;
        }

        if (r < 0 || r >= m || c < 0 || c >= n || vis[r][c] || board[r][c] != word.charAt(idx))
            return;

        vis[r][c] = true;

        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            search(board, vis, nr, nc, m, n, word, idx + 1);

            if (check)
                return;
        }

        vis[r][c] = false;
        return;
    }
}
