import java.util.*;
import java.io.*;

class LongestIncPathInMat_329 {

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] vis = new boolean[m][n];
        int[][] dp = new int[m][n];

        int ans = 0;

        for(int r = 0; r < m; ++r){
            for(int c = 0; c < n; ++c){

                    int len = dfs(matrix, vis, r, c, -1, dp);
                    ans = Math.max(ans,len);
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, boolean[][] vis, int r, int c, int prev, int[][] dp){
        
        int m = matrix.length;
        int n = matrix[0].length;

        if(r < 0 || r >= m || c < 0 || c >= n || vis[r][c] || matrix[r][c] <= prev)
            return 0;

        if(dp[r][c] != 0)
            return dp[r][c];

        vis[r][c] = true;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        int ans = 0;

        for(int i = 0; i < 4; ++i){

            ans = Math.max(ans, 1 + dfs(matrix, vis, r+dx[i], c+dy[i], matrix[r][c], dp));
        }

        vis[r][c] = false;
        return dp[r][c] = ans;
    }
}
