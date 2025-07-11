import java.util.*;
import java.io.*;

class HouseRobberII_213 {

    private int[][] dp;

    private int solve(int[] nums, int s, int e){

        if(s > e)
            return 0;

        if(dp[s][e] != -1)
            return dp[s][e];

        //int include house
        int include = nums[s] + solve(nums, s+2,e);

        //skip house
        int exclude = solve(nums,s+1,e);

        return dp[s][e] = Math.max(include,exclude);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return nums[0];

        dp = new int[n][n];

        for(int[] row : dp)
            Arrays.fill(row,-1);

        return Math.max(solve(nums,0,n-2), solve(nums,1,n-1));
    }
}
