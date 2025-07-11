import java.util.*;
import java.io.*;

class BestTimeToBuyAndSellStock_121 {

    private int[][] dp;

    private int solve(int[] prices, int idx, int canBuy){

        if(idx >= prices.length || canBuy == -1)  return 0;
        if(dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int include = 0;

        if(canBuy == 1){
            include = -prices[idx] + solve(prices,idx+1,0);
        }else{
            include = prices[idx] + solve(prices,idx+1,-1);
        }

        int exclude = solve(prices,idx+1,canBuy);

        return dp[idx][canBuy] = Math.max(include,exclude);
    }
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        dp = new int[n][2];

        for(int[] row : dp)
            Arrays.fill(row,-1);

        return solve(prices,0,1);
    }
}
