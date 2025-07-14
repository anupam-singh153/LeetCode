import java.util.*;
import java.io.*;

class LongestIncSubseq_300 {

    private int[][] dp;

    private int solve(int[] nums, int c, int p){

        if(c >= nums.length)
            return 0;

        if(dp[c][p+1] != -1)
            return dp[c][p+1];

        int include = 0;

        if(p == -1 || nums[c] > nums[p])
            include = 1 + solve(nums,c+1,c);

        int exclude = solve(nums, c+1, p);

        return dp[c][p+1] = Math.max(include, exclude);
    }
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        dp = new int[n][n];

        for(int[] row : dp)
            Arrays.fill(row,-1);

        return solve(nums,0,-1);
    }
}
