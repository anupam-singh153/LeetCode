class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int noOfIslands = 0;

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){

                 if(grid[i][j] == '1' && !vis[i][j]){
                    solve(grid,vis,i,j);
                    noOfIslands += 1;
                 }
            }
        }

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                System.out.print(vis[i][j]+" ");
            }
            System.out.println();
        }

        return noOfIslands;
    }

    public void solve(char[][] grid,boolean[][] vis,int row,int col){

        int m = grid.length;
        int n = grid[0].length;

        if(row < 0 || col < 0 || row >= m || col >= n || grid[row][col] != '1' || vis[row][col])
            return;

        vis[row][col] = true;

        //Go Upward
        solve(grid,vis,row-1,col);

        //Go LeftWard
        solve(grid,vis,row,col-1);

        //Go DownWard
        solve(grid,vis,row+1,col);

        //Go RightWard
        solve(grid,vis,row,col+1);
    }
}
