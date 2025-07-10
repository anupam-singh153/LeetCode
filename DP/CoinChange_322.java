import java.util.*;
import java.io.*;

class CoinChange_322 {
    public int solve(int[] coins,int[] dp,int amt){

         if(amt < 0) return Integer.MAX_VALUE;
         if(amt == 0) return 0;
         
         if(dp[amt] != -1) return dp[amt];
         int minCoins = Integer.MAX_VALUE;
         for(int coin : coins){

              int reqCoins = solve(coins,dp,amt-coin);

              if(reqCoins != Integer.MAX_VALUE)
                minCoins = Math.min(minCoins,1+reqCoins);
         }

         return dp[amt] = minCoins;
    }
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);

        int minCoins = solve(coins,dp,amount);

        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
}