import java.util.*;
import java.io.*;

class UniquePathsII_63 {

    private int m,n;
    private int[][] dp;

    private int solve(int[][] grid, int r, int c){

        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 1 )
            return 0;

        if(r == m-1 && c == n-1)
            return 1;

        if(dp[r][c] != -1)
            return dp[r][c];

        int prev = grid[r][c];
        grid[r][c] = 1;

        int ans = solve(grid, r+1,c) + solve(grid, r,c+1);

        grid[r][c] = prev;

        return dp[r][c] = ans;
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        
        this.m = grid.length;
        this.n = grid[0].length;

        dp = new int[m][n];

        for(int[] row : dp)
            Arrays.fill(row,-1);

        return solve(grid, 0, 0);
    }
}