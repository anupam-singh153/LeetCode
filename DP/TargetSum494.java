class Solution {
    int totSum = 0;
    int[][] dp;

    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;

        for(int x : nums)
            totSum += x;

        dp = new int[n+1][2*totSum+1];

        for(int[] row : dp)
            Arrays.fill(row,-1);

        return calWays(nums,target,0,0);
    }

    private int calWays(int[]nums, int target, int currIdx, int sum){

        if(currIdx == nums.length){
            return sum == target ? 1 : 0;
        }

        else if(dp[currIdx][totSum+sum] != -1)
            return dp[currIdx][totSum + sum];

        return dp[currIdx][totSum+sum] = calWays(nums,target,currIdx+1,sum+nums[currIdx]) + 
        calWays(nums,target,currIdx+1,sum-nums[currIdx]);
    }
}
