class Solution {

    private boolean isSafe(char[][] board, int r, int c) {

        for (int i = 0; i < r; ++i) {

            if (board[i][c] == 'Q')
                return false;
        }

        for (int j = 0; j < c; ++j) {

            if (board[r][j] == 'Q')
                return false;
        }

        //North-West
        int i = r;
        int j = c;

        while (i >= 0 && j >= 0) {

            if (board[i][j] == 'Q')
                return false;

            i--;
            j--;
        }

        //North-East
        i = r;
        j = c;

        while (i >= 0 && j < board.length) {

            if (board[i][j] == 'Q')
                return false;

            i--;
            j++;
        }

        return true;
    }

    private void fuck(char[][] board, int r,
            List<List<String>> result) {

        if (r == board.length) {
            List<String> tuple = new ArrayList<>();

            for (int i = 0; i < board.length; ++i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; ++j) {
                    sb.append(board[i][j]);
                }
                tuple.add(sb.toString());
            }

            result.add(tuple);
            return;
        }

        for (int c = 0; c < board.length; ++c) {

            if (isSafe(board, r, c)) {
                board[r][c] = 'Q';
                fuck(board, r + 1, result);
                board[r][c] = '.';
            }
        }

        return;
    }

    public List<List<String>> solveNQueens(int N) {

        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[N][N];

        for (char[] row : board)
            Arrays.fill(row, '.');

        fuck(board, 0, result);
        return result;
    }
}
