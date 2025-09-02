class Solution {

    private boolean isSafe(char[][] board, int r, int c) {
        
        //In same Row
        for (int i = 0; i < r; ++i) {

            if (board[i][c] == 'Q')
                return false;
        }

        //In same Col
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

    private int fuck(char[][] board, int r, int N) {

        if (r == N)
            return 1;

        int result = 0;

        for (int c = 0; c < N; ++c) {

            if (isSafe(board, r, c)) {
                board[r][c] = 'Q';
                result += fuck(board, r + 1, N);
                board[r][c] = '.';
            }
        }

        return result;
    }

    public int totalNQueens(int N) {
        char[][] board = new char[N][N];

        for (char[] row : board)
            Arrays.fill(row, '.');

        return fuck(board, 0, N);
    }
}
