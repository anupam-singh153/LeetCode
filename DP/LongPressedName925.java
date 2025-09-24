class Solution {

    private static int M, N;

    private boolean solve(String name, String typed, int i, int j, Boolean[][] dp) {

        if (j == N)
            return i == M;

        else if (i == M || name.charAt(i) != typed.charAt(j))
            return false;

        if (dp[i][j] != null)
            return dp[i][j];

        return dp[i][j] = solve(name, typed, i, j + 1, dp) || solve(name, typed, i + 1, j + 1, dp);
    }

    public boolean isLongPressedName(String name, String typed) {

        M = name.length();
        N = typed.length();

        Boolean[][] dp = new Boolean[M][N];

        return solve(name, typed, 0, 0, dp);
    }
}
