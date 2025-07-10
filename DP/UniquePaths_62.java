import java.util.*;
import java.io.*;

class UniquePaths_62 {

    private int rows,cols;
    private int[][] dp;

    private int solve(boolean[][] grid, int r, int c){

        if(r == rows-1 && c == cols-1)
            return 1;

        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c])
            return 0;

        if(dp[r][c] != -1)
            return dp[r][c];

        grid[r][c] = true;

        int ans = solve(grid, r+1,c) + solve(grid, r,c+1);

        grid[r][c] = false;

        return dp[r][c] = ans;
    }

    public int uniquePaths(int m, int n) {
        
        this.rows = m;
        this.cols = n;

        boolean[][] grid = new boolean[m][n];
        dp = new int[m][n];

        for(int[] row : dp)
            Arrays.fill(row,-1);

        return solve(grid, 0, 0);
    }
}