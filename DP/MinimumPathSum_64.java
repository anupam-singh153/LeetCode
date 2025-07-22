class Solution {

    private int m, n;
    private int[][] dp;
  
    private int solve(int[][] grid, int row, int col){

        if(row == m-1 && col == n-1){
            return grid[row][col];
        }

        if(row >= m || col >= n)
           return Integer.MAX_VALUE;

        if(dp[row][col] != -1)
            return dp[row][col];

        int goRight = solve(grid, row, col+1);
        int goDown = solve(grid, row+1, col);

        return dp[row][col] = grid[row][col] + Math.min(goRight, goDown);
    }

    public int minPathSum(int[][] grid) {
        
        m = grid.length;
        n = grid[0].length;
        
        dp = new int[m][n];

        for(int[] row : dp)
            Arrays.fill(row,-1);

        return solve(grid,0,0);
    }
}
