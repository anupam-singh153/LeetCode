import java.util.*;
import java.io.*;

class PerfectSquares_279 {

    private int[] dp;

    private int solve(int n){

        if(n == 0)
            return 0;

        if(dp[n] != 0)
            return dp[n];

        int ans = (int)(1e8);

        for(int i = 1; i <= (int)Math.sqrt(n); ++i){

            ans = Math.min(ans, 1 + solve(n- i*i));
        }

        return dp[n] = ans;
    }

    public int numSquares(int n) {
        
        dp = new int[n+1];

        return solve(n);
    }
}
