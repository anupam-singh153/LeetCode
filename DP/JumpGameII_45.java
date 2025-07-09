import java.util.*;
import java.io.*;

class JumpGameII_45 {

    private int[] dp;

    private int solve(int[] nums, int idx) {

        if (idx >= nums.length)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int minJump = 10001;

        for (int i = 1; i <= nums[idx - 1]; ++i) {
            minJump = Math.min(minJump, 1 + solve(nums, idx + i));
        }

        return dp[idx] = minJump;
    }

    public int jump(int[] nums) {

        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(nums, 1);
    }
}
