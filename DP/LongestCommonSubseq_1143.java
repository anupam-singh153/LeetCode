import java.util.*;
import java.io.*;

class LongestCommonSubseq_1143 {
    //Memoization approach
    private int[][] dp;

    private int solve(String s,String t,int i,int j){

         if(i < 0 || j < 0) return 0;

         if(dp[i][j] != -1) return dp[i][j];

         int skip_from_first = solve(s,t,i-1,j);
         int skip_from_sec = solve(s,t,i,j-1);
        
         int ans = Math.max(skip_from_first,skip_from_sec);

         if(s.charAt(i) == t.charAt(j)){
            ans = Math.max(ans,1+solve(s,t,i-1,j-1));
         }

         return dp[i][j] = ans;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        dp = new int[m+1][n+1];

        for(int i = 0; i < m; ++i){
            Arrays.fill(dp[i],-1);
        }
        return solve(text1,text2,m-1,n-1);
    }
}
