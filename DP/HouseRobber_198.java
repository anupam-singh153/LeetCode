import java.util.*;
import java.io.*;

class HouseRobber_198 {
    private int solve(int[] nums,int idx,int[] dp){
         
        if(idx < 0) return 0;
        if(idx == 0) return nums[0];

        if(dp[idx] != -1) return dp[idx];

        return dp[idx] = Math.max(solve(nums,idx-1,dp),
                 nums[idx] + solve(nums,idx-2,dp)
        );
    }

    public int rob(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        int ans = solve(nums,n-1,dp);
        
        return ans;
    }
}
